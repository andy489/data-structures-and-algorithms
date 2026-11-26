# https://leetcode.com/problems/erect-the-fence/
class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        def cross(O, A, B):
            return (A[0] - O[0]) * (B[1] - O[1]) - (A[1] - O[1]) * (B[0] - O[0])

        trees.sort()
        hull = []
        for p in trees:
            while len(hull) >= 2 and cross(hull[-2], hull[-1], p) < 0:
                hull.pop()
            hull.append(p)
        upper = []
        for p in reversed(trees):
            while len(upper) >= 2 and cross(upper[-2], upper[-1], p) < 0:
                upper.pop()
            upper.append(p)
        return list({tuple(p) for p in hull + upper})
