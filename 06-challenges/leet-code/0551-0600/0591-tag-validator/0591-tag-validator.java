// https://leetcode.com/problems/tag-validator/
class Solution {
    public boolean isValid(String code) {
        Deque<String> tagStack = new ArrayDeque<>();
        int i = 0;
        int n = code.length();
        while (i < n) {
            if (i > 0 && tagStack.isEmpty()) {
                return false;
            }
            if (code.startsWith("<![CDATA[", i)) {
                int cdataEnd = code.indexOf("]]>", i + 9);
                if (cdataEnd == -1) {
                    return false;
                }
                i = cdataEnd + 3;
            } else if (code.startsWith("</", i)) {
                int tagEnd = code.indexOf('>', i);
                if (tagEnd == -1) {
                    return false;
                }
                String tagName = code.substring(i + 2, tagEnd);
                if (!isValidTagName(tagName)) {
                    return false;
                }
                if (tagStack.isEmpty() || !tagStack.peek().equals(tagName)) {
                    return false;
                }
                tagStack.pop();
                i = tagEnd + 1;
            } else if (code.startsWith("<", i)) {
                int tagEnd = code.indexOf('>', i);
                if (tagEnd == -1) {
                    return false;
                }
                String tagName = code.substring(i + 1, tagEnd);
                if (!isValidTagName(tagName)) {
                    return false;
                }
                tagStack.push(tagName);
                i = tagEnd + 1;
            } else {
                i++;
            }
        }
        return tagStack.isEmpty();
    }

    private boolean isValidTagName(String tag) {
        if (tag.isEmpty() || tag.length() > 9) {
            return false;
        }
        for (char c : tag.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }
}
