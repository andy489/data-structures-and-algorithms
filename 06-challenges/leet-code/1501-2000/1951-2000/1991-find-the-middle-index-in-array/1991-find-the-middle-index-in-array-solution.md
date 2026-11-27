# Solution: Find the Middle Index in Array

## Approach: Prefix Sum

Compute the total sum. Then iterate left to right keeping a running left sum. At each index, check if `leftSum == totalSum - leftSum - nums[i]`.

**Time:** O(n)  
**Space:** O(1)
