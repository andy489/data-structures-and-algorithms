# Solution: 3899. Angles of a Triangle

## Approach: Law of Cosines

First check if the given sides can form a valid triangle (positive area). Then use the **Law of Cosines** to compute all three angles.

### Triangle Validity

A valid triangle requires the strict triangle inequality: for sides `a, b, c`, each side must be strictly less than the sum of the other two. Equivalently, the largest side must be strictly less than the sum of the other two.

### Law of Cosines

For a triangle with sides `a, b, c` opposite to angles `A, B, C`:

```
cos(A) = (b^2 + c^2 - a^2) / (2 * b * c)
```

Then `A = acos(cos(A))` in radians, converted to degrees by multiplying by `180 / π`.

### Algorithm

1. Sort the sides.
2. Check triangle inequality: `sides[0] + sides[1] > sides[2]` (strict).
3. Compute three angles using the Law of Cosines.
4. Sort and return.

## Complexity

- **Time:** O(1) — constant-size input
- **Space:** O(1)
