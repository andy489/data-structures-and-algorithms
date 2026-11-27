# https://leetcode.com/problems/groups-of-special-equivalent-strings/

class Solution:
    def numSpecialEquivGroups(self, words: list[str]) -> int:
        def key(w):
            return (sorted(w[::2]), sorted(w[1::2]))
        return len({str(key(w)) for w in words})
