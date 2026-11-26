# https://leetcode.com/problems/apply-operations-to-make-string-empty/

class Solution:
    def lastNonEmptyString(self, s: str) -> str:
        from collections import Counter
        freq = Counter(s)
        max_freq = max(freq.values())
        seen = set()
        result = []
        for c in reversed(s):
            if freq[c] == max_freq and c not in seen:
                result.append(c)
                seen.add(c)
        return ''.join(reversed(result))
