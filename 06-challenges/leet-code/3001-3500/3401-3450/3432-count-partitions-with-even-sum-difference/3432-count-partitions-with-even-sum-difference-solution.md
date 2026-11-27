# 3432. Count Partitions with Even Sum Difference — Solution

## Approach

The difference `leftSum - rightSum` is even if and only if both sums have the same parity (both even or both odd). Since `leftSum + rightSum = totalSum`, the difference is even iff `totalSum` is even (because even - even = even and odd - odd = even, while `leftSum = (totalSum + diff) / 2` requires totalSum and diff to have same parity).

More directly: `diff = leftSum - rightSum = 2*leftSum - totalSum`. This is even iff `totalSum` is even, which means the parity does not depend on the partition index at all — either all partitions are valid (if totalSum is even) or none are.

However, to be careful: `leftSum - rightSum = leftSum - (totalSum - leftSum) = 2*leftSum - totalSum`. This is always even iff `totalSum` is even.

So the answer is `n - 1` if `totalSum` is even, else `0`. But we can also just iterate and count directly in O(n).

**Algorithm:**
- Use a prefix sum approach: maintain `leftSum` incrementally.
- For each partition index `i`, check if `(leftSum - (totalSum - leftSum)) % 2 == 0`.

**Time Complexity:** O(n)
**Space Complexity:** O(1)
