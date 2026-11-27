# 167. Two Sum II - Input Array Is Sorted — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use left and right pointers. If the sum equals target, return. If less, move left pointer right to increase sum. If greater, move right pointer left to decrease sum.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
