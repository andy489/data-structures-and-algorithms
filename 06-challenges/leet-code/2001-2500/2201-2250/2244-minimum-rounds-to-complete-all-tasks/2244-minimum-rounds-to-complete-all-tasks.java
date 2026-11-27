// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int t : tasks) {
            freq.merge(t, 1, Integer::sum);
        }
        int rounds = 0;
        for (int cnt : freq.values()) {
            if (cnt == 1) {
                return -1;
            }
            rounds += (cnt + 2) / 3;
        }
        return rounds;
    }
}
