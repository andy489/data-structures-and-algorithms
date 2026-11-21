# https://leetcode.com/problems/repeated-dna-sequences/

# Solution 1: HashMap of substrings — O(n) time, O(n) space
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> list[str]:
        if len(s) <= 10:
            return []
        seen: dict[str, int] = {}
        result = []
        for i in range(len(s) - 9):
            sub = s[i:i + 10]
            seen[sub] = seen.get(sub, 0) + 1
            if seen[sub] == 2:
                result.append(sub)
        return result


# Solution 2: Bit-encoding rolling hash — O(n) time, O(n) space
class Solution2:
    def findRepeatedDnaSequences(self, s: str) -> list[str]:
        n = len(s)
        if n <= 10:
            return []
        encode = {'A': 0, 'C': 1, 'G': 2, 'T': 3}
        MASK = (1 << 20) - 1
        h = 0
        for c in s[:10]:
            h = (h << 2) | encode[c]
        seen: set[int] = {h}
        added: set[int] = set()
        result = []
        for i in range(10, n):
            h = ((h << 2) | encode[s[i]]) & MASK
            if h in seen and h not in added:
                result.append(s[i - 9:i + 1])
                added.add(h)
            else:
                seen.add(h)
        return result
