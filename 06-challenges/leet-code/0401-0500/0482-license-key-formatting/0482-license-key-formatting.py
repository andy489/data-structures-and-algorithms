# https://leetcode.com/problems/license-key-formatting/

class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        clean = s.replace('-', '').upper()
        first_group = len(clean) % k
        parts = []
        if first_group > 0:
            parts.append(clean[:first_group])
        for i in range(first_group, len(clean), k):
            parts.append(clean[i:i + k])
        return '-'.join(parts)
