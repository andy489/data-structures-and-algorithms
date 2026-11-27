# https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

class Solution:
    def minMovesToSeat(self, seats: list[int], students: list[int]) -> int:
        return sum(abs(s - t) for s, t in zip(sorted(seats), sorted(students)))
