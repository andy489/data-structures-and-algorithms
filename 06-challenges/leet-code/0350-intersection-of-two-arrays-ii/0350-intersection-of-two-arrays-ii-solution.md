# 350. Intersection of Two Arrays II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/intersection-of-two-arrays-ii/

---

## Solution: HashMap Frequency Count — O(n + m) time, O(min(n, m)) space

**Idea:** Count frequencies of the smaller array in a HashMap. For each element in the other array, if it's in the map with count > 0, add to result and decrement count.

**Algorithm:**
1. Count frequencies of `nums1` in a HashMap.
2. For each `n` in `nums2`: if `cloned.getOrDefault(n, 0) > 0`, add to result, decrement count.
3. Return result array.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(min(n, m)) — frequency map |

---

## Solution 2: Sort + Two Pointers — O(n log n + m log m) time, O(1) space

**Idea:** Sort both arrays, then use two pointers to find common elements.

**Algorithm:**
1. Sort `nums1` and `nums2`.
2. Two pointers `i`, `j`; advance whichever is smaller; on match, record and advance both.

**Complexity:**

| | |
|---|---|
| Time | O(n log n + m log m) |
| Space | O(1) extra |
