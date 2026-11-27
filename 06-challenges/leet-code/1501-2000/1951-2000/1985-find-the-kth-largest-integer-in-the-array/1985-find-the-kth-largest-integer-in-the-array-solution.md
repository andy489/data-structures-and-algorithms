# 1985. Find the Kth Largest Integer in the Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/

---

## Solution: Custom Sort — O(n log n) time, O(1) extra space

**Idea:** Sort strings as integers by comparing: first by length (longer = larger), then lexicographically if same length. Return element at index `n - k`.

**Algorithm:**
1. Sort `nums` with comparator: compare by length first, then lexicographically.
2. Return `nums[nums.length - k]`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n · L) where L = max string length |
| Space | O(1) |
