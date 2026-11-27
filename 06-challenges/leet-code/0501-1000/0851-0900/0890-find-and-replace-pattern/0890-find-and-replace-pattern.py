# https://leetcode.com/problems/find-and-replace-pattern/

class Solution:
    def findAndReplacePattern(self, words: list[str], pattern: str) -> list[str]:
        def matches(word):
            wp, pw = {}, {}
            for w, p in zip(word, pattern):
                if wp.get(w, p) != p or pw.get(p, w) != w:
                    return False
                wp[w] = p; pw[p] = w
            return True
        return [w for w in words if matches(w)]
