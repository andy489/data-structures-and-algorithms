# Solution: 3871. Count Commas in Range II

## Approach

A number with `d` digits has `floor((d-1)/3)` commas in standard formatting:
- 1-3 digits: 0 commas
- 4-6 digits: 1 comma
- 7-9 digits: 2 commas
- 10-12 digits: 3 commas
- 13-15 digits: 4 commas

For `n` up to `10^15` (at most 16 digits), we can count how many numbers from 1 to n have at least `c` commas by counting numbers >= 10^(3c).

The total commas = sum over c=1..4 of count(numbers from 1 to n with at least c commas).

A number has at least `c` commas if it has at least `3c+1` digits, i.e., it is >= `10^(3c)`.

So total = sum_{c=1}^{4} max(0, n - 10^(3c) + 1).

## Complexity

- **Time:** O(1)
- **Space:** O(1)
