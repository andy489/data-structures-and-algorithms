# 599. Minimum Index Sum of Two Lists — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-index-sum-of-two-lists/

---

## Solution: HashMap — O(m + n) time, O(m) space

**Idea:** Index all strings in `list1` with their positions. Scan `list2`; for each string also in `list1`, compute index sum. Track minimum and collect all strings achieving that minimum.

**Algorithm:**
1. Build `indexInList1` map: string → index.
2. For each string in `list2` at index `j`, if present in map at index `i`, compute `i + j`.
3. If new minimum, reset result list; if equal to minimum, add to result list.

**Complexity:**

| | |
|---|---|
| Time | O(m + n) |
| Space | O(m) for the map |
