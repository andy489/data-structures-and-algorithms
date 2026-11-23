# 481. Magical String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/magical-string/

---

## Solution: Self-Generation — O(N) time, O(N) space

**Idea:** Build the magical string incrementally. Use a pointer `head` to read how many copies of the next digit to append. Toggle between 1 and 2.

**Algorithm:**
1. Start with `s = [1, 2, 2]`, `head = 2`.
2. While `s.length < n`: append `s[head]` copies of current digit; toggle digit; advance `head`.
3. Count 1s in `s[0..n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(N) |
| Space | O(N) — stored string |
