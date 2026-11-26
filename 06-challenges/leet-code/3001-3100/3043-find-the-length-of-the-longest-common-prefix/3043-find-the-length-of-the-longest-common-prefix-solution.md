# 3043. Find the Length of the Longest Common Prefix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

---

## Solution: HashSet of Prefixes — O(n * D) time, O(n * D) space

**Idea:** Store all numeric prefixes of arr1 numbers in a set. For each number in arr2, check all its prefixes against the set.

**Algorithm:**
1. For each x in arr1: add all prefixes (x, x/10, x/100, ...) to a HashSet.
2. For each y in arr2: check all prefixes of y against the set, track max length.
3. Return max length.

**Complexity:**

| | |
|---|---|
| Time | O((n1+n2) * D) — D = max digits (≤9) |
| Space | O(n1 * D) — set of prefixes |
