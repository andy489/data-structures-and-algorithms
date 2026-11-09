# 1000. Minimum Cost to Merge Stones

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-merge-stones/

---

## Problem Statement

There are `n` piles of stones arranged in a row. The `i`th pile has `stones[i]` stones.

A **move** consists of merging exactly `k` **consecutive** piles into one pile, and the cost of this move is equal to the total number of stones in these `k` piles.

Return the minimum cost to merge all piles of stones into one pile. If it is impossible, return `-1`.

---

## Examples

**Example 1:**
```
Input:  stones = [3,2,4,1], k = 2
Output: 20
```
Explanation: We merge `[3,2]` for a cost of 5, then `[4,1]` for a cost of 5, then `[5,5]` for a cost of 10. The total cost is 20.

**Example 2:**
```
Input:  stones = [3,2,4,1], k = 3
Output: -1
```
Explanation: After any sequence of moves, there will always be 2 piles left, and we cannot merge them.

**Example 3:**
```
Input:  stones = [3,5,1,2,6], k = 3
Output: 25
```
Explanation: We merge `[5,1,2]` for a cost of 8, then `[3,8,6]` for a cost of 17. The total cost is 25.

---

## Constraints

- `n == stones.length`
- `1 <= n <= 30`
- `1 <= stones[i] <= 100`
- `2 <= k <= 30`
