# https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

class Solution:
    def countValidWords(self, sentence: str) -> int:
        import re
        def valid(t):
            if not t:
                return False
            if re.search(r'\d', t):
                return False
            hyphens = [(i, c) for i, c in enumerate(t) if c == '-']
            if len(hyphens) > 1:
                return False
            if hyphens:
                i = hyphens[0][0]
                if i == 0 or i == len(t) - 1 or not t[i-1].isalpha() or not t[i+1].isalpha():
                    return False
            puncts = [(i, c) for i, c in enumerate(t) if c in '!.,']
            if len(puncts) > 1:
                return False
            if puncts and puncts[0][0] != len(t) - 1:
                return False
            return True
        return sum(1 for token in sentence.split() if valid(token))
