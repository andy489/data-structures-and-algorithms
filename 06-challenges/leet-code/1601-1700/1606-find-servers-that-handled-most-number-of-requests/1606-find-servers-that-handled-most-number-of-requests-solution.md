# 1606. Find Servers That Handled Most Number of Requests — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

---

## Solution: TreeSet + Min-Heap for Busy Servers — O(n log k) time, O(k) space

**Idea:** Maintain a sorted set of available server indices and a min-heap of busy servers keyed by finish time. For each request, first free all servers whose finish time is `<= arrival[i]`, then find the preferred server `i % k` (or the next available one, wrapping around) using a ceiling query on the sorted set.

**Algorithm:**
1. Initialize `available` as a sorted set `{0, 1, ..., k-1}`.
2. Initialize `busy` as a min-heap of `(finishTime, serverIndex)`.
3. For each request `i` at time `t` with duration `l`:
   - Pop all entries from `busy` with `finishTime <= t`; insert freed servers back into `available`.
   - If `available` is empty, drop the request.
   - Otherwise, find the smallest available index `>= i % k`; if none, take the globally smallest.
   - Remove the chosen server from `available`, increment its count, push `(t + l, server)` onto `busy`.
4. Return all servers whose count equals the maximum.

**Complexity:**

| | |
|---|---|
| Time | O(n log k) — each request does O(log k) work on the sorted set and heap |
| Space | O(k) — available set and busy heap each hold at most k entries |
