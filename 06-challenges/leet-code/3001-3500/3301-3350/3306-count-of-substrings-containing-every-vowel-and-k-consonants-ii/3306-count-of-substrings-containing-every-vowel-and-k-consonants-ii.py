# https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/


class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        def at_least(min_k: int) -> int:
            vowels = set('aeiou')
            vowel_count = {}
            consonants = 0
            result = 0
            l = 0
            n = len(word)
            for r, c in enumerate(word):
                if c in vowels:
                    vowel_count[c] = vowel_count.get(c, 0) + 1
                else:
                    consonants += 1
                while len(vowel_count) == 5 and consonants >= min_k:
                    result += n - r
                    lc = word[l]
                    if lc in vowels:
                        vowel_count[lc] -= 1
                        if vowel_count[lc] == 0:
                            del vowel_count[lc]
                    else:
                        consonants -= 1
                    l += 1
            return result

        return at_least(k) - at_least(k + 1)
