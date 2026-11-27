# https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
class Solution:
    def wordCount(self, startWords: list, targetWords: list) -> int:
        start_masks = set()
        for w in startWords:
            mask = 0
            for c in w:
                mask |= 1 << (ord(c) - ord('a'))
            start_masks.add(mask)
        count = 0
        for w in targetWords:
            mask = 0
            for c in w:
                mask |= 1 << (ord(c) - ord('a'))
            for i in range(26):
                if mask & (1 << i):
                    if (mask ^ (1 << i)) in start_masks:
                        count += 1
                        break
        return count
