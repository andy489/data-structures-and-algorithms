# 1769. Minimum Number of Operations to Move All Balls to Each Box — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

---

## Solution: Two-Pass Prefix/Suffix — O(n) time, O(n) space

**Idea:** Compute contributions from balls to the left and from balls to the right separately using two passes. In the left-to-right pass, maintain a running count of balls seen so far; each step adds that count to the answer. The right-to-left pass does the same from the other direction.

**Algorithm:**
1. Left pass: traverse left to right. Maintain `balls` = count of `'1'`s seen so far and `ops` = total steps from those balls. At each index `i`, `ans[i] += ops`, then update `ops += balls` and `balls += (boxes[i] == '1')`.
2. Right pass: traverse right to left. Maintain `balls` and `ops` similarly. At each index `i`, `ans[i] += ops`, then update.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(n) — output array |
