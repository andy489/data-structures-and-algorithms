# 828. Count Unique Characters of All Substrings of a Given String — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

---

## Solution: Contribution Counting — O(n) time, O(26) space

**Idea:** Each character at index i contributes +1 to exactly those substrings where it is unique. For character at i with previous occurrence at `prev` and next occurrence at `next`, it contributes `(i - prev) * (next - i)` to the total.

**Algorithm:**
1. For each character, track the last two positions seen.
2. Contribution of position i = (i - last[c]) * (next[c] - i).
3. Sum all contributions.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(26) — last seen positions per character |
