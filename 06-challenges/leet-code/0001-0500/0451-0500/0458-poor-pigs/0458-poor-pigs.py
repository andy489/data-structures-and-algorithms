class Solution:
    def poorPigs(self, buckets: int, minutesToDie: int, minutesToTest: int) -> int:
        rounds = minutesToTest // minutesToDie
        pigs = 0
        while (rounds + 1) ** pigs < buckets:
            pigs += 1
        return pigs
