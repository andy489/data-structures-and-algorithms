# 947. Most Stones Removed with Same Row or Column — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

---

## Solution: Union-Find — O(n α(n)) time, O(n) space

**Idea:** Stones in the same row or column form a connected component. From each component of size k, we can remove k-1 stones. Answer = n - number of components.

Union rows with columns (offset columns by max_coord+1 to avoid conflicts).

**Complexity:**

| | |
|---|---|
| Time | O(n α(n)) |
| Space | O(n) |
