# https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/
class Solution:
    def maxItems(self, items: list[list[int]], budget: int) -> int:
        n = len(items)
        # For each item i, count items j where factor_i | factor_j, j != i
        free_count = [0] * n
        by_factor: dict[int, list[int]] = {}
        for i, (f, _) in enumerate(items):
            by_factor.setdefault(f, []).append(i)

        for i in range(n):
            fi = items[i][0]
            mult = fi
            while mult <= n:
                if mult in by_factor:
                    free_count[i] += len(by_factor[mult])
                mult += fi
            free_count[i] -= 1  # exclude self

        min_price = min(p for _, p in items)

        # Sort by (1 + free_count[i]) / price[i] descending
        order = sorted(range(n), key=lambda i: (1 + free_count[i]) / items[i][1], reverse=True)

        total = 0
        remaining = budget
        for i in order:
            price = items[i][1]
            if price <= remaining:
                remaining -= price
                total += 1 + free_count[i]

        total += remaining // min_price
        return total
