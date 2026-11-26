// https://leetcode.com/problems/frog-jump/

// Solution: Dynamic Programming with HashSet — O(n²) time, O(n²) space
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> reachable = new HashMap<>();
        for (int stone : stones) {
            reachable.put(stone, new HashSet<>());
        }
        reachable.get(0).add(0);
        for (int stone : stones) {
            for (int k : reachable.get(stone)) {
                for (int delta = -1; delta <= 1; delta++) {
                    int nextJump = k + delta;
                    if (nextJump > 0 && reachable.containsKey(stone + nextJump)) {
                        reachable.get(stone + nextJump).add(nextJump);
                    }
                }
            }
        }
        return !reachable.get(stones[stones.length - 1]).isEmpty();
    }
}
