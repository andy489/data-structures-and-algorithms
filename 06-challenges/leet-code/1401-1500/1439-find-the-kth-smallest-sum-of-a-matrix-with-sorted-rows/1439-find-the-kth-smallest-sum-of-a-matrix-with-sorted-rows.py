# https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

class Solution:
    def kthSmallest(self, mat: list[list[int]], k: int) -> int:
        import heapq
        candidates = sorted(mat[0])[:k]
        for row in mat[1:]:
            new_sums = []
            for c in candidates:
                for v in row:
                    heapq.heappush(new_sums, c + v)
                    if len(new_sums) > k:
                        heapq.heappop(new_sums)
            candidates = sorted(new_sums)
        return candidates[k - 1]
