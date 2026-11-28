# https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/

class Solution:
    def minTime(self, skill: list[int], mana: list[int]) -> int:
        n = len(skill)
        pref_skill = [0] * (n + 1)
        for i in range(n):
            pref_skill[i + 1] = pref_skill[i] + skill[i]

        done = [0] * n

        for mj in mana:
            # Find earliest start time t for this potion
            t = 0
            for i in range(n):
                t = max(t, done[i] - pref_skill[i] * mj)
            # Update finish times
            for i in range(n):
                done[i] = t + pref_skill[i + 1] * mj

        return done[n - 1]
