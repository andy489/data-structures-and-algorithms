# 1505. Minimum Possible Integer After At Most K Adjacent Swaps On Digits

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/

---

## Problem Statement

Given a string `num` representing **the digits** of a very large integer and an integer `k`, return *the minimum integer you can obtain by applying **at most** `k` adjacent swaps on its digits*.

---

## Examples

**Example 1:**
```
Input:  num = "4321", k = 4
Output: "1342"
```

**Example 2:**
```
Input:  num = "100", k = 1
Output: "010"
Explanation: It's ok for the leading digit to be 0 after performing swaps.
```

**Example 3:**
```
Input:  num = "36789", k = 1000
Output: "36789"
Explanation: No swap needed.
```

---

## Constraints

- `1 <= num.length <= 30000`
- `num` consists of **digits** only.
- `num` does not have **leading zeros**.
- `1 <= k <= 10^9`
