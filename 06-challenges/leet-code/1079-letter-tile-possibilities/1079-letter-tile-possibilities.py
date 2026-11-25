# https://leetcode.com/problems/letter-tile-possibilities/

class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        from collections import Counter
        freq = Counter(tiles)

        def dfs():
            count = 0
            for c in freq:
                if freq[c] > 0:
                    freq[c] -= 1
                    count += 1 + dfs()
                    freq[c] += 1
            return count

        return dfs()
