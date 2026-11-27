// https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/
class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String best = "";
        for (int i = 0; i < n; i++) {
            int maxLen = n - (numFriends - 1) - i;
            if (maxLen <= 0) {
                break;
            }
            String candidate = word.substring(i, i + maxLen);
            if (candidate.compareTo(best) > 0) {
                best = candidate;
            }
        }
        return best;
    }
}
