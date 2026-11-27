# https://leetcode.com/problems/corporate-flight-bookings/

# Solution: Difference Array — O(n + m) time, O(n) space
class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        diff = [0] * (n + 2)
        for first, last, seats in bookings:
            diff[first] += seats
            diff[last + 1] -= seats
        ans = []
        total = 0
        for i in range(1, n + 1):
            total += diff[i]
            ans.append(total)
        return ans
