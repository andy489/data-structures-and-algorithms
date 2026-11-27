# https://leetcode.com/problems/longest-balanced-substring-after-one-swap/
class Solution:
    def longestBalancedSubstring(self, s: str) -> int:
        total0 = s.count('0')
        total1 = s.count('1')

        best = 0
        cnt0 = 0
        cnt1 = 0
        left = 0

        for right in range(len(s)):
            if s[right] == '0':
                cnt0 += 1
            else:
                cnt1 += 1

            # Shrink window while imbalance > 2
            while abs(cnt0 - cnt1) > 2:
                if s[left] == '0':
                    cnt0 -= 1
                else:
                    cnt1 -= 1
                left += 1

            length = right - left + 1
            if cnt0 == cnt1:
                best = max(best, length)
            elif cnt0 - cnt1 == 2 and (total1 - cnt1) >= 1:
                best = max(best, length - 1)
            elif cnt1 - cnt0 == 2 and (total0 - cnt0) >= 1:
                best = max(best, length - 1)

        # Result must be even
        if best % 2 != 0:
            best -= 1
        return best
