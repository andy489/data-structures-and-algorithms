// https://leetcode.com/problems/video-stitching/

// Solution: Greedy Jump Game — O(n + time) time, O(time) space
class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] maxEnd = new int[time + 1];
        for (int[] clip : clips) {
            if (clip[0] <= time) {
                maxEnd[clip[0]] = Math.max(maxEnd[clip[0]], clip[1]);
            }
        }
        int count = 0, curEnd = 0, nextEnd = 0;
        for (int i = 0; i < time; i++) {
            nextEnd = Math.max(nextEnd, maxEnd[i]);
            if (i == curEnd) {
                if (nextEnd <= curEnd) {
                    return -1;
                }
                count++;
                curEnd = nextEnd;
            }
        }
        return count;
    }
}
