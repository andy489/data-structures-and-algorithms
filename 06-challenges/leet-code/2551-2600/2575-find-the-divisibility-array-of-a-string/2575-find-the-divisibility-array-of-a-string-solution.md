# Solution: 2575. Find the Divisibility Array of a String

## Approach: Running Modular Arithmetic

The key insight: `word[0..i]` as a number = `word[0..i-1] * 10 + digit[i]`.

So we can track the **remainder** of the prefix number modulo `m` incrementally:
- `remainder = (remainder * 10 + digit) % m`
- If `remainder == 0`, set `div[i] = 1`, else `div[i] = 0`.

This avoids working with potentially huge numbers (since the prefix can have up to 10^5 digits).

## Complexity

- **Time:** O(n)
- **Space:** O(1) extra (O(n) for output)
