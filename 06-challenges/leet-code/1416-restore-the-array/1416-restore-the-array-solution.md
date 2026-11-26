# 1416. Restore The Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/restore-the-array/

---

## Solution: DP — O(n * log k) time, O(n) space

**Idea:** dp[i] = number of ways to split s[0..i-1]. For each position i, try all valid last segments ending at i.

**Algorithm:**
1. dp[0] = 1 (empty prefix).
2. For each i from 1 to n: try last segments of length 1 to log10(k)+1.
3. Skip if segment has leading zero or value > k.
4. dp[i] += dp[j] for valid start j.

**Complexity:**

| | |
|---|---|
| Time | O(n * log k) |
| Space | O(n) |
