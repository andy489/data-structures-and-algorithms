# https://leetcode.com/problems/hand-of-straights/

from collections import Counter

class Solution:
    def isNStraightHand(self, hand: list[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        freq = Counter(hand)
        for key in sorted(freq):
            if freq[key] > 0:
                cnt = freq[key]
                for i in range(groupSize):
                    if freq[key + i] < cnt:
                        return False
                    freq[key + i] -= cnt
        return True
