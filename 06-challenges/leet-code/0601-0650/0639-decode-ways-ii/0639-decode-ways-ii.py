# https://leetcode.com/problems/decode-ways-ii/

class Solution:
    def numDecodings(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        prev2 = 1
        prev1 = 9 if s[0] == '*' else (0 if s[0] == '0' else 1)
        for i in range(1, len(s)):
            cur, pre = s[i], s[i - 1]
            single = 9 if cur == '*' else (0 if cur == '0' else 1)
            if pre == '*' and cur == '*':
                two = 15
            elif pre == '*':
                two = 2 if cur <= '6' else 1
            elif cur == '*':
                two = 9 if pre == '1' else (6 if pre == '2' else 0)
            else:
                two_num = int(pre) * 10 + int(cur)
                two = 1 if 10 <= two_num <= 26 else 0
            curr = (single * prev1 + two * prev2) % MOD
            prev2, prev1 = prev1, curr
        return prev1
