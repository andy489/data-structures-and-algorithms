# https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/

class Solution:
    def maximumRequests(self, n: int, requests: list[list[int]]) -> int:
        r = len(requests)
        best = 0
        for mask in range(1 << r):
            delta = [0] * n
            cnt = bin(mask).count('1')
            for i in range(r):
                if mask >> i & 1:
                    delta[requests[i][0]] -= 1
                    delta[requests[i][1]] += 1
            if all(d == 0 for d in delta):
                best = max(best, cnt)
        return best
