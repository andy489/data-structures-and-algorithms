# 1847. Closest Room

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/closest-room/

---

## Problem Statement

There is a hotel with `n` rooms. The rooms are represented by a 2D integer array `rooms` where `rooms[i] = [roomId_i, size_i]` denotes that there is a room with room number `roomId_i` and size equal to `size_i`. Each `roomId_i` is guaranteed to be **unique**.

You are also given `k` queries in a 2D array `queries` where `queries[j] = [preferred_j, minSize_j]`. The answer to the `j`th query is the room number `id` of a room such that:

- The room has a size of **at least** `minSize_j`, and
- `abs(id - preferred_j)` is **minimized**, and
- If there is a tie in the absolute difference, the **largest** room id is chosen.

Return *an array* `ans` *of length* `k` *where* `ans[j]` *contains the answer to the* `j`th *query.*

---

## Examples

**Example 1:**
```
Input: rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
Output: [3,-1,3]
Explanation: The answers to the queries are as follows:
Query = [3,1]: Room 3 is the closest as abs(3-3) = 0, and its size of 2 >= 1. The answer is 3.
Query = [3,3]: There are no rooms with a size of at least 3, so the answer is -1.
Query = [5,2]: Room 3 is the closest as abs(3-5) = 2, and its size of 2 >= 2. The answer is 3.
```

**Example 2:**
```
Input: rooms = [[1,4],[2,3],[3,5],[4,1],[5,2]], queries = [[2,3],[2,4],[2,5]]
Output: [2,1,3]
```

---

## Constraints

- `n == rooms.length`
- `1 <= n <= 10^5`
- `k == queries.length`
- `1 <= k <= 10^4`
- `1 <= roomId_i <= 10^7`
- `1 <= size_i <= 10^7`
- `1 <= preferred_j <= 10^7`
- `1 <= minSize_j <= 10^7`
