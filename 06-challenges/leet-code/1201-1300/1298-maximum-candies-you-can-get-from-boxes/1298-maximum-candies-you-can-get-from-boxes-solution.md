# 1298. Maximum Candies You Can Get from Boxes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/

---

## Solution: BFS — O(n) time, O(n) space

**Idea:** Use BFS. Keep track of boxes we have (possess) and boxes we have keys for. Process open boxes immediately.

**Algorithm:**
1. BFS queue: open boxes we can open.
2. When processing box: collect candies, add keys to opened set, add contained boxes to possessed.
3. Re-enqueue possessed boxes we now have keys for.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
