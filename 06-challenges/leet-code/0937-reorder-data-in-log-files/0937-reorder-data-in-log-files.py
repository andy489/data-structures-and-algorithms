# https://leetcode.com/problems/reorder-data-in-log-files/

class Solution:
    def reorderLogFiles(self, logs: list) -> list:
        letters, digits = [], []
        for log in logs:
            id_, rest = log.split(' ', 1)
            if rest[0].isdigit():
                digits.append(log)
            else:
                letters.append((rest, id_, log))
        letters.sort()
        return [log for _, _, log in letters] + digits
