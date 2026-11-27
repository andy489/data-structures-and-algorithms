// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

// Solution: HashSet of Prefixes — O(n * D) time, O(n * D) space
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        for (int x : arr1) {
            while (x > 0) { prefixes.add(x); x /= 10; }
        }
        int maxLen = 0;
        for (int y : arr2) {
            while (y > 0) {
                if (prefixes.contains(y)) {
                    maxLen = Math.max(maxLen, String.valueOf(y).length());
                    break;
                }
                y /= 10;
            }
        }
        return maxLen;
    }
}
