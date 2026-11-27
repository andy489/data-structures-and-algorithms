# 2217. Find Palindrome With Fixed Length — Solution

**Approach:** Mathematical Construction

For a palindrome of length `intLength`, the first half determines the entire palindrome. The smallest palindrome starts with `10^((intLength-1)/2)` for odd lengths and `10^(intLength/2 - 1)` for even lengths. The `q`th palindrome is formed by taking the `(start + q - 1)`th half and mirroring it. If the half exceeds `10^ceil(intLength/2)`, return -1.

**Time Complexity:** O(queries.length * intLength) — constructing each palindrome.

**Space Complexity:** O(1) extra space (not counting output).
