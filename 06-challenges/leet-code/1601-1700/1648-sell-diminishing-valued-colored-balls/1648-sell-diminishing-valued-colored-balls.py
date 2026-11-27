# https://leetcode.com/problems/sell-diminishing-valued-colored-balls/

class Solution:
    def maxProfit(self, inventory: list[int], orders: int) -> int:
        MOD = 10 ** 9 + 7
        inventory.sort()
        n = len(inventory)
        ans = 0
        count = 1
        for i in range(n - 1, -1, -1):
            cur = inventory[i]
            nxt = inventory[i - 1] if i > 0 else 0
            balls = (cur - nxt) * count
            if orders >= balls:
                # arithmetic sum from nxt+1 to cur, count times
                ans += count * (nxt + 1 + cur) * (cur - nxt) // 2
                orders -= balls
            else:
                full = orders // count
                rem = orders % count
                ans += count * (cur - full + 1 + cur) * full // 2
                ans += rem * (cur - full)
                orders = 0
                break
            count += 1
        return ans % MOD
