# https://leetcode.com/problems/prefix-and-suffix-search/

class WordFilter:
    def __init__(self, words: list[str]):
        self.lookup = {}
        for i, w in enumerate(words):
            n = len(w)
            for p in range(n + 1):
                for s in range(n + 1):
                    key = w[:p] + '#' + w[n - s:]
                    self.lookup[key] = i

    def f(self, pref: str, suff: str) -> int:
        return self.lookup.get(pref + '#' + suff, -1)
