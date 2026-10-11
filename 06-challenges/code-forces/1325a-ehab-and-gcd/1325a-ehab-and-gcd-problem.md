# 1325A. EhAb AnD gCd

**Rating:** 800  
**Tags:** constructive algorithms, greedy, number theory  
**Link:** https://codeforces.com/problemset/problem/1325/A

---

## Problem Statement

Given a positive integer *x*, find two positive integers *a* and *b* such that:

```
GCD(a, b) + LCM(a, b) = x
```

A solution is guaranteed to exist.

---

## Input Format

- Line 1: integer *t* (1 ≤ *t* ≤ 100) — number of test cases
- Each test case: single integer *x* (2 ≤ *x* ≤ 10⁹)

---

## Output Format

For each test case: two integers *a* and *b* (1 ≤ *a*, *b* ≤ 10⁹). Any valid pair is acceptable.

---

## Examples

**Input:**
```
2
2
14
```

**Output:**
```
1 1
6 4
```

**Verification:**
- GCD(1,1) + LCM(1,1) = 1 + 1 = 2 ✓
- GCD(6,4) + LCM(6,4) = 2 + 12 = 14 ✓

---

## Constraints

- 1 ≤ *t* ≤ 100
- 2 ≤ *x* ≤ 10⁹
- Time limit: 1 second, Memory limit: 256 MB
