# https://leetcode.com/problems/k-items-with-the-maximum-sum/
class Solution:
    def kItemsWithMaximumSum(self, numOnes: int, numZeros: int, numNegOnes: int, k: int) -> int:
        ones = min(k, numOnes)
        k -= ones
        zeros = min(k, numZeros)
        k -= zeros
        return ones - k
