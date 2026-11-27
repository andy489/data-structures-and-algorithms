# 3942. Minimum Operations to Sort a Permutation

## Approach

We need to determine whether the permutation can be sorted by repeated left rotations and reverses, and if so, find the minimum number of operations.

Key observations:
1. After any sequence of rotate-left and reverse operations, the array can only be in certain configurations.
2. Rotating left by one is equivalent to cyclic shift. Reversing flips the order.
3. This group of operations generates the dihedral group on the cyclic arrangements.

A permutation is reachable from another if the sequence of elements (read cyclically) or its reverse matches. So we need to check: is the sorted array `[0,1,...,n-1]` reachable from `nums` by rotations and reverses?

The sorted array `[0,1,...,n-1]` can be reached iff `nums` is a rotation of `[0,1,...,n-1]` or a rotation of its reverse `[n-1,...,1,0]`.

- Check if `nums` is a rotation of `[0..n-1]`: find position of 0, check if `nums[pos..] ++ nums[..pos]` = `[0..n-1]`. This holds iff `nums` is itself a cyclic rotation of sorted order.
- Check if `nums` is a rotation of `[n-1..0]`.

If neither, return -1. Otherwise compute the minimum operations:
- For rotations: rotating left `r` times costs `r` ops.
- One reverse + rotations: 1 + r ops.

Take the minimum across all valid rotations from either direction.

## Complexity

- **Time:** O(n) — scanning for 0, checking rotation validity
- **Space:** O(1) — constant extra space
