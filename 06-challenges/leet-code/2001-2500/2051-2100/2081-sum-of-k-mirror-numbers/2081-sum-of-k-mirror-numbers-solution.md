# 2081. Sum of K-Mirror Numbers — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sum-of-k-mirror-numbers/

---

## Solution: Generate Palindromes in Base 10 — O(n * L) time, O(L) space

**Idea:** Generate base-10 palindromes in increasing order, check each in base-k.

**Algorithm:**
1. Enumerate base-10 palindromes by length.
2. For each, check if it's also a palindrome in base k.
3. Collect first n valid ones.

**Complexity:**

| | |
|---|---|
| Time | O(n * L) |
| Space | O(L) |
