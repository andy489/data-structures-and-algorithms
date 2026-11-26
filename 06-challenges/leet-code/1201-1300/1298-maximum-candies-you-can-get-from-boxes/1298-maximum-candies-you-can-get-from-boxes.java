// https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/

// Solution: BFS — O(n) time, O(n) space
// Solution: BFS — O(n) time, O(n) space
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> opened = new HashSet<>(), possessed = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int b : initialBoxes) {
            possessed.add(b);
            if (status[b] == 1) q.add(b);
        }
        int total = 0;
        while (!q.isEmpty()) {
            int b = q.poll();
            total += candies[b];
            for (int k : keys[b]) {
                opened.add(k);
                if (possessed.contains(k)) q.add(k);
            }
            for (int cb : containedBoxes[b]) {
                possessed.add(cb);
                if (status[cb] == 1 || opened.contains(cb)) q.add(cb);
            }
        }
        return total;
    }
}
