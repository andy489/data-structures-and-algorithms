# 1157. Online Majority Element In Subarray — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/online-majority-element-in-subarray/

---

## Solution: Boyer-Moore Voting (Segment Tree) + Binary Search — O(n log n) build, O(log² n) query

**Idea:** Because `2 * threshold > right - left + 1`, any majority element in the range must also be the Boyer-Moore candidate for that range. Use a segment tree where each node stores the Boyer-Moore candidate and its net count for its range. At query time, extract the candidate from the tree in O(log n), then verify its true count in `[left, right]` using binary search on a precomputed positions map — also O(log n).

**Algorithm:**
1. Build a segment tree where each leaf holds `(arr[i], 1)`. Internal nodes merge pairs via Boyer-Moore: if candidates match, sum counts; otherwise subtract the smaller from the larger and keep the larger's candidate.
2. For each value, store a sorted list of its indices.
3. On `query(left, right, threshold)`:
   a. Query the segment tree for the Boyer-Moore candidate of `[left, right]`.
   b. Count occurrences of that candidate in `[left, right]` using binary search on its index list.
   c. Return the candidate if count >= threshold, else -1.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) build, O(log² n) per query |
| Space | O(n log n) — segment tree + index lists |
