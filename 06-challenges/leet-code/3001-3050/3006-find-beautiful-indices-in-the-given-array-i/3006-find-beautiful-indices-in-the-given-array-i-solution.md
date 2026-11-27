# 3006. Find Beautiful Indices in the Given Array I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/

---

## Solution: Two Pointers on Occurrence Lists — O(n) time, O(n) space

**Idea:** Find all occurrences of `a` in `s` (indexA) and all occurrences of `b` in `s` (indexB). For each i in indexA, use two pointers to check if any j in indexB satisfies |i-j| <= k.

**Algorithm:**
1. Find all positions where `a` occurs in `s` → listA.
2. Find all positions where `b` occurs in `s` → listB.
3. Two pointers: for each i in listA, advance j in listB while listB[j] < i-k, then check if listB[j] <= i+k.
4. Collect and return beautiful indices.

**Complexity:**

| | |
|---|---|
| Time | O(n) — KMP matching + two pointers |
| Space | O(n) — occurrence lists |
