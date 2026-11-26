# https://leetcode.com/problems/search-suggestions-system/

import bisect
class Solution:
    def suggestedProducts(self, products: list[str], searchWord: str) -> list[list[str]]:
        products.sort()
        res, prefix = [], ""
        for c in searchWord:
            prefix += c
            idx = bisect.bisect_left(products, prefix)
            res.append([p for p in products[idx:idx+3] if p.startswith(prefix)])
        return res
