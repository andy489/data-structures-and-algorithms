# https://leetcode.com/problems/online-election/

import bisect

class TopVotedCandidate:
    def __init__(self, persons: list, times: list):
        self.times = times
        n = len(persons)
        self.leaders = [0] * n
        votes = [0] * n
        lead = -1
        for i, p in enumerate(persons):
            votes[p] += 1
            if lead == -1 or votes[p] >= votes[lead]:
                lead = p
            self.leaders[i] = lead

    def q(self, t: int) -> int:
        idx = bisect.bisect_right(self.times, t) - 1
        return self.leaders[idx]
