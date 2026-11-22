# https://leetcode.com/problems/isomorphic-strings/

# Solution: Bidirectional Map — O(n) time, O(1) space
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_to_t: dict[str, str] = {}
        t_to_s: dict[str, str] = {}

        for cs, ct in zip(s, t):
            if s_to_t.get(cs, ct) != ct or t_to_s.get(ct, cs) != cs:
                return False

            s_to_t[cs] = ct
            t_to_s[ct] = cs

        return True
