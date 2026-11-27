# 3855. Sum of K-Digit Numbers in a Range — Solution

**Link:** https://leetcode.com/problems/sum-of-k-digit-numbers-in-a-range/

## Approach: Math / Combinatorics

Let `d = r - l + 1` be the number of valid digit choices and `S = l + (l+1) + ... + r = d*(l+r)/2` be the sum of valid digits.

For a k-digit number, consider each digit position (from position 0 = leftmost to position k-1 = rightmost). Position `p` from the right contributes a factor of `10^p`.

Each digit is independently chosen from the `d` options. For a fixed position `p`, the total contribution to the sum across all numbers is:
- Each digit value `v` in `[l, r]` appears at position `p` in `d^(k-1)` numbers (the other k-1 digits can be anything).
- The place value of position `p` from the right is `10^p`.
- So total contribution from position `p` = `S * d^(k-1) * 10^p`.

Summing over all positions 0..k-1:
```
answer = S * d^(k-1) * (10^k - 1) / 9
```
(using the geometric series sum formula)

Since k can be up to 10^9, use fast modular exponentiation. Division by 9 is computed as modular inverse.

## Complexity

- **Time:** O(log k) for modular exponentiation
- **Space:** O(1)
