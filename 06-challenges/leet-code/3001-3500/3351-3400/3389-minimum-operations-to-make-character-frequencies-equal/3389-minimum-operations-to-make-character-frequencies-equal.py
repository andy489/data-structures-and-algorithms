# https://leetcode.com/problems/minimum-operations-to-make-character-frequencies-equal/

class Solution:
    def makeStringGood(self, s: str) -> int:
        freq = [0] * 26
        for c in s:
            freq[ord(c) - ord('a')] += 1

        max_freq = max(freq)
        ans = len(s)

        for k in range(max_freq + 1):
            cost = 0
            carry = 0
            for i in range(26):
                f = freq[i] + carry
                if k == 0:
                    cost += freq[i]
                    carry = 0
                elif f > k:
                    carry = f - k
                elif f < k:
                    cost += min(k - f, freq[i])
                    carry = 0
                else:
                    carry = 0
            ans = min(ans, cost)

        return ans
