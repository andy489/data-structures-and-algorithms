# 1471. The K Strongest Values In An Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/the-k-strongest-values-in-an-array/

---

## Solution: Sort + Two Pointers — O(n log n) time, O(n) space

**Idea:** Sort array. Median = arr[(n-1)/2]. Use two pointers from both ends, pick k strongest.

**Algorithm:**
1. Sort arr. m = arr[(n-1)/2].
2. Two pointers l=0, r=n-1. Pick stronger of arr[r] vs arr[l] by |arr[i]-m| (tie: larger).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
