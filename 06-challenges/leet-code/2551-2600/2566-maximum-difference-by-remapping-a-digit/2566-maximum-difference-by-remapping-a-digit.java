// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/

// Solution: String Replacement — O(d) time, O(d) space
class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        // Maximize: replace first non-9 digit with 9
        char toMax = 0;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                toMax = c;
                break;
            }
        }
        int maxVal = toMax == 0 ? num : Integer.parseInt(s.replace(toMax, '9'));
        // Minimize: replace first digit with 0
        int minVal = Integer.parseInt(s.replace(s.charAt(0), '0'));
        return maxVal - minVal;
    }
}
