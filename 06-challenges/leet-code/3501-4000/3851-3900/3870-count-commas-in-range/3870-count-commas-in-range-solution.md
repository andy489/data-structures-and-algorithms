# 3870. Count Commas in Range — Solution

**Link:** https://leetcode.com/problems/count-commas-in-range/

## Approach: Count by Digit Length

A number with `d` digits has `floor((d-1)/3)` commas (since commas are inserted every 3 digits from the right):
- 1–3 digits: 0 commas
- 4–6 digits: 1 comma
- 7–9 digits: 2 commas
- etc.

Since `n <= 10^5` (at most 6 digits), all numbers have at most 1 comma (specifically numbers >= 1000 have exactly 1 comma).

We just count how many numbers in [1, n] are >= 1000.

## Complexity

- **Time:** O(1)
- **Space:** O(1)
