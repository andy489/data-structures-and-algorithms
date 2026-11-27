// https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
class Solution {
    public int convertTime(String current, String correct) {
        int curMin = toMinutes(current);
        int corMin = toMinutes(correct);
        int diff = corMin - curMin;
        int ops = 0;
        int[] increments = {60, 15, 5, 1};
        for (int inc : increments) {
            ops += diff / inc;
            diff %= inc;
        }
        return ops;
    }

    private int toMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60
                + Integer.parseInt(time.substring(3));
    }
}
