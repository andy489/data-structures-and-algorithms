# 880. Decoded String at Index — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decoded-string-at-index/

---

## Solution: Reverse Scan — O(n) time, O(1) space

**Idea:** Compute decoded length up to each character. Then scan backwards to find the kth character by reducing k using modular arithmetic.

**Algorithm:**
1. Forward pass: compute running size (letters add 1, digits multiply).
2. Backward pass with current size: reduce k = k % size. If k==0 and s[i] is letter, return it. If digit, size /= digit; else size--.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
