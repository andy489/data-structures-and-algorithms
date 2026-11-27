// https://leetcode.com/problems/replace-all-digits-with-characters/

// Solution: Linear Scan — O(n) time, O(n) space
class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) (arr[i - 1] + (arr[i] - '0'));
        }
        return new String(arr);
    }
}
