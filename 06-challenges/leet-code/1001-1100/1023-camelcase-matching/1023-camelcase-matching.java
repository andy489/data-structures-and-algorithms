// https://leetcode.com/problems/camelcase-matching/

// Solution: Two Pointer — O(Q·N) time, O(1) space
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(matches(query, pattern));
        }
        return result;
    }

    private boolean matches(String query, String pattern) {
        int j = 0;
        for (char c : query.toCharArray()) {
            if (j < pattern.length() && c == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return j == pattern.length();
    }
}
