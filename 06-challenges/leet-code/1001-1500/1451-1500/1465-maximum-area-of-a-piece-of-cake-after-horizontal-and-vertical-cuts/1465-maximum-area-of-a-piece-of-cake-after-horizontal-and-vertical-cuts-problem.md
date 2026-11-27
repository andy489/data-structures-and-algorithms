# 1465. Maximum Area Of A Piece Of Cake After Horizontal And Vertical Cuts

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

---

## Problem Statement

Return the maximum area of a piece of cake after all horizontal and vertical cuts. Mod 10^9+7.

---

## Examples

**Example 1:**
```
Input:  h=5,w=4,horizontalCuts=[1,2,4],verticalCuts=[1,3]
Output: 4
```

**Example 2:**
```
Input:  h=5,w=4,horizontalCuts=[3,1],verticalCuts=[1]
Output: 6
```

**Example 3:**
```
Input:  h=5,w=4,horizontalCuts=[3],verticalCuts=[3]
Output: 9
```

---

## Constraints

- `2 <= h, w <= 10^9`
- `1 <= horizontalCuts.length <= min(h-1, 10^5)`
- `1 <= verticalCuts.length <= min(w-1, 10^5)`
