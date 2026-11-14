# https://leetcode.com/problems/pascals-triangle-ii/

# Solution 1: In-Place Update (Right to Left)
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        row = [1]
        for i in range(1, rowIndex + 1):
            row.append(0)
            for j in range(i, 0, -1):
                row[j] += row[j - 1]
        return row


# Solution 2: Binomial Coefficient
class Solution2:
    def getRow(self, rowIndex: int) -> List[int]:
        row = [1]
        for j in range(1, rowIndex + 1):
            row.append(row[-1] * (rowIndex - j + 1) // j)
        return row
