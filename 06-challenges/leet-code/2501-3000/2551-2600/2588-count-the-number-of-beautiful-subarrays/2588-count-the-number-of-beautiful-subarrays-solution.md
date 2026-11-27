# Solution: 2588. Count the Number of Beautiful Subarrays

## Approach

A subarray is beautiful if we can reduce all its elements to 0 using the described operations. Each operation subtracts `2^k` from two elements that both have bit `k` set. This is essentially XOR — a subarray can be zeroed out if and only if the XOR of all its elements equals 0.

This reduces to: **count the number of subarrays with XOR equal to 0**.

Use a prefix XOR approach with a hash map:
- Maintain a running prefix XOR.
- For each index `i`, if `prefix[i] == prefix[j]` for some `j < i`, then the subarray `[j+1..i]` has XOR = 0.
- Count pairs of equal prefix XOR values.

## Complexity

- **Time:** O(n)
- **Space:** O(n) for the hash map
