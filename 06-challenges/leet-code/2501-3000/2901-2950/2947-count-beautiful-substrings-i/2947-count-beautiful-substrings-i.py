# https://leetcode.com/problems/count-beautiful-substrings-i/

class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        vowels_set = set('aeiou')
        n = len(s)
        count = 0
        for i in range(n):
            vowels = 0
            for j in range(i, n):
                if s[j] in vowels_set:
                    vowels += 1
                consonants = (j - i + 1) - vowels
                if vowels == consonants and (vowels * consonants) % k == 0:
                    count += 1
        return count
