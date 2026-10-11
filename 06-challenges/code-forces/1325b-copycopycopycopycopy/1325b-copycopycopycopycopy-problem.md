# 1325B. CopyCopyCopyCopyCopy

**Rating:** 800  
**Tags:** greedy, implementation  
**Link:** https://codeforces.com/problemset/problem/1325/B

---

## Problem Statement

Ehab has an array of *n* integers. He creates a **new array** by concatenating *n* copies of the original array back-to-back.

Find the length of the **longest strictly increasing subsequence** (LIS) of the new concatenated array.

---

## Input Format

- Line 1: integer *t* — number of test cases
- For each test case:
  - Line 1: integer *n* (1 ≤ *n* ≤ 10⁵)
  - Line 2: *n* integers *a₁, a₂, ..., aₙ* (1 ≤ *aᵢ* ≤ 10⁹)
- Sum of *n* across all test cases ≤ 10⁵

---

## Output Format

For each test case: the length of the LIS of the concatenated array.

---

## Examples

**Input:**
```
2
3
3 2 1
6
3 1 4 1 5 9
```

**Output:**
```
3
5
```

**Explanation:**
- Test 1: Concatenated [3,2,**1**, 3,**2**,1, **3**,2,1] — LIS = [1,2,3], length 3.
- Test 2: LIS = [1,3,4,5,9], length 5.

---

## Constraints

- 1 ≤ *n* ≤ 10⁵, 1 ≤ *aᵢ* ≤ 10⁹
- Time limit: 1 second, Memory limit: 256 MB
