# https://leetcode.com/problems/restore-ip-addresses/

class Solution:
    def restoreIpAddresses(self, s: str) -> list[str]:
        result = []

        def backtrack(start: int, parts: list[str]) -> None:
            if len(parts) == 4:
                if start == len(s):
                    result.append('.'.join(parts))
                return
            remaining = len(s) - start
            segments_left = 4 - len(parts)
            if remaining < segments_left or remaining > segments_left * 3:
                return
            for length in range(1, 4):
                if start + length > len(s):
                    break
                seg = s[start:start + length]
                if len(seg) > 1 and seg[0] == '0':
                    break
                if int(seg) > 255:
                    break
                parts.append(seg)
                backtrack(start + length, parts)
                parts.pop()

        backtrack(0, [])
        return result
