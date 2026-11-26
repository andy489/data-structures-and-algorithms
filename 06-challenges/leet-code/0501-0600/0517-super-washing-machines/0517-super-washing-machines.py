# https://leetcode.com/problems/super-washing-machines/

class Solution:
    def findMinMoves(self, machines: list[int]) -> int:
        total = sum(machines)
        n = len(machines)
        if total % n != 0:
            return -1
        avg = total // n
        ans = prefix_sum = 0
        for m in machines:
            balance = m - avg
            prefix_sum += balance
            ans = max(ans, abs(prefix_sum), balance)
        return ans
