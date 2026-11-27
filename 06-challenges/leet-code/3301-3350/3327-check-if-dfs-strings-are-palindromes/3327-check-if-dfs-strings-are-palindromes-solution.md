# 3327. Check if DFS Strings Are Palindromes

## Approach

**Euler Tour + Hashing (Palindrome detection):**

The key observations:
1. The DFS string for subtree rooted at `x` is a contiguous substring of the full DFS string (Euler tour).
2. We can compute the full DFS string in O(n) using an iterative post-order traversal.
3. For each node `x`, we know its subtree's range `[in[x], out[x]]` in the DFS string.
4. We need to check if this substring is a palindrome efficiently.

**Palindrome check using polynomial hashing:**
- Build forward and backward hash arrays
- A substring `s[l..r]` is a palindrome iff its forward hash equals its backward hash

**Algorithm:**
1. Build children lists
2. DFS to compute DFS string and subtree ranges [start, end)
3. Use double polynomial hashing to check palindromes in O(1) per query

## Complexity

- **Time:** O(n) for DFS + O(n) for hash precomputation + O(n) for queries = O(n)
- **Space:** O(n)
