# 3396. Minimum Number of Operations to Make Elements in Array Distinct — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/

---

## Solution: Scan from Right — O(n) time, O(n) space

**Idea:** Instead of simulating removals, scan the array from right to left. Find the rightmost index where a duplicate first appears. Everything from index 0 up to that index (inclusive) must be removed. The number of operations is `ceil((idx + 1) / 3)`.

**Algorithm:**
1. Traverse the array from right to left keeping a HashSet of seen elements.
2. The moment a duplicate is encountered at index `i`, the answer is `(i / 3) + 1`.
3. If no duplicate is found, return `0`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — HashSet |
