# https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
class Solution:
    def numberOfBeams(self, bank: list[str]) -> int:
        result = 0
        prev = 0
        for row in bank:
            count = row.count('1')
            if count > 0:
                result += prev * count
                prev = count
        return result
