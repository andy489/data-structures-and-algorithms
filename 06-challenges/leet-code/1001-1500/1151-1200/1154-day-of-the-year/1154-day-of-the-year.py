# https://leetcode.com/problems/day-of-the-year/

class Solution:
    def dayOfYear(self, date: str) -> int:
        year, month, day = int(date[:4]), int(date[5:7]), int(date[8:])
        days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if year % 4 == 0 and (year % 100 != 0 or year % 400 == 0):
            days[1] = 29
        return sum(days[:month - 1]) + day
