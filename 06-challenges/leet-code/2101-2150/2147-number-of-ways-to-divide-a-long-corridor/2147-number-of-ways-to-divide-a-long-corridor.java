// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        List<Integer> seatIndices = new ArrayList<>();

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seatIndices.add(i);
            }
        }

        int total = seatIndices.size();
        if (total == 0 || total % 2 != 0) {
            return 0;
        }

        long result = 1;
        for (int i = 1; i < total / 2; i++) {
            int gap = seatIndices.get(2 * i) - seatIndices.get(2 * i - 1);
            result = (result * gap) % MOD;
        }

        return (int) result;
    }
}
