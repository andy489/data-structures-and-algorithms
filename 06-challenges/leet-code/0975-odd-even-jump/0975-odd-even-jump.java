// https://leetcode.com/problems/odd-even-jump/

// Solution: Monotonic Stack + DP — O(n log n) time, O(n) space
class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int[] nextOdd = new int[n], nextEven = new int[n];
        Arrays.fill(nextOdd, -1);
        Arrays.fill(nextEven, -1);

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) { idx[i] = i; }

        // Odd jumps: sort by value asc, then index asc
        Arrays.sort(idx, (a, b) -> arr[a] != arr[b] ? arr[a] - arr[b] : a - b);
        fillNext(idx, nextOdd);

        // Even jumps: sort by value desc, then index asc
        Arrays.sort(idx, (a, b) -> arr[a] != arr[b] ? arr[b] - arr[a] : a - b);
        fillNext(idx, nextEven);

        boolean[] oddOk = new boolean[n], evenOk = new boolean[n];
        oddOk[n - 1] = evenOk[n - 1] = true;
        int ans = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nextOdd[i] != -1) { oddOk[i] = evenOk[nextOdd[i]]; }
            if (nextEven[i] != -1) { evenOk[i] = oddOk[nextEven[i]]; }
            if (oddOk[i]) { ans++; }
        }
        return ans;
    }

    private void fillNext(Integer[] idx, int[] next) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : idx) {
            while (!stack.isEmpty() && stack.peek() < i) {
                next[stack.pop()] = i;
            }
            stack.push(i);
        }
    }
}
