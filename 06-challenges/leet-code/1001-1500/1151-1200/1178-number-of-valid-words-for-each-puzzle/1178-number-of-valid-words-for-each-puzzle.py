# https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/

from collections import Counter

class Solution:
    def findNumOfValidWords(self, words: list[str], puzzles: list[str]) -> list[int]:
        freq = Counter()
        for word in words:
            mask = 0
            for c in word:
                mask |= 1 << (ord(c) - 97)
            freq[mask] += 1
        result = []
        for puzzle in puzzles:
            puzzle_mask = 0
            for c in puzzle:
                puzzle_mask |= 1 << (ord(c) - 97)
            first_bit = 1 << (ord(puzzle[0]) - 97)
            count = 0
            sub = puzzle_mask
            while sub:
                if sub & first_bit:
                    count += freq[sub]
                sub = (sub - 1) & puzzle_mask
            result.append(count)
        return result
