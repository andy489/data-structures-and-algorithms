# https://leetcode.com/problems/reformat-date/

class Solution:
    MONTHS = {"Jan": 1, "Feb": 2, "Mar": 3, "Apr": 4, "May": 5, "Jun": 6,
              "Jul": 7, "Aug": 8, "Sep": 9, "Oct": 10, "Nov": 11, "Dec": 12}

    def reformatDate(self, date: str) -> str:
        day_str, month_str, year = date.split()
        day = int(''.join(c for c in day_str if c.isdigit()))
        month = self.MONTHS[month_str]
        return f"{year}-{month:02d}-{day:02d}"
