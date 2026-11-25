# 769. Max Chunks To Make Sorted — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-chunks-to-make-sorted/

---

## Solution: Max Tracking — O(n) time, O(1) space

**Idea:** Since `arr` is a permutation of `[0..n-1]`, we can cut a chunk at index `i` when `max(arr[0..i]) == i`. This means all elements from 0 to i are within the first i+1 slots.

**Algorithm:**
1. Track running max.
2. When `max == i`, increment chunk count.
3. Return chunk count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
