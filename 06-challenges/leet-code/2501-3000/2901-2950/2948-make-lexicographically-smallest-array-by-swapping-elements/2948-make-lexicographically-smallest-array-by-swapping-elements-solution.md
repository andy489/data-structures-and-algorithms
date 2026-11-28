# 2948. Make Lexicographically Smallest Array by Swapping Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

---

## Solution: Sort + Group by Reachability — O(n log n) time, O(n) space

**Idea:** Elements that can reach each other through a chain of swaps form groups. Two values are in the same group if adjacent sorted values differ by at most `limit`. Within each group, we can freely permute the values. To minimize lexicographic order, sort the original indices of each group and assign sorted values back to sorted positions.

**Algorithm:**
1. Create pairs (value, originalIndex), sort by value.
2. Group consecutive pairs where the value gap <= limit into the same group.
3. For each group: collect the original indices, sort them, and assign the group's values (already sorted) in order back to those indices.
4. Return the result array.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
