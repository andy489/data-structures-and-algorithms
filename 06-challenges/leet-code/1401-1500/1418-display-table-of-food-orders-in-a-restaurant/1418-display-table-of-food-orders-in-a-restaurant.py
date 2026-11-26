# https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/

class Solution:
    def displayTable(self, orders: list[list[str]]) -> list[list[str]]:
        from collections import defaultdict
        foods = sorted({o[2] for o in orders})
        tables = defaultdict(lambda: defaultdict(int))
        for _, tbl, food in orders:
            tables[int(tbl)][food] += 1
        res = [["Table"] + foods]
        for tbl in sorted(tables):
            row = [str(tbl)] + [str(tables[tbl][f]) for f in foods]
            res.append(row)
        return res
