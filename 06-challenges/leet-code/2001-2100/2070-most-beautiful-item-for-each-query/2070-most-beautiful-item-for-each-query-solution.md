# 2070. Most Beautiful Item for Each Query — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/most-beautiful-item-for-each-query/

---

## Solution: Sort + Offline Queries — O((n + q) log n) time, O(n + q) space

**Idea:** Sort items by price. Sort queries. For each query, advance pointer collecting max beauty.

**Algorithm:**
1. Sort items by price, sort queries with original indices.
2. Two pointers: advance item pointer for each query.
3. Track max beauty seen.

**Complexity:**

| | |
|---|---|
| Time | O((n + q) log n) |
| Space | O(n + q) |
