# 628. Maximum Product of Three Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-product-of-three-numbers/

---

## Solution: Sort + Math — O(n log n) time, O(1) space

**Idea:** After sorting, the max product is either the product of the three largest or the product of the two smallest (most negative) with the largest.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sort |
| Space | O(1) — sort in-place |
