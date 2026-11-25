# 728. Self Dividing Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/self-dividing-numbers/

---

## Solution: Brute Force Check — O((R-L)·d) time, O(1) space

**Idea:** For each number in [left, right], check every digit: if any digit is 0 or doesn't divide the number, skip it.

**Algorithm:**
1. For each `n` in `[left, right]`: check if all digits of n are non-zero and divide n.
2. Collect passing numbers.

**Complexity:**

| | |
|---|---|
| Time | O((R−L) · d) — d = max digits ≈ 4 for given constraints |
| Space | O(1) extra |
