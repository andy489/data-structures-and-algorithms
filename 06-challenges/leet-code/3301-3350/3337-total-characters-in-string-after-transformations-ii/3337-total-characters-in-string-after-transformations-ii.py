# https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/

class Solution:
    def lengthAfterTransformations(self, s: str, t: int, nums: list[int]) -> int:
        MOD = 10**9 + 7
        SIZE = 26

        def mat_mul(A, B):
            C = [[0] * SIZE for _ in range(SIZE)]
            for i in range(SIZE):
                for k in range(SIZE):
                    if A[i][k] == 0:
                        continue
                    for j in range(SIZE):
                        C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD
            return C

        def mat_pow(M, p):
            result = [[1 if i == j else 0 for j in range(SIZE)] for i in range(SIZE)]
            while p > 0:
                if p & 1:
                    result = mat_mul(result, M)
                M = mat_mul(M, M)
                p >>= 1
            return result

        # Build transformation matrix
        M = [[0] * SIZE for _ in range(SIZE)]
        for i in range(SIZE):
            cnt = nums[i]
            for j in range(1, cnt + 1):
                M[(i + j) % SIZE][i] = (M[(i + j) % SIZE][i] + 1) % MOD

        Mt = mat_pow(M, t)

        freq = [0] * SIZE
        for c in s:
            freq[ord(c) - ord('a')] += 1

        ans = 0
        for i in range(SIZE):
            row_sum = sum(Mt[i][j] * freq[j] for j in range(SIZE)) % MOD
            ans = (ans + row_sum) % MOD
        return ans
