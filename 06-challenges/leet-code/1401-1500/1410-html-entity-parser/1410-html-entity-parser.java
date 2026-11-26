// https://leetcode.com/problems/html-entity-parser/

// Solution: String Replace — O(n) time, O(n) space
class Solution {
    public String entityParser(String text) {
        return text.replace("&quot;", """)
                   .replace("&apos;", "'")
                   .replace("&gt;", ">")
                   .replace("&lt;", "<")
                   .replace("&frasl;", "/")
                   .replace("&amp;", "&");
    }
}
