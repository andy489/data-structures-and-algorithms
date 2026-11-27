# 1449. Form Largest Integer With Digits That Add Up To Target

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/

---

## Problem Statement

Return the largest number (as string) that can be formed from digits 1-9 where the total cost equals `target`. Each digit has an associated cost. Return "0" if impossible.

---

## Examples

**Example 1:**
```
Input:  cost=[4,3,2,5,6,7,2,5,5],target=9
Output: "7772"
```

**Example 2:**
```
Input:  cost=[7,6,5,5,5,6,8,7,8],target=12
Output: "85"
```

**Example 3:**
```
Input:  cost=[2,4,6,2,4,6,4,4,4],target=5
Output: "0"
```

---

## Constraints

- `cost.length == 9`
- `1 <= cost[i] <= 5000`
- `1 <= target <= 5000`
