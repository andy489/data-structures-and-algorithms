# 611. Valid Triangle Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/valid-triangle-number/

---

## Solution: Sort + Two Pointers — O(n²) time, O(1) space

**Idea:** Sort the array. For each largest side `nums[k]`, use two pointers `i` and `j` to count pairs where `nums[i] + nums[j] > nums[k]`. Since array is sorted, if the condition holds for `j`, it holds for all indices between `i` and `j`.

**Algorithm:**
1. Sort nums.
2. For k from n-1 down to 2, set i=0, j=k-1.
3. If `nums[i]+nums[j] > nums[k]`: all pairs from i..j-1 with j are valid → add j-i to count, j--.
4. Else: i++.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — outer loop O(n), inner two-pointer O(n) |
| Space | O(1) — sort in-place |
