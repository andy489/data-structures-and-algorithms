# 384. Shuffle an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shuffle-an-array/

---

## Solution: Fisher-Yates Shuffle — O(n) time, O(n) space

**Idea:** Use the Fisher-Yates algorithm for an unbiased shuffle. Store the original array for `reset`.

**Algorithm:**
1. Keep `original` copy.
2. `reset()`: return a copy of `original`.
3. `shuffle()`: for `i` from last to 1, swap `nums[i]` with `nums[random j in [0, i]]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) for shuffle, O(n) for reset |
| Space | O(n) — stored original |
