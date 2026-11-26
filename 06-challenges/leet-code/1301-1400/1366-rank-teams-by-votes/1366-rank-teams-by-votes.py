# https://leetcode.com/problems/rank-teams-by-votes/

class Solution:
    def rankTeams(self, votes: list[str]) -> str:
        m = len(votes[0])
        cnt = {c: [0]*m for c in votes[0]}
        for vote in votes:
            for i, c in enumerate(vote):
                cnt[c][i] += 1
        return ''.join(sorted(cnt, key=lambda c: ([-x for x in cnt[c]], c)))
