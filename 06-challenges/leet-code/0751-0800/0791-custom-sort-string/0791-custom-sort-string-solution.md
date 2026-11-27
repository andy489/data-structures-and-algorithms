# 791. Custom Sort String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/custom-sort-string/

---

## Solution: Count and Build — O(n + m) time, O(1) space

**Idea:** Count character frequencies in `s`. Output characters in the order given by `order`, then append remaining characters not in `order`.

**Algorithm:**
1. Count frequencies of each character in `s`.
2. For each character in `order`, append it `freq[c]` times; zero out its count.
3. Append remaining characters.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — n = s.length, m = order.length |
| Space | O(1) — fixed 26-char frequency array |
