// https://leetcode.com/problems/find-subtree-sizes-after-changes/

// Solution: DFS + Ancestor Character Stack — O(n) time, O(n) space
class Solution {
    private List<Integer>[] origChildren;
    private List<Integer>[] finalChildren;
    private Deque<Integer>[] charStack;
    private int[] newParent;
    private int[] ans;
    private char[] s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s.toCharArray();
        origChildren = new List[n];
        finalChildren = new List[n];
        charStack = new Deque[26];
        newParent = new int[n];
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            origChildren[i] = new ArrayList<>();
            finalChildren[i] = new ArrayList<>();
            newParent[i] = parent[i];
        }
        for (int i = 0; i < 26; i++) charStack[i] = new ArrayDeque<>();
        for (int i = 1; i < n; i++) origChildren[parent[i]].add(i);

        dfsReparent(0);

        for (int i = 1; i < n; i++) finalChildren[newParent[i]].add(i);

        dfsSize(0);
        return ans;
    }

    private void dfsReparent(int x) {
        int c = s[x] - 'a';
        if (x != 0 && !charStack[c].isEmpty()) newParent[x] = charStack[c].peek();
        charStack[c].push(x);
        for (int child : origChildren[x]) dfsReparent(child);
        charStack[c].pop();
    }

    private void dfsSize(int x) {
        ans[x] = 1;
        for (int child : finalChildren[x]) {
            dfsSize(child);
            ans[x] += ans[child];
        }
    }
}
