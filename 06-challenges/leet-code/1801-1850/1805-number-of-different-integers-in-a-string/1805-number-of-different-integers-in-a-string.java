// https://leetcode.com/problems/number-of-different-integers-in-a-string/

// Solution: Regex Split + Strip Leading Zeros — O(n) time, O(n) space
class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> seen = new HashSet<>();
        int i = 0, n = word.length();
        while (i < n) {
            if (Character.isDigit(word.charAt(i))) {
                int j = i;
                while (j < n && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                // strip leading zeros
                int k = i;
                while (k < j - 1 && word.charAt(k) == '0') {
                    k++;
                }
                seen.add(word.substring(k, j));
                i = j;
            } else {
                i++;
            }
        }
        return seen.size();
    }
}
