# 1960. Maximum Product of the Length of Two Palindromic Substrings — Solution

## Approach

Use Manacher's algorithm to compute palindrome radii for all centers.

Then:
- Compute `left[i]` = length of longest odd palindrome ending at or before index i.
- Compute `right[i]` = length of longest odd palindrome starting at or after index i.
- Sweep through split points; the answer is max(left[i] * right[i+1]).

For `left[i]`: propagate max palindrome length using the DP: `left[i] = max(left[i-1], radius*2-1)` where radius comes from Manacher.

**Complexity:** O(n) time, O(n) space.
