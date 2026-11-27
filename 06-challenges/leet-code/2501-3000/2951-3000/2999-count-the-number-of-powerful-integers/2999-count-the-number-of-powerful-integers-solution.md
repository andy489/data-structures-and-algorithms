# 2999. Count the Number of Powerful Integers — Solution

## Approach: Digit DP

Since `finish` can be up to `10^15`, we cannot enumerate all candidates. We use **digit DP** with the standard "count numbers up to N satisfying constraints" technique.

Define `count(n)` = number of powerful integers in `[1..n]`. Then answer = `count(finish) - count(start - 1)`.

For `count(n)`:
- Convert `n` to string `t`.
- Let `suf` = suffix `s`. If `suf.length > t.length`, return 0.
- The number must end with `s`, so its last `suf.length` digits are fixed.
- We only need to fill in the prefix digits (positions `0` to `t.length - suf.length - 1`).
- Use digit DP: iterate over each prefix digit position, track whether we are still "tight" (bounded by `t`).
- At each position, we can place digits `0` to `min(digit, limit)` if tight, or `0` to `limit` if free.
- Once all prefix digits are decided, append `s` to form the candidate; check it is `>= start` (handled by the `count(start-1)` subtraction).

The DP runs in O(len(n)) per call — effectively O(log finish).

## Complexity

| | Time | Space |
|---|---|---|
| Digit DP per boundary | O(log finish) | O(log finish) |
| **Total** | **O(log finish)** | **O(log finish)** |
