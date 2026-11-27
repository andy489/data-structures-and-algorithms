# 1574. Shortest Subarray to Be Removed to Make Array Sorted — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** The result is the shortest subarray to remove such that the remaining prefix and suffix can be concatenated in non-decreasing order. Find the longest non-decreasing suffix (right pointer). Then try extending the prefix left-to-right, advancing the right pointer to find the merge point.

**Algorithm:**
1. Find the rightmost `r` such that `arr[r-1..n-1]` is non-decreasing. The initial answer is `r` (remove the entire prefix).
2. Walk `l` from 0 rightward; advance `r` until `arr[r] >= arr[l]`. Update result with `r - l - 1`.
3. Stop if the prefix becomes non-monotone.

**Complexity:**

| | |
|---|---|
| Time | O(n) — both pointers move at most n steps total |
| Space | O(1) — only index variables |
