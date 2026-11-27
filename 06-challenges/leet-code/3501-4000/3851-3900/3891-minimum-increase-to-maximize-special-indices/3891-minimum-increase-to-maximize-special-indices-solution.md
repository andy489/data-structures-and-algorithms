# Solution: 3891. Minimum Increase to Maximize Special Indices

## Approach: Greedy — Maximize Non-Adjacent Peaks

A special index requires `nums[i] > nums[i-1]` and `nums[i] > nums[i+1]`. Since increasing a value never hurts and two adjacent indices can't both be special (if i is special, nums[i] > nums[i+1], so i+1 can't be strictly greater than nums[i+2] without further operations), we process from left to right greedily.

### Algorithm

1. Work on a copy of the array.
2. Iterate through indices 1 to n-2.
3. For each index `i`, compute how much we need to increase `nums[i]` to make it strictly greater than both neighbors:
   - `needed = max(nums[i-1], nums[i+1]) + 1 - nums[i]`
   - If `needed > 0`, add it to the total operations and update `nums[i]` accordingly.
4. After making index `i` special, **skip index i+1** (since the next candidate can't be adjacent).

### Why Greedy Works

By processing left to right and making every other index a peak when possible, we maximize the number of peaks. After making `i` a special index, `nums[i]` is now potentially large, so `i+1` could never be special unless we specifically work to make it so, while `i+2` might naturally be achievable.

## Complexity

- **Time:** O(N)
- **Space:** O(N) for the working copy (or O(1) if we modify in-place)
