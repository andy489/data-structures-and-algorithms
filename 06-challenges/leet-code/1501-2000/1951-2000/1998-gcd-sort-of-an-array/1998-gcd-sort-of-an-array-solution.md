# Solution: GCD Sort of an Array

## Approach: Union-Find with Prime Factorization

Two elements can be swapped (directly or transitively) if they share a common prime factor, so they belong to the same connected component.

Use Union-Find: for each number, find its prime factors. Union the number's index with the first prime factor, and union all prime factors of that number together. This groups indices that share any prime factor.

After building components, check: for each index `i`, the sorted value `sorted[i]` must be in the same component as `nums[i]`.

**Time:** O(n * sqrt(max_val) * alpha(n))  
**Space:** O(max_val)
