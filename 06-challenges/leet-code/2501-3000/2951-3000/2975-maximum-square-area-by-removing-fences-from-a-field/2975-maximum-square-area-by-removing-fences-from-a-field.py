# https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/
class Solution:
    def maximumArea(self, m: int, n: int, hFences: list[int], vFences: list[int]) -> int:
        MOD = 10 ** 9 + 7

        def compute_gaps(max_pos: int, fences: list[int]) -> set:
            positions = sorted([1] + fences + [max_pos])
            gaps = set()
            for i in range(len(positions)):
                for j in range(i + 1, len(positions)):
                    gaps.add(positions[j] - positions[i])
            return gaps

        h_gaps = compute_gaps(m, hFences)
        v_gaps = compute_gaps(n, vFences)
        common = h_gaps & v_gaps
        if not common:
            return -1
        best = max(common)
        return (best * best) % MOD
