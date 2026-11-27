// https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/

// Solution: Greedy with Queues — O(n) time, O(n) space
class Solution {
    public boolean isTransformable(String s, String t) {
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; i++) {
            pos[i] = new LinkedList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - '0'].offer(i);
        }
        for (char c : t.toCharArray()) {
            int d = c - '0';
            if (pos[d].isEmpty()) return false;
            int idx = pos[d].peek();
            for (int smaller = 0; smaller < d; smaller++) {
                if (!pos[smaller].isEmpty() && pos[smaller].peek() < idx) {
                    return false;
                }
            }
            pos[d].poll();
        }
        return true;
    }
}
