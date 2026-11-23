# 315. Count of Smaller Numbers After Self — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-of-smaller-numbers-after-self/

---

## Solution: Merge Sort — O(n log n) time, O(n) space

**Idea:** Use a modified merge sort on index-value pairs. During the merge step, when a right-side element is placed before a left-side element, all remaining left elements get a +1 count (since they are all greater than the current right element).

**Algorithm:**
1. Create pairs `(nums[i], i)` and sort by value using merge sort.
2. During merge: when picking from right array before left, increment counts for all remaining left elements.
3. At end, `counts[i]` holds the answer for each original index.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — merge sort |
| Space | O(n) — auxiliary arrays |
