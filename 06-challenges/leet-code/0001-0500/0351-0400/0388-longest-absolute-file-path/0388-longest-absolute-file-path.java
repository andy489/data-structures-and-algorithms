// https://leetcode.com/problems/longest-absolute-file-path/

// Solution: Stack of Prefix Lengths — O(n) time, O(n) space
class Solution {
    public int lengthLongestPath(String input) {
        int[] stack = new int[input.length() + 1];
        int maxLen = 0;
        for (String line : input.split("\n")) {
            int depth = 0;
            while (depth < line.length() && line.charAt(depth) == '\t') {
                depth++;
            }
            String name = line.substring(depth);
            stack[depth + 1] = stack[depth] + name.length() + 1;
            if (name.contains(".")) {
                maxLen = Math.max(maxLen, stack[depth + 1] - 1);
            }
        }
        return maxLen;
    }
}
