# https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/

class Solution:
    def canThreePartsEqualSum(self, arr: list[int]) -> bool:
        total = sum(arr)
        if total % 3 != 0:
            return False
        target, parts, cur = total // 3, 0, 0
        for i in range(len(arr) - 1):
            cur += arr[i]
            if cur == target * (parts + 1):
                parts += 1
                if parts == 2:
                    return True
        return False
