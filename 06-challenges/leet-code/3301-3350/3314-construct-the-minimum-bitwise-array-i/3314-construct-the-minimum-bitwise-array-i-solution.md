# Solution: Construct the Minimum Bitwise Array I

## Approach: Bit Manipulation

For `x OR (x+1) = p`, note that `x+1` flips the lowest `0` bit of `x` and sets all trailing `1`s to `0`. So `x OR (x+1)` equals `x` with the lowest `0` bit set to `1`.

For this to equal `p`:
- `p` must be odd (since the last bit of `x OR (x+1)` is always 1 when you consider that x+1 sets at least the last bit). Actually `p` must be odd for solutions to exist — if `p` is even, its last bit is 0, but `x OR (x+1)` always has last bit 1 (since at some point a 0 bit gets set). Exception: `p=2` has no solution.

**Algorithm:** For each prime `p`:
- If `p == 2`, return -1.
- Otherwise, find the rightmost `0` bit in `p` (scanning from bit 1 upward, since bit 0 is 1 for odd primes). Set that bit to `0` in `p`. That gives `ans = p with that bit cleared = p ^ (1 << bit)`. Verify: `ans OR (ans+1) == p`.

Actually for odd `p`: the minimum `x` is obtained by clearing the lowest `0` bit (excluding the last bit since `p` is odd). So scan from bit 1 upward, find first 0 bit in `p`, set `x = p ^ (1 << bit)`. Then verify `x | (x+1) == p`.

## Complexity

- **Time:** O(n * log(max_p)).
- **Space:** O(1).
