// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxOdd = Integer.MIN_VALUE, minEven = Integer.MAX_VALUE;
        for (int f : freq) {
            if (f == 0) {
                continue;
            }
            if (f % 2 == 1) {
                maxOdd = Math.max(maxOdd, f);
            } else {
                minEven = Math.min(minEven, f);
            }
        }
        return maxOdd - minEven;
    }
}
