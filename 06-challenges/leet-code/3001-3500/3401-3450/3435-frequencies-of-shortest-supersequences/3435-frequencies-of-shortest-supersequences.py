# https://leetcode.com/problems/frequencies-of-shortest-supersequences/
class Solution:
    def supersequences(self, words: List[str]) -> List[List[int]]:
        # Map chars to indices
        char_idx = {}
        for w in words:
            for c in w:
                if c not in char_idx:
                    char_idx[c] = len(char_idx)
        m = len(char_idx)

        min_count = [1] * m
        has_edge = [[False] * m for _ in range(m)]

        for w in words:
            a = char_idx[w[0]]
            b = char_idx[w[1]]
            if a == b:
                min_count[a] = max(min_count[a], 2)
            else:
                has_edge[a][b] = True

        full = 1 << m
        INF = float('inf')
        dp = [INF] * full
        dp[0] = 0

        for mask in range(full):
            if dp[mask] == INF:
                continue
            for i in range(m):
                if mask & (1 << i):
                    continue
                extra = sum(1 for j in range(m) if (mask & (1 << j)) and has_edge[i][j])
                new_mask = mask | (1 << i)
                if dp[mask] + extra < dp[new_mask]:
                    dp[new_mask] = dp[mask] + extra

        min_extra = dp[full - 1]

        # Enumerate all orderings achieving min_extra
        result = set()

        def dfs(pos, mask, extra_count):
            if pos == m:
                freq = [0] * 26
                for c, idx in char_idx.items():
                    freq[ord(c) - ord('a')] = min_count[idx] + extra_count[idx]
                result.add(tuple(freq))
                return
            for i in range(m):
                if mask & (1 << i):
                    continue
                extra = sum(1 for j in range(m) if (mask & (1 << j)) and has_edge[i][j])
                new_mask = mask | (1 << i)
                if dp[mask] + extra <= min_extra and dp[new_mask] == dp[mask] + extra:
                    extra_count[i] += extra
                    dfs(pos + 1, new_mask, extra_count)
                    extra_count[i] -= extra

        dfs(0, 0, [0] * m)
        return [list(f) for f in result]
