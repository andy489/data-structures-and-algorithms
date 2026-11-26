# 2089. Find Target Indices After Sorting Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-target-indices-after-sorting-array/

---

## Solution: Count Less and Equal — O(n) time, O(1) space

**Idea:** Count elements less than target → starting index. Count elements equal to target → number of indices.

**Algorithm:**
1. Count `less` = number of elements < target.
2. Count `equal` = number of elements == target.
3. Return indices from `less` to `less + equal - 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
