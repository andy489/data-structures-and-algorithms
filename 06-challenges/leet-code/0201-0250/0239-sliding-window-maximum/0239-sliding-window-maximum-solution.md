# 239. Sliding Window Maximum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sliding-window-maximum/

---

## Solution: Monotonic Deque — O(n) time, O(k) space

**Idea:** Maintain a deque of indices in decreasing order of their values. The front of the deque is always the index of the maximum in the current window. Before adding a new element, pop the back while it is smaller (they can never be the maximum). Pop the front if it is out of the window.

**Algorithm:**
1. Use a `Deque<Integer>` storing indices.
2. For each `i`: while deque not empty and `nums[deque.last] <= nums[i]`, pop back; push `i`.
3. While `deque.front < i - k + 1`, pop front.
4. If `i >= k - 1`, emit `nums[deque.front]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each index pushed and popped at most once |
| Space | O(k) — deque size |
