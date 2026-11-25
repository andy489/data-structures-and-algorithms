# https://leetcode.com/problems/expressive-words/

class Solution:
    def expressiveWords(self, s: str, words: list[str]) -> int:
        def is_stretchy(w):
            i = j = 0
            while i < len(s) and j < len(w):
                if s[i] != w[j]:
                    return False
                sc = wc = 1
                while i + sc < len(s) and s[i + sc] == s[i]:
                    sc += 1
                while j + wc < len(w) and w[j + wc] == w[j]:
                    wc += 1
                if sc != wc and (sc < 3 or sc < wc):
                    return False
                i += sc
                j += wc
            return i == len(s) and j == len(w)

        return sum(is_stretchy(w) for w in words)
