// https://leetcode.com/problems/construct-k-palindrome-strings/

// Solution: Odd count check — O(n) time, O(1) space
class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c-'a']++;
        int odds = 0;
        for (int v : cnt) if (v % 2 == 1) odds++;
        return odds <= k;
    }
}
