# 1499. Max Value Of Equation — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/max-value-of-equation/

---

## Solution: Monotonic Deque — O(n) time, O(n) space

**Idea:** yi+yj+xj-xi = (yi-xi) + (yj+xj). Maximize (yj+xj) + max(yi-xi) in a sliding window of size k.

**Algorithm:**
1. Maintain a decreasing deque of (y-x) values.
2. For each j: pop deque front if xj - x[front] > k.
3. ans = max(ans, deque.front + (yj+xj)).
4. Pop deque back while back's (y-x) <= (yj-xj). Push j.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
