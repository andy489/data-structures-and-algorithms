# 1547. Minimum Cost to Cut a Stick

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

---

## Problem Statement

Given a wooden stick of length `n` units. The stick is labelled from `0` to `n`. For example, a stick of length 6 is labelled as follows: `0 1 2 3 4 5 6`.

Given an integer array `cuts` where `cuts[i]` denotes a position you should perform a cut at.

The cost of one cut is the length of the stick to be cut. The total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation. NOTICE that you can change the order of the cuts as you wish.

Return the minimum total cost of the cuts.

---

## Examples

**Example 1:**
```
Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:
  First cut is done to a rod of length 7 so the cost is 7. Second cut is done to a rod of length 6 (from 1 to 7) so the cost is 6. Third cut is done to a rod of length 4 (from 3 to 7) so the cost is 4. Fourth cut is done to a rod of length 3 (from 4 to 7) so the cost is 3. Total Cost = 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16.
```

**Example 2:**
```
Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
```

---

## Constraints
- `2 <= n <= 10^6`
- `1 <= cuts.length <= min(n - 1, 100)`
- `1 <= cuts[i] <= n - 1`
- All the integers in `cuts` array are distinct.
