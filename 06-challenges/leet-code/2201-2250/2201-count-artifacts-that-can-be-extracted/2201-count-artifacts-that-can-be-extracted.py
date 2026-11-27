# https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
class Solution:
    def digArtifacts(self, n: int, artifacts: List[List[int]], dig: List[List[int]]) -> int:
        excavated = set()
        for r, c in dig:
            excavated.add((r, c))
        count = 0
        for r1, c1, r2, c2 in artifacts:
            can_extract = True
            for r in range(r1, r2 + 1):
                for c in range(c1, c2 + 1):
                    if (r, c) not in excavated:
                        can_extract = False
                        break
                if not can_extract:
                    break
            if can_extract:
                count += 1
        return count
