# https://leetcode.com/problems/iterator-for-combination/

class CombinationIterator:
    def __init__(self, characters: str, combinationLength: int):
        from itertools import combinations
        self.combos = [''.join(c) for c in combinations(characters, combinationLength)]
        self.idx = 0
    def next(self) -> str:
        s = self.combos[self.idx]; self.idx += 1; return s
    def hasNext(self) -> bool:
        return self.idx < len(self.combos)
