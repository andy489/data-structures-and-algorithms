# 349. Intersection of Two Arrays — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/intersection-of-two-arrays/

---

## Solution: HashSet — O(n + m) time, O(n) space

**Idea:** Store `nums1` in a set. Iterate `nums2`, add to result set if found in `nums1` set.

**Algorithm:**
1. `set1 = HashSet(nums1)`, `result = HashSet`.
2. For each `n` in `nums2`: if `set1` contains `n`, add to `result`.
3. Return `result` as array.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(n) — set1 |
