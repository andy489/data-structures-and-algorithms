# https://leetcode.com/problems/day-of-the-week/

# Solution: Day Count from Anchor Date — O(1) time, O(1) space
class Solution:
    DAYS = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
    MONTH_DAYS = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
        def is_leap(y):
            return (y % 4 == 0 and y % 100 != 0) or (y % 400 == 0)

        total = 0
        for y in range(1971, year):
            total += 366 if is_leap(y) else 365
        for m in range(1, month):
            total += self.MONTH_DAYS[m - 1]
            if m == 2 and is_leap(year):
                total += 1
        total += day
        return self.DAYS[(4 + total) % 7]


# Solution 2: Tomohiko Sakamoto's Algorithm — O(1) time, O(1) space
class Solution2:
    DAYS = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
    T = [0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4]

    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
        if month < 3:
            year -= 1
        d = (year + year // 4 - year // 100 + year // 400 + self.T[month - 1] + day) % 7
        return self.DAYS[d]
