# https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/

class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> list[int]:
        def find_all(s, p):
            res, i = [], 0
            while (i := s.find(p, i)) != -1:
                res.append(i); i += 1
            return res
        list_a = find_all(s, a)
        list_b = find_all(s, b)
        result = []
        j = 0
        for i in list_a:
            while j < len(list_b) and list_b[j] < i - k:
                j += 1
            if j < len(list_b) and list_b[j] <= i + k:
                result.append(i)
        return result
