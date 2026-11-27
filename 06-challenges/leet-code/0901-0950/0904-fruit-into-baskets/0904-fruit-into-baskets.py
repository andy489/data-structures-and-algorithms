# https://leetcode.com/problems/fruit-into-baskets/

class Solution:
    def totalFruit(self, fruits: list) -> int:
        count = {}
        left = result = 0
        for right, f in enumerate(fruits):
            count[f] = count.get(f, 0) + 1
            while len(count) > 2:
                lf = fruits[left]
                count[lf] -= 1
                if count[lf] == 0:
                    del count[lf]
                left += 1
            result = max(result, right - left + 1)
        return result
