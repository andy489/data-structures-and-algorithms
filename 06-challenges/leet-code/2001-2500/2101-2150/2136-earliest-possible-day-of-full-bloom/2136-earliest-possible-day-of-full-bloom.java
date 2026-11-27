// https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // Sort by growTime descending
        Arrays.sort(indices, (a, b) -> growTime[b] - growTime[a]);
        int currentDay = 0, maxBloom = 0;
        for (int i : indices) {
            currentDay += plantTime[i];
            int bloomDay = currentDay + growTime[i];
            maxBloom = Math.max(maxBloom, bloomDay);
        }
        return maxBloom;
    }
}
