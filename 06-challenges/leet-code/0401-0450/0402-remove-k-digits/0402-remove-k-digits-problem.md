# 402. Remove K Digits

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-k-digits/

---

## Problem Statement

Given string `num` representing a non-negative integer and an integer `k`, remove `k` digits from `num` so that the remaining number is the smallest possible.

Return the result as a string with no leading zeros. If the result is empty, return `"0"`.

---

## Examples

**Example 1:**
```
Input:  num = "1432219", k = 3
Output: "1219"
```

**Example 2:**
```
Input:  num = "10200", k = 1
Output: "200"
```

**Example 3:**
```
Input:  num = "10", k = 2
Output: "0"
```

---

## Constraints

- `1 <= num.length <= 10^5`
- `0 <= k <= num.length`
- `num` consists of digits only
- `num` does not have leading zeros except for `"0"` itself
