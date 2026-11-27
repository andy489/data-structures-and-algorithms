# Solution: Find the K-th Character in String Game I

## Approach: Simulation or Bit Counting

Since `k <= 500`, we can simulate directly or use the mathematical observation:

The k-th character (1-indexed) equals `'a' + popcount(k - 1)` where `popcount` is the number of set bits. This is because each time a character comes from the "appended" half, it has been shifted one more time. The number of times it got shifted equals the number of set bits in `k-1`.

**Simulation approach (for small k):** Repeatedly double the string until length >= k, then return character at index k-1.

**Bit counting approach:** Count the number of 1-bits in `k-1` and return `'a' + count`.

## Complexity

- **Time:** O(log k).
- **Space:** O(1).
