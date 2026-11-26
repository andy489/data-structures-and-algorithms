# 1330. Reverse Subarray To Maximize Array Value — Solution

## Approach
Key insight: reversing subarray [i+1..j] changes only the contributions at boundary pairs (i,i+1) and (j,j+1). The gain is |a-d|-|a-b| + |c-d|-|b-c| where a=nums[i],b=nums[i+1],c=nums[j],d=nums[j+1]. Also check endpoints.

## Complexity
- Time: O(n)
- Space: O(1)
