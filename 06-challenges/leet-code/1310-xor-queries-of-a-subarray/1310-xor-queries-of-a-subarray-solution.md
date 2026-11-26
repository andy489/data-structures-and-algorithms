# 1310. XOR Queries of a Subarray — Solution

## Approach
Prefix XOR array. prefix[i] = arr[0] XOR ... XOR arr[i-1]. Query [L,R] = prefix[R+1] XOR prefix[L].

## Complexity
- Time: O(n + q)
- Space: O(n)
