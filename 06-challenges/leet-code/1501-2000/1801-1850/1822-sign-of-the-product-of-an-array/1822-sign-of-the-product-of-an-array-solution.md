# 1822. Sign of the Product of an Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sign-of-the-product-of-an-array/

---

## Solution: Count Negatives — O(n) time, O(1) space

**Idea:** Instead of computing the actual product (which may overflow), track only the sign. If any element is `0`, the product is `0`. Otherwise, count the number of negative numbers — an odd count means negative product.

**Algorithm:**
1. Initialize `sign = 1`.
2. For each element `x`:
   - If `x == 0`, return `0` immediately.
   - If `x < 0`, flip `sign`.
3. Return `sign`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the array |
| Space | O(1) — only a sign variable |
