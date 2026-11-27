// https://leetcode.com/problems/check-if-dfs-strings-are-palindromes/

class Solution {
    public boolean[] findAnswer(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }

        int[] start = new int[n];
        int[] end = new int[n];
        char[] dfsStr = new char[n];
        int[] timer = {0};

        // Iterative DFS (post-order)
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});
        int[] childIdx = new int[n];
        int[] entry = new int[n];
        Arrays.fill(entry, -1);

        // Use iterative post-order
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        int[] phase = new int[n]; // 0 = not started
        int pos = 0;
        int[] nodeStack = new int[n];
        int top = 0;
        // Iterative post-order DFS
        int[] iterStack = new int[n];
        int iterTop = 0;
        iterStack[iterTop++] = 0;
        int[] childPointer = new int[n];
        boolean[] visited = new boolean[n];

        pos = 0;
        iterTop = 0;
        iterStack[iterTop++] = 0;
        Arrays.fill(childPointer, 0);

        while (iterTop > 0) {
            int node = iterStack[iterTop - 1];
            if (!visited[node]) {
                visited[node] = true;
                start[node] = pos;
            }
            List<Integer> ch = children.get(node);
            if (childPointer[node] < ch.size()) {
                int child = ch.get(childPointer[node]++);
                iterStack[iterTop++] = child;
            } else {
                dfsStr[pos++] = s.charAt(node);
                end[node] = pos;
                iterTop--;
            }
        }

        // Build hash arrays for palindrome check
        long MOD1 = 1_000_000_007L;
        long BASE1 = 31L;
        long MOD2 = 998_244_353L;
        long BASE2 = 37L;

        long[] h1 = new long[n + 1];
        long[] h2 = new long[n + 1];
        long[] rh1 = new long[n + 1];
        long[] rh2 = new long[n + 1];
        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];
        pow1[0] = 1; pow2[0] = 1;
        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * BASE1 + (dfsStr[i] - 'a' + 1)) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + (dfsStr[i] - 'a' + 1)) % MOD2;
            pow1[i + 1] = pow1[i] * BASE1 % MOD1;
            pow2[i + 1] = pow2[i] * BASE2 % MOD2;
        }
        for (int i = n - 1; i >= 0; i--) {
            rh1[i] = (rh1[i + 1] * BASE1 + (dfsStr[i] - 'a' + 1)) % MOD1;
            rh2[i] = (rh2[i + 1] * BASE2 + (dfsStr[i] - 'a' + 1)) % MOD2;
        }

        boolean[] answer = new boolean[n];
        for (int i = 0; i < n; i++) {
            int l = start[i];
            int r = end[i]; // exclusive
            int len = r - l;
            // forward hash of dfsStr[l..r-1]
            long fwd1 = (h1[r] - h1[l] * pow1[len] % MOD1 + MOD1 * 2) % MOD1;
            long fwd2 = (h2[r] - h2[l] * pow2[len] % MOD2 + MOD2 * 2) % MOD2;
            // backward hash of dfsStr[l..r-1] = rh from r-1 down to l
            // rh1[i] = hash of dfsStr[i..n-1] in reverse order
            // reversed substring [l..r-1] reversed hash:
            long rev1 = (rh1[l] - rh1[r] * pow1[len] % MOD1 + MOD1 * 2) % MOD1;
            long rev2 = (rh2[l] - rh2[r] * pow2[len] % MOD2 + MOD2 * 2) % MOD2;
            answer[i] = (fwd1 == rev1 && fwd2 == rev2);
        }
        return answer;
    }
}
