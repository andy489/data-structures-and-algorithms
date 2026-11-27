// https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

// Solution: Greedy Replacement — O(n) time, O(n) space
class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if ((i == 0 || arr[i - 1] != c) && (i == n - 1 || arr[i + 1] != c)) {
                        arr[i] = c;
                        break;
                    }
                }
            }
        }
        return new String(arr);
    }
}
