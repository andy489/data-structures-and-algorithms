# 1422. Maximum Score After Splitting A String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-score-after-splitting-a-string/

---

## Solution: One Pass — O(n) time, O(1) space

**Idea:** total ones = count all 1s. Scan left to right: add 1 to score for each '0', subtract 1 for each '1' (it moved from right). Track max.

**Algorithm:**
1. Count total ones.
2. Scan from index 0 to n-2: score += (s[i]=='0') ? 1 : -1. Track max(score + totalOnes - ... wait).
3. Better: score = zeros_left - ones_left; at index i: ans = max(ans, score + totalOnes).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
