# https://leetcode.com/problems/count-complete-substrings/
class Solution:
    def countCompleteSubstrings(self, word: str, k: int) -> int:
        def count_in_segment(s: str) -> int:
            result = 0
            n = len(s)
            for m in range(1, 27):
                window_size = m * k
                if window_size > n:
                    break
                freq = [0] * 26
                satisfied = 0
                for i in range(window_size):
                    c = ord(s[i]) - ord('a')
                    freq[c] += 1
                    if freq[c] == k:
                        satisfied += 1
                    elif freq[c] == k + 1:
                        satisfied -= 1
                if satisfied == m:
                    result += 1
                for i in range(window_size, n):
                    add_c = ord(s[i]) - ord('a')
                    freq[add_c] += 1
                    if freq[add_c] == k:
                        satisfied += 1
                    elif freq[add_c] == k + 1:
                        satisfied -= 1
                    rem_c = ord(s[i - window_size]) - ord('a')
                    freq[rem_c] -= 1
                    if freq[rem_c] == k - 1:
                        satisfied -= 1
                    elif freq[rem_c] == k:
                        satisfied += 1
                    if satisfied == m:
                        result += 1
            return result

        total = 0
        start = 0
        n = len(word)
        while start < n:
            end = start + 1
            while end < n and abs(ord(word[end]) - ord(word[end - 1])) <= 2:
                end += 1
            total += count_in_segment(word[start:end])
            start = end
        return total
