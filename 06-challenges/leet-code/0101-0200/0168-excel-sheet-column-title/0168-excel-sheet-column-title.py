# https://leetcode.com/problems/excel-sheet-column-title/

class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        result = []
        while columnNumber > 0:
            columnNumber -= 1
            result.append(chr(ord('A') + columnNumber % 26))
            columnNumber //= 26
        return ''.join(reversed(result))


class Solution2:
    def convertToTitle(self, columnNumber: int) -> str:
        if columnNumber == 0:
            return ''
        columnNumber -= 1
        return self.convertToTitle(columnNumber // 26) + chr(ord('A') + columnNumber % 26)
