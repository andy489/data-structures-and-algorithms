# https://leetcode.com/problems/compare-version-numbers/

# Solution 1: Split — O(n+m) time, O(n+m) space
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1, v2 = version1.split('.'), version2.split('.')
        for i in range(max(len(v1), len(v2))):
            r1 = int(v1[i]) if i < len(v1) else 0
            r2 = int(v2[i]) if i < len(v2) else 0
            if r1 < r2:
                return -1
            if r1 > r2:
                return 1
        return 0
