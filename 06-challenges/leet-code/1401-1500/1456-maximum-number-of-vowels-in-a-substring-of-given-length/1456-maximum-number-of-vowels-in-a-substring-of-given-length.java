// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int cur = 0, max = 0;
        for (int i = 0; i < k; i++) if (vowels.contains(s.charAt(i))) cur++;
        max = cur;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) cur++;
            if (vowels.contains(s.charAt(i-k))) cur--;
            max = Math.max(max, cur);
        }
        return max;
    }
}
