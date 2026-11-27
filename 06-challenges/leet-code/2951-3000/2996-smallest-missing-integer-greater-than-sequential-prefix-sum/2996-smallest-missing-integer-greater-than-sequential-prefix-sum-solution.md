# 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum — Solution

## Approach: Linear Scan + HashSet

1. Find the longest sequential prefix by iterating while `nums[j] == nums[j-1] + 1`.
2. Compute the sum of that prefix.
3. Put all array elements in a `HashSet` for O(1) membership queries.
4. Starting from the prefix sum, increment until we find a value not in the set.

## Complexity

| | Time | Space |
|---|---|---|
| Find prefix + compute sum | O(n) | O(1) |
| Build set | O(n) | O(n) |
| Scan for missing | O(n) worst-case | O(1) |
| **Total** | **O(n)** | **O(n)** |

Given the small constraints (`n ≤ 50`, values `≤ 50`), even a brute-force O(n²) is fine, but the HashSet approach is clean and general.
