# https://leetcode.com/problems/number-of-paths-with-max-score/

class Solution:
    def pathsWithMaxScore(self, board: list[str]) -> list[int]:
        MOD = 10**9 + 7
        n = len(board)
        score = [[0]*n for _ in range(n)]
        cnt = [[0]*n for _ in range(n)]
        cnt[n-1][n-1] = 1
        for i in range(n-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == n-1 and j == n-1:
                    continue
                c = board[i][j]
                if c == 'X':
                    continue
                val = 0 if c == 'E' else int(c)
                best_s, best_c = -1, 0
                for ni, nj in [(i+1,j),(i,j+1),(i+1,j+1)]:
                    if ni < n and nj < n and cnt[ni][nj] > 0:
                        if score[ni][nj] > best_s:
                            best_s, best_c = score[ni][nj], cnt[ni][nj]
                        elif score[ni][nj] == best_s:
                            best_c = (best_c + cnt[ni][nj]) % MOD
                if best_c > 0:
                    score[i][j] = best_s + val
                    cnt[i][j] = best_c
        if cnt[0][0] == 0:
            return [0, 0]
        return [score[0][0], cnt[0][0]]
