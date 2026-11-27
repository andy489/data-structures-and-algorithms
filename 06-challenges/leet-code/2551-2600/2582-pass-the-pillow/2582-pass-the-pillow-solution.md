# Solution: 2582. Pass the Pillow

## Approach: Mathematical / Modular Arithmetic

The pillow travels in a cycle of length `2*(n-1)` (1→2→...→n→n-1→...→2→1).

**Algorithm:**
1. Compute `cycle = 2 * (n - 1)`.
2. Reduce `time = time % cycle`.
3. If `time < n`: the pillow is at position `time + 1`.
4. Else: the pillow is moving backward, at position `cycle - time + 1 = 2*(n-1) - time + 1`.

## Complexity

- **Time:** O(1)
- **Space:** O(1)
