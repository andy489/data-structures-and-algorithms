# 3478. Choose K Elements With Maximum Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/choose-k-elements-with-maximum-sum/

---

## Solution: Sort + Min-Heap — O(n log n) time, O(n) space

**Idea:** Sort indices by `nums1` value. Process in sorted order, maintaining a min-heap of size at most `k` tracking the top-k `nums2` values seen so far. For each group of equal `nums1` values, record the current prefix sum before adding to the heap, so they all get the same answer.

**Algorithm:**
1. Create sorted order of indices by `nums1[i]`.
2. Use a min-heap of size `k` and a running `sum` of its elements.
3. For consecutive groups of equal `nums1` values: record `sum` before inserting any of the group.
4. After recording, insert each group's `nums2` values into the heap; pop min if size exceeds `k`, adjusting `sum`.
5. Write the recorded sum to `answer[originalIndex]`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
