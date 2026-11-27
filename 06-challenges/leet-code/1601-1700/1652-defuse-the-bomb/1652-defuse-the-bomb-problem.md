# 1652. Defuse the Bomb

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/defuse-the-bomb/

---

## Problem Statement

You have a bomb to defuse, and your time is running out! Your informer will provide you with a **circular** array `code` of length `n` and a key `k`.

To decrypt the code, you must replace every number. All the numbers are replaced **simultaneously**.

- If `k > 0`, replace the `i`-th number with the sum of the **next** `k` numbers.
- If `k < 0`, replace the `i`-th number with the sum of the **previous** `|k|` numbers.
- If `k == 0`, replace the `i`-th number with `0`.

---

## Examples

**Example 1:**
```
Input: code = [5,7,1,4], k = 3
Output: [12,10,16,13]
```

**Example 2:**
```
Input: code = [1,2,3,4], k = 0
Output: [0,0,0,0]
```

**Example 3:**
```
Input: code = [2,4,9,3], k = -2
Output: [12,5,6,13]
```

---

## Constraints

- `n == code.length`
- `1 <= n <= 100`
- `1 <= code[i] <= 100`
- `-(n - 1) <= k <= n - 1`
