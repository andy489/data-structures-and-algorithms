# 2212. Maximum Points in an Archery Competition

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/maximum-points-in-an-archery-competition/

## Problem

Alice and Bob are opponents in an archery competition. Alice first shoots numArrows arrows and then Bob shoots numArrows arrows.

For each section k (0 to 11), if Alice has ak arrows and Bob has bk arrows:
- If ak >= bk, Alice takes k points.
- If ak < bk, Bob takes k points.
- If ak == bk == 0, nobody takes k points.

You are given numArrows and aliceArrows (size 12). Bob wants to maximize his total points.

Return bobArrows — the number of arrows Bob shot on each scoring section from 0 to 11. The sum of bobArrows should equal numArrows.

## Examples

**Example 1:**
```
Input: numArrows = 9, aliceArrows = [1,1,0,1,0,0,2,1,0,1,2,0]
Output: [0,0,0,0,1,1,0,0,1,2,3,1]
Explanation: Bob earns 4+5+8+9+10+11 = 47 points.
```

**Example 2:**
```
Input: numArrows = 3, aliceArrows = [0,0,1,0,0,0,0,0,0,0,0,2]
Output: [0,0,0,0,0,0,0,0,1,1,1,0]
Explanation: Bob earns 8+9+10 = 27 points.
```

## Constraints

- 1 <= numArrows <= 10⁵
- aliceArrows.length == bobArrows.length == 12
- 0 <= aliceArrows[i], bobArrows[i] <= numArrows
- sum(aliceArrows[i]) == numArrows
