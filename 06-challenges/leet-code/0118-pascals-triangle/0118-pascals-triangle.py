# https://leetcode.com/problems/pascals-triangle/

# Solution 1: Iterative Row Construction
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        result = [[1]]
        for i in range(1, numRows):
            prev = result[-1]
            row = [1] + [prev[j - 1] + prev[j] for j in range(1, i)] + [1]
            result.append(row)
        return result


# Solution 2: Binomial Coefficient
class Solution2:
    def generate(self, numRows: int) -> List[List[int]]:
        result = []
        for i in range(numRows):
            row = [1]
            for j in range(1, i + 1):
                row.append(row[-1] * (i - j + 1) // j)
            result.append(row)
        return result

