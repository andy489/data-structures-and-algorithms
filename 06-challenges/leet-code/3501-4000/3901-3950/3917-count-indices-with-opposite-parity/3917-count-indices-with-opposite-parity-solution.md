# Solution for 3917. Count Indices With Opposite Parity

## Approach

**Suffix counting:**

1. Traverse from right to left, maintaining counts of odd and even elements seen so far (suffix).
2. For each index `i`, the score is:
   - If `nums[i]` is odd: count of even elements in `nums[i+1..n-1]`.
   - If `nums[i]` is even: count of odd elements in `nums[i+1..n-1]`.
3. Use a running count of odd/even from the right.

## Complexity

- Time: O(n)
- Space: O(1)
