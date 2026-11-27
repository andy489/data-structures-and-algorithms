# 1359. Count All Valid Pickup and Delivery Options — Solution

## Approach
For k-th order with 2k-1 slots remaining, place P_k in any of 2k-1 slots and D_k in any of 2k-1 positions after P_k (which is k*(2k-1) choices / 2 = k*(2k-1) if we count gaps correctly). Result = product of k*(2k-1) for k=1..n.

## Complexity
- Time: O(n)
- Space: O(1)
