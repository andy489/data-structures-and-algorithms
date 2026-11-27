# 2117. Abbreviating the Product of a Range — Solution

**Link:** https://leetcode.com/problems/abbreviating-the-product-of-a-range/

## Approach: Separate Tracking of Prefix and Suffix

The challenge is handling very large products. We track two things simultaneously:

1. **Trailing zeros (C):** Count factors of 2 and 5 in the range product. `C = min(count2, count5)`.

2. **Last 5 digits (suffix):** Maintain the last 5 digits modulo `100000`, after removing the factors of 2 and 5 as we multiply. At the end, remove remaining unmatched factors.

3. **First 5 digits (prefix):** Use floating-point logarithms to track the leading digits. Sum `log10(i)` for all `i` in `[left, right]`. The fractional part gives the leading digits.

4. If `d <= 10`, compute the full product exactly (since `right <= 10^4`, the product fits in a few hundred bits). We use `BigInteger` or Python's arbitrary precision.

## Complexity

| | Time | Space |
|---|---|---|
| **Mixed precision** | O(right - left) | O(1) |
