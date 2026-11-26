# https://leetcode.com/problems/vowel-spellchecker/

import re

class Solution:
    def spellchecker(self, wordlist: list[str], queries: list[str]) -> list[str]:
        def mask(w):
            return re.sub('[aeiou]', '*', w.lower())

        exact = set(wordlist)
        lower_map = {}
        vowel_map = {}
        for w in wordlist:
            lower_map.setdefault(w.lower(), w)
            vowel_map.setdefault(mask(w), w)

        res = []
        for q in queries:
            if q in exact:
                res.append(q)
            elif q.lower() in lower_map:
                res.append(lower_map[q.lower()])
            else:
                res.append(vowel_map.get(mask(q), ''))
        return res
