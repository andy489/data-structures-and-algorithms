# 1482. Minimum Number Of Days To Make M Bouquets

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

---

## Problem Statement

Return min days needed to make m bouquets, each with k adjacent bloomed flowers. Return -1 if impossible.

---

## Examples

**Example 1:**
```
Input:  bloomDay=[1,10,3,10,2],m=3,k=1
Output: 3
```

**Example 2:**
```
Input:  bloomDay=[1,10,3,10,2],m=3,k=2
Output: -1
```

**Example 3:**
```
Input:  bloomDay=[7,7,7,7,12,7,7],m=2,k=3
Output: 12
```

---

## Constraints

- `bloomDay.length == n`
- `1 <= n <= 10^5`
- `1 <= bloomDay[i] <= 10^9`
- `1 <= m <= 10^6`
- `1 <= k <= n`
