# https://leetcode.com/problems/friends-of-appropriate-ages/

class Solution:
    def numFriendRequests(self, ages: list[int]) -> int:
        count = [0] * 121
        for a in ages:
            count[a] += 1
        requests = 0
        for a in range(1, 121):
            for b in range(1, 121):
                if b <= 0.5 * a + 7 or b > a or (b > 100 and a < 100):
                    continue
                requests += count[a] * count[b]
                if a == b:
                    requests -= count[a]
        return requests
