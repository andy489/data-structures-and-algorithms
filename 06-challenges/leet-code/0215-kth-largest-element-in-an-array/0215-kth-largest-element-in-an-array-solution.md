# 215. Kth Largest Element in an Array — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/kth-largest-element-in-an-array/

---

## Solution

### Approach 1 — Min-Heap of size k — O(n log k) time, O(k) space

**Idea:** Maintain a min-heap of the k largest elements seen so far. The top of the heap is always the k-th largest.

**Algorithm:**
1. Push the first k elements into a min-heap.
2. For each remaining element `x`:
   - If `x > heap.top()`: pop the top and push `x`.
3. Return `heap.top()`.

**Why a min-heap?** We keep the k largest. The minimum of those k is the k-th largest overall. Any new element larger than this minimum displaces it.

**Complexity:**

| | |
|---|---|
| Time | O(n log k) |
| Space | O(k) |

---

### Approach 2 — Quickselect — O(n) average, O(n²) worst-case time, O(1) space

**Idea:** Adapt the partition step of quicksort. After partitioning around a pivot, the pivot lands at its final sorted position. If that position is `n - k` (0-indexed from smallest), we found the answer. Otherwise recurse only into the relevant half.

**Algorithm:**
1. Randomly shuffle or randomly pick pivot to avoid worst case.
2. Partition `nums` around `pivot`: elements ≥ pivot go right, elements < pivot go left. Let pivot land at index `p`.
3. If `p == n - k`: return `nums[p]`.
4. If `p < n - k`: recurse on the right subarray.
5. If `p > n - k`: recurse on the left subarray.

**Why O(n) average?** Each partition eliminates roughly half the remaining elements on average. Summing the geometric series: n + n/2 + n/4 + ... = O(n). Worst case O(n²) occurs with a bad pivot choice (already avoided by randomization).

**Complexity:**

| | |
|---|---|
| Time | O(n) average, O(n²) worst |
| Space | O(1) in-place (O(n) recursive call stack in worst case) |
