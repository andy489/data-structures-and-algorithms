# https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution:
    def isAlienSorted(self, words: list[str], order: str) -> bool:
        rank = {c: i for i, c in enumerate(order)}
        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]
            for c1, c2 in zip(w1, w2):
                if rank[c1] < rank[c2]:
                    break
                if rank[c1] > rank[c2]:
                    return False
            else:
                if len(w1) > len(w2):
                    return False
        return True
