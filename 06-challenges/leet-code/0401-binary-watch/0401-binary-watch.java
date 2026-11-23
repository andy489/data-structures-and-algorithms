// https://leetcode.com/problems/binary-watch/

// Solution: Bit Count Enumeration — O(1) time, O(1) space
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    times.add(h + ":" + String.format("%02d", m));
                }
            }
        }
        return times;
    }
}
