// https://leetcode.com/problems/lexicographical-numbers/

// Solution: DFS Trie Traversal — O(n) time, O(1) extra space
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int cur = 1;
        while (result.size() < n) {
            result.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                while (cur % 10 == 9 || cur + 1 > n) {
                    cur /= 10;
                }
                cur++;
            }
        }
        return result;
    }
}
