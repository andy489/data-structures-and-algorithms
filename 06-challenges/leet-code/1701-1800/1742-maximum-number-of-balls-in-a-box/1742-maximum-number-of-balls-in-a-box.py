# https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        count = [0] * 46
        for i in range(lowLimit, highLimit + 1):
            s = sum(int(d) for d in str(i))
            count[s] += 1
        return max(count)
