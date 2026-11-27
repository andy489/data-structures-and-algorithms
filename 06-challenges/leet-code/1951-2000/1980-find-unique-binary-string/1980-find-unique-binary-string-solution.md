# 1980. Find Unique Binary String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-unique-binary-string/

---

## Solution: Cantor's Diagonal Argument — O(n) time, O(1) extra space

**Idea:** Use Cantor's diagonalization: for each `i`, flip the `i`-th character of `nums[i]`. The resulting string differs from every string in `nums` at position `i`.

**Algorithm:**
1. For each index `i`, take the complement of `nums[i][i]`.
2. Concatenate these characters.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) for result |
