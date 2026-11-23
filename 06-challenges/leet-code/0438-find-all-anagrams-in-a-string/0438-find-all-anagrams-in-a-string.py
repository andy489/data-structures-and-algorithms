# https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        result = []
        if len(s) < len(p):
            return result
        p_count = [0] * 26
        window_count = [0] * 26
        for c in p:
            p_count[ord(c) - ord('a')] += 1
        for c in s[:len(p)]:
            window_count[ord(c) - ord('a')] += 1
        matches = sum(1 for i in range(26) if p_count[i] == window_count[i])
        for right in range(len(p), len(s)):
            if matches == 26:
                result.append(right - len(p))
            add_idx = ord(s[right]) - ord('a')
            if window_count[add_idx] == p_count[add_idx]:
                matches -= 1
            window_count[add_idx] += 1
            if window_count[add_idx] == p_count[add_idx]:
                matches += 1
            remove_idx = ord(s[right - len(p)]) - ord('a')
            if window_count[remove_idx] == p_count[remove_idx]:
                matches -= 1
            window_count[remove_idx] -= 1
            if window_count[remove_idx] == p_count[remove_idx]:
                matches += 1
        if matches == 26:
            result.append(len(s) - len(p))
        return result
