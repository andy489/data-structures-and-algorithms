# 1000. Minimum Cost to Merge Stones

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-merge-stones/

---

## Problem Statement

There are `n` piles of stones arranged in a row. The ith pile has `stones[i]` stones. A move consists of merging exactly `k` consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these `k` piles.

Return the minimum cost to merge all piles of stones into one pile. If it is impossible, return `-1`.

---

## Examples

**Example 1:**
```
Input:  stones = [3,2,4,1], k = 2
Output: 20
```

**Example 2:**
```
Input:  stones = [3,2,4,1], k = 3
Output: -1
```

**Example 3:**
```
Input:  stones = [3,5,1,2,6], k = 3
Output: 25
```

---

## Constraints

- `1 <= stones.length <= 30`
- `1 <= k <= 30`
- `1 <= stones[i] <= 100`
