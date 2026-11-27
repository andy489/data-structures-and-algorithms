# 1268. Search Suggestions System — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/search-suggestions-system/

---

## Solution: Sort + Binary Search — O(n log n + m log n) time, O(n) space

**Idea:** Sort products. For each prefix, binary search for the insertion point. The first 3 results from that position with the matching prefix are the suggestions.

**Algorithm:**
1. Sort products.
2. For each prefix: binary search for start position.
3. Collect up to 3 products starting with prefix.

**Complexity:**

| | |
|---|---|
| Time | O(n log n + m log n) |
| Space | O(n) |
