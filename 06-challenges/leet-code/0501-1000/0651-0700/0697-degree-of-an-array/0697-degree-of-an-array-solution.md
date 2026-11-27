# 697. Degree of an Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/degree-of-an-array/

---

## Solution: HashMap — O(n) time, O(n) space

**Idea:** Track count, first occurrence, and last occurrence for each element. Find max degree. Among elements with that degree, find minimum last-first+1.

**Algorithm:**
1. Single pass: record `count[v]`, `first[v]`, `last[v]`.
2. Find max count. For each element with max count, compute span = last - first + 1.
3. Return minimum span.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
