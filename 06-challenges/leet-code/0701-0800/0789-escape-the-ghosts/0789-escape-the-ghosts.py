# https://leetcode.com/problems/escape-the-ghosts/

class Solution:
    def escapeGhosts(self, ghosts: list[list[int]], target: list[int]) -> bool:
        my_dist = abs(target[0]) + abs(target[1])
        return all(abs(gx - target[0]) + abs(gy - target[1]) > my_dist for gx, gy in ghosts)
