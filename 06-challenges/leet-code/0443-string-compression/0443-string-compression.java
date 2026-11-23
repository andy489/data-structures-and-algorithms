// https://leetcode.com/problems/string-compression/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public int compress(char[] chars) {
        int read = 0, write = 0;
        while (read < chars.length) {
            char current = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }
            chars[write++] = current;
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }
        return write;
    }
}
