# https://leetcode.com/problems/count-the-number-of-winning-sequences/

MOD = 10 ** 9 + 7


class Solution:
    def countWinningSequences(self, s: str) -> int:
        n = len(s)
        # F=0, W=1, E=2
        char_map = {'F': 0, 'W': 1, 'E': 2}
        # delta[bob][alice]: +1 if Bob wins, -1 if Alice wins, 0 tie
        delta = [[0, -1, 1], [1, 0, -1], [-1, 1, 0]]

        offset = n
        # dp[last][score+offset]
        dp = [[0] * (2 * n + 1) for _ in range(3)]
        alice0 = char_map[s[0]]
        for c in range(3):
            dp[c][delta[c][alice0] + offset] += 1

        for i in range(1, n):
            alice = char_map[s[i]]
            ndp = [[0] * (2 * n + 1) for _ in range(3)]
            for last in range(3):
                for sc in range(2 * n + 1):
                    if dp[last][sc] == 0:
                        continue
                    for c in range(3):
                        if c == last:
                            continue
                        d = delta[c][alice]
                        nsc = sc + d
                        if 0 <= nsc <= 2 * n:
                            ndp[c][nsc] = (ndp[c][nsc] + dp[last][sc]) % MOD
            dp = ndp

        return sum(dp[c][sc] for c in range(3) for sc in range(offset + 1, 2 * n + 1)) % MOD
