# Solution: Construct the Minimum Bitwise Array II

## Approach: Same as Part I but with Larger Values

Same algorithm as 3314 but with `nums[i]` up to `10^9`.

For each prime `p`:
- If `p == 2`, return -1 (even, no solution).
- Otherwise scan bits from position 1 upward (position 0 is always 1 for odd primes). Find the lowest `0` bit at position `bit >= 1`, compute `x = p ^ (1 << bit)`, verify `x | (x+1) == p`, and take that as the minimum `ans`.

The same approach works because we're just scanning up to 30 bits instead of ~10 bits.

## Complexity

- **Time:** O(n * log(max_p)) = O(n * 30).
- **Space:** O(1).
