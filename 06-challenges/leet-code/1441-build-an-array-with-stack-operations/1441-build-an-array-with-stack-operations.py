# https://leetcode.com/problems/build-an-array-with-stack-operations/

class Solution:
    def buildArray(self, target: list[int], n: int) -> list[str]:
        t_set = set(target)
        ops = []
        for i in range(1, target[-1] + 1):
            ops.append("Push")
            if i not in t_set:
                ops.append("Pop")
        return ops
