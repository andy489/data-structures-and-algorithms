# 2003. Smallest Missing Genetic Value in Each Subtree

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/

---

## Problem Statement

There is a **rooted** tree consisting of `n` nodes numbered `0` to `n - 1`. Each node has a unique genetic value from the array `nums` (all values are distinct and in range `[1, n+1]`). For each node `i`, find the **smallest** positive integer that is **not** in the subtree of node `i`.

Return an array `ans` of size `n` where `ans[i]` is the answer for node `i`.

---

## Examples

**Example 1:**
```
Input:  parents = [-1,0,0,2], nums = [1,2,3,4]
Output: [5,1,1,1]
```

**Example 2:**
```
Input:  parents = [-1,0,1,0,3,3], nums = [5,4,6,2,1,3]
Output: [7,1,1,1,1,1]
```

---

## Constraints

- `n == parents.length == nums.length`
- `2 <= n <= 10^5`
- `0 <= parents[i] <= n - 1 for all i != 0`
- `parents[0] == -1`
- `parents represents a valid rooted tree.`
- `1 <= nums[i] <= n + 1`
- `All nums[i] are distinct.`
