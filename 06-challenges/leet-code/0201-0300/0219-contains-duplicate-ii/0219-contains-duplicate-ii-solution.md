# 219. Contains Duplicate II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/contains-duplicate-ii/

---

## Solution: Sliding Window HashSet — O(n) time, O(k) space

**Idea:** Maintain a HashSet of the last `k` elements. For each new element check if it is already in the set. If yes, a duplicate within distance `k` exists. Otherwise, add it and evict the element that is now out of the window.

**Algorithm:**
1. Maintain a `HashSet<Integer> window`.
2. For each index `i`: if `window.contains(nums[i])` return `true`.
3. `window.add(nums[i])`. If `window.size() > k`, remove `nums[i - k]`.
4. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(k) — sliding window |
