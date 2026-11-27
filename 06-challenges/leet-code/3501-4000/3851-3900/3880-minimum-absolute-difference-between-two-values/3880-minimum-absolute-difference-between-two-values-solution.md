# Solution: 3880. Minimum Absolute Difference Between Two Values

## Approach

Collect all indices of 1s and all indices of 2s. Then use a two-pointer approach on the sorted index lists to find the minimum absolute difference between any index in the 1s list and any index in the 2s list.

Since both lists are already sorted (we collect left to right), use two pointers:
- Compare `ones[i]` and `twos[j]`
- If `ones[i] < twos[j]`, move i forward
- Else move j forward
- Track minimum `abs(ones[i] - twos[j])` at each step

## Complexity

- **Time:** O(n)
- **Space:** O(n)
