# https://leetcode.com/problems/minimum-index-sum-of-two-lists/
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        index_in_list1 = {s: i for i, s in enumerate(list1)}
        result = []
        min_sum = float('inf')
        for j, s in enumerate(list2):
            if s in index_in_list1:
                idx_sum = index_in_list1[s] + j
                if idx_sum < min_sum:
                    min_sum = idx_sum
                    result = [s]
                elif idx_sum == min_sum:
                    result.append(s)
        return result
