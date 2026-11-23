# 352. Data Stream as Disjoint Intervals — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/data-stream-as-disjoint-intervals/

---

## Solution: TreeMap Interval Merge — O(log n) add, O(n) getIntervals, O(n) space

**Idea:** Use a `TreeMap<Integer, Integer>` mapping interval start → end. On `addNum`, find the predecessor and successor intervals and merge if they touch or overlap.

**Algorithm:**
1. Find the floor key (predecessor) and ceiling key (successor) around `value`.
2. If `value` falls inside an existing interval, do nothing.
3. Merge with predecessor if `pred.end + 1 >= value`.
4. Merge with successor if `value + 1 >= succ.start`.
5. `getIntervals` converts the map entries to a 2D array.

**Complexity:**

| | |
|---|---|
| Time | O(log n) add, O(n) getIntervals |
| Space | O(n) — at most n intervals in the map |
