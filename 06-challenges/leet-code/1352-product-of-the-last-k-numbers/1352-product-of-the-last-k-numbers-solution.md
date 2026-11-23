# 1352. Product of the Last K Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/product-of-the-last-k-numbers/

---

## Solution: Prefix Products with Zero Reset — O(1) time, O(n) space

**Idea:** Maintain a running prefix-product list. When a `0` is added, reset the list (since any window containing `0` has product `0`). For `getProduct(k)`, if `k >= prefix.size()` the window spans the last reset, so return `0`; otherwise return `prefix[last] / prefix[last - k]`.

**Algorithm:**
1. Initialize `prefix = [1]` (sentinel so division always has a valid denominator).
2. `add(num)`:
   - If `num == 0`, reset `prefix = [1]`.
   - Otherwise, append `prefix.back() * num`.
3. `getProduct(k)`:
   - If `k >= prefix.size()`, return `0` (window includes a zero).
   - Otherwise, return `prefix.back() / prefix[prefix.size() - 1 - k]`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — both `add` and `getProduct` are constant |
| Space | O(n) — prefix list grows with stream |
