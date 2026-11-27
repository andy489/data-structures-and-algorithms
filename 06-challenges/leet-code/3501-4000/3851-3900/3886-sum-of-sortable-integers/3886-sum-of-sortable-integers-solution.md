# Solution: 3886. Sum of Sortable Integers

## Approach

For a given `k`, the array is sortable iff we can sort it by cyclically rotating each block of `k`.

A block `[a[0], a[1], ..., a[k-1]]` can be sorted by cyclic rotation iff its sorted version is a rotation of the original. This means: the elements are "almost sorted" — there's exactly one "descent" from last to first (cyclically).

After globally sorting `nums`, the sorted array is the target. For a block with `k` elements, they must equal the corresponding sorted elements, and must be a cyclic rotation of each other.

**Algorithm:**
1. Sort `nums` to get `sorted_nums`.
2. For each divisor `k` of `n`:
   - For each block `[i*k .. (i+1)*k - 1]`:
     - Check that the multiset of `nums[i*k..(i+1)*k-1]` equals `sorted_nums[i*k..(i+1)*k-1]`.
     - Check that `nums[i*k..(i+1)*k-1]` is a cyclic rotation of `sorted_nums[i*k..(i+1)*k-1]`.
   - If all blocks pass, add `k` to the answer.

**Checking cyclic rotation:** A string/array A is a rotation of B iff A appears in B+B (using KMP or hashing).

**Optimization:** For each pair of adjacent blocks, check if the "boundary" across blocks is consistent. Actually, check per block.

For efficiency: iterate over divisors of `n` (O(sqrt(n))), and for each divisor `k`, check all n/k blocks in O(k) each = O(n) total.

## Complexity

- **Time:** O(n * d(n)) where d(n) = number of divisors of n
- **Space:** O(n)
