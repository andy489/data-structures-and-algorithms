// https://leetcode.com/problems/remove-comments/

// Solution: State Machine — O(n·L) time, O(n·L) space
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            int i = 0;
            if (!inBlock) {
                buffer = new StringBuilder();
            }
            while (i < line.length()) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i += 2;
                    } else {
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i += 2;
                    } else {
                        buffer.append(line.charAt(i));
                        i++;
                    }
                }
            }
            if (!inBlock && buffer.length() > 0) {
                result.add(buffer.toString());
            }
        }
        return result;
    }
}
