# https://leetcode.com/problems/count-non-adjacent-subsets-in-a-rooted-tree/
from collections import defaultdict

class Solution:
    def countNonAdjacentSubsets(self, parent: list[int], nums: list[int], k: int) -> int:
        MOD = 10**9 + 7
        n = len(parent)
        children = defaultdict(list)
        for i in range(1, n):
            children[parent[i]].append(i)

        # dp[node] = dict[(included, rem)] -> count
        # or arrays: dp[node][2][k]
        dp = [[[0] * k for _ in range(2)] for _ in range(n)]

        def dfs(node: int) -> None:
            rem = nums[node] % k
            dp[node][1][rem] = 1
            dp[node][0][0] = 1  # empty subset

            for child in children[node]:
                dfs(child)
                merged = [[0] * k for _ in range(2)]
                for inc_n in range(2):
                    for rem_n in range(k):
                        if dp[node][inc_n][rem_n] == 0:
                            continue
                        val = dp[node][inc_n][rem_n]
                        for rem_c in range(k):
                            # child can be included or not
                            child_ways = (dp[child][0][rem_c] + dp[child][1][rem_c]) % MOD
                            new_rem = (rem_n + rem_c) % k
                            merged[inc_n][new_rem] = (merged[inc_n][new_rem] + val * child_ways) % MOD
                            # if node is included, subtract child included cases
                            if inc_n == 1:
                                merged[inc_n][new_rem] = (merged[inc_n][new_rem] - val * dp[child][1][rem_c]) % MOD
                dp[node] = merged

        dfs(0)
        ans = (dp[0][0][0] + dp[0][1][0] - 1 + MOD) % MOD
        return ans
