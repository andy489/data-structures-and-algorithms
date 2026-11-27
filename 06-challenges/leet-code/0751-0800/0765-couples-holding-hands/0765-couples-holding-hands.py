# https://leetcode.com/problems/couples-holding-hands/

class Solution:
    def minSwapsCouples(self, row: list[int]) -> int:
        swaps = 0
        for i in range(0, len(row), 2):
            partner = row[i] ^ 1
            if row[i + 1] == partner:
                continue
            for j in range(i + 2, len(row)):
                if row[j] == partner:
                    row[i + 1], row[j] = row[j], row[i + 1]
                    swaps += 1
                    break
        return swaps
