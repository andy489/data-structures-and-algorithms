// https://leetcode.com/problems/find-players-with-zero-or-one-losses/
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new TreeMap<>();
        for (int[] match : matches) {
            losses.putIfAbsent(match[0], 0);
            losses.merge(match[1], 1, Integer::sum);
        }
        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : losses.entrySet()) {
            if (entry.getValue() == 0) {
                noLoss.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                oneLoss.add(entry.getKey());
            }
        }
        return Arrays.asList(noLoss, oneLoss);
    }
}
