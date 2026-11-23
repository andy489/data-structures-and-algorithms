# 553. Optimal Division — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/optimal-division/

---

## Solution: Greedy Math — O(n) time, O(n) space

**Idea:** To maximize `nums[0] / (nums[1] / nums[2] / ... / nums[n-1])`, note that `nums[1] / nums[2] / ...` is minimized when the denominator of `nums[1]`'s division is maximized. The denominator is maximized by putting all remaining numbers in the denominator of `nums[1]`, i.e., `nums[0] / (nums[1] / (nums[2] * ... * nums[n-1]))` = `nums[0] * nums[2] * ... * nums[n-1] / nums[1]`.

For n=1: return `nums[0]`. For n=2: return `nums[0]/nums[1]`. For n≥3: return `nums[0]/(nums[1]/nums[2]/.../nums[n-1])` = wrap 1..n-1 in parentheses after the slash.

**Complexity:**

| | |
|---|---|
| Time | O(n) — string building |
| Space | O(n) — output string |
