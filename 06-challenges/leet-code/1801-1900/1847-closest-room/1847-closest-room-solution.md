# 1847. Closest Room — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/closest-room/

---

## Solution: Offline Sort + TreeSet — O((n + k) log n) time, O(n + k) space

**Idea:** Process queries offline, sorted by `minSize` descending. Sort rooms by size descending. Maintain a sorted set of eligible room IDs (rooms with size >= current query's minSize). As we process each query, insert all rooms with size >= minSize into the TreeSet. Then find the floor and ceiling of `preferred` in the TreeSet to get the closest room ID.

**Algorithm:**
1. Sort queries by `minSize` descending (keep original indices).
2. Sort rooms by size descending.
3. Use a pointer to insert rooms: while next room's size >= current query's minSize, insert its ID into a TreeSet.
4. For each query: query TreeSet for floor(preferred) and ceiling(preferred). Pick the one with smaller absolute difference (tie: larger id).
5. Write answer at original query index.

**Complexity:**

| | |
|---|---|
| Time | O((n + k) log n) — each room inserted once; each query does O(log n) tree ops |
| Space | O(n + k) — TreeSet and answers array |
