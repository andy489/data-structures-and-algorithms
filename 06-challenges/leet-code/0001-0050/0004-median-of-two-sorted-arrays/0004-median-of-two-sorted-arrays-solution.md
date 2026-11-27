# 4. Median of Two Sorted Arrays — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/median-of-two-sorted-arrays/

---

## Solution

### Binary Search on Partition — O(log(min(m, n))) time, O(1) space

**Core idea:** Instead of merging both arrays, find the correct **partition point** in both arrays simultaneously such that all elements on the left half are ≤ all elements on the right half.

**Setup:**
- Without loss of generality, binary search on the shorter array (`nums1`).
- If we place `i` elements from `nums1` on the left and `j = (m+n+1)/2 - i` elements from `nums2` on the left, we have a valid partition when:
  - `nums1[i-1] <= nums2[j]`  (left of nums1 ≤ right of nums2)
  - `nums2[j-1] <= nums1[i]`  (left of nums2 ≤ right of nums1)

**Binary search:**
- If `nums1[i-1] > nums2[j]`, move `i` left (too many elements from nums1 on the left).
- If `nums2[j-1] > nums1[i]`, move `i` right.

**Median calculation:**
- If `m + n` is odd: median = `max(left elements)`.
- If even: median = `(max(left) + min(right)) / 2`.

**Edge cases:** Treat out-of-bounds as `-∞` or `+∞` using sentinel values.

**Why O(log(min(m,n))):** Binary search on the smaller array, at most log(min(m,n)) iterations.

**Complexity:**

| | |
|---|---|
| Time | O(log(min(m, n))) |
| Space | O(1) |
