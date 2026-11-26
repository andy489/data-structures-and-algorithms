# 3039. Apply Operations to Make String Empty — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/apply-operations-to-make-string-empty/

---

## Solution: Frequency Analysis — O(n) time, O(n) space

**Idea:** The last round keeps characters with maximum frequency. Among those with max frequency, we keep the last occurrence in left-to-right traversal (since earlier ones are removed in earlier rounds). Traverse s from right to left collecting characters with max frequency, then reverse.

**Algorithm:**
1. Count frequencies.
2. maxFreq = max frequency.
3. Traverse s from right to left; add s[i] to result if freq[s[i]] == maxFreq (each char added once).
4. Reverse and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(n) — result string |
