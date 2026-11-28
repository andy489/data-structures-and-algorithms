# https://leetcode.com/problems/shortest-matching-substring/

class Solution:
    def shortestMatchingSubstring(self, s: str, p: str) -> int:
        parts = p.split('*')
        a, b, c = parts[0], parts[1], parts[2]

        def kmp_find(text: str, pattern: str) -> list[int]:
            """Return list of end positions (exclusive) where pattern ends in text."""
            if not pattern:
                return list(range(len(text) + 1))
            m = len(pattern)
            lps = [0] * m
            j = 0
            for i in range(1, m):
                while j > 0 and pattern[i] != pattern[j]:
                    j = lps[j - 1]
                if pattern[i] == pattern[j]:
                    j += 1
                lps[i] = j
            result = []
            j = 0
            for i, ch in enumerate(text):
                while j > 0 and ch != pattern[j]:
                    j = lps[j - 1]
                if ch == pattern[j]:
                    j += 1
                if j == m:
                    result.append(i + 1)
                    j = lps[j - 1]
            return result

        a_ends = kmp_find(s, a)      # positions where a ends
        b_ends = kmp_find(s, b)      # positions where b ends
        c_starts = [e - len(c) for e in kmp_find(s, c)]  # starts of c

        if not a_ends or not b_ends or not c_starts:
            return -1
        if not a and not b and not c:
            return 0

        ans = float('inf')
        ai = 0
        ci = 0
        for be in b_ends:
            bs = be - len(b)
            # Find rightmost a_end <= bs
            while ai < len(a_ends) and a_ends[ai] <= bs:
                ai += 1
            # Find leftmost c_start >= be
            while ci < len(c_starts) and c_starts[ci] < be:
                ci += 1

            a_idx = ai - 1
            if a_idx < 0 and a:
                continue
            if ci >= len(c_starts) and c:
                break

            window_start = bs if not a else a_ends[a_idx] - len(a)
            window_end = be if not c else c_starts[ci] + len(c)
            ans = min(ans, window_end - window_start)

        return -1 if ans == float('inf') else ans
