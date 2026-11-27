# Solution: Maximum Possible Number by Binary Concatenation

## Approach: Try All Permutations

Since there are only 3 numbers, there are 3! = 6 permutations. Try all of them, compute the resulting number by binary concatenation, and return the maximum.

To concatenate binary representations of `a` then `b`: `result = (a << bits(b)) | b` where `bits(b)` is the number of bits in `b`.

## Complexity

- **Time:** O(1) — constant 6 permutations of 3 elements.
- **Space:** O(1).
