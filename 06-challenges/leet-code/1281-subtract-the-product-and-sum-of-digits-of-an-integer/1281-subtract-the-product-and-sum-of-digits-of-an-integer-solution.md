# 1281. Subtract the Product and Sum of Digits of an Integer — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

---

## Solution: Digit Extraction — O(log n) time, O(1) space

**Idea:** Extract digits one by one, maintaining running product and sum.

**Algorithm:**
1. While n > 0: extract digit = n%10.
2. Multiply into product, add to sum.
3. Return product - sum.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
