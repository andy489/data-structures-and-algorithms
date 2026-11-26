# https://leetcode.com/problems/count-number-of-teams/

class Solution:
    def numTeams(self, rating: list[int]) -> int:
        n = len(rating)
        count = 0
        for j in range(1, n-1):
            ls = sum(1 for i in range(j) if rating[i] < rating[j])
            ll = sum(1 for i in range(j) if rating[i] > rating[j])
            rs = sum(1 for k in range(j+1, n) if rating[k] < rating[j])
            rl = sum(1 for k in range(j+1, n) if rating[k] > rating[j])
            count += ls*rl + ll*rs
        return count
