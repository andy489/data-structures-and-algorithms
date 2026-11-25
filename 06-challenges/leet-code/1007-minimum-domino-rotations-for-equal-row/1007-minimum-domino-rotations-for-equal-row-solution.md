# 1007. Minimum Domino Rotations For Equal Row — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

---

## Solution: Greedy Check — O(n) time, O(1) space

**Idea:** Only the value tops[0] or bottoms[0] can be the target value. Try each; count minimum rotations needed.

**Algorithm:**
1. For candidate value v in {tops[0], bottoms[0]}: check if each domino contains v.
2. Count rotations needed to put v on top vs bottom; take min.
3. Return min across both candidates, or -1 if neither works.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
