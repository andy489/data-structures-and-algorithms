# 528. Random Pick with Weight — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/random-pick-with-weight/

---

## Solution: Prefix Sum + Binary Search — O(n) build, O(log n) per pick

**Idea:** Build a prefix sum array. A random number in `[1, totalWeight]` falls in a range that maps to exactly one index (proportional to its weight). Use binary search to find that index.

**Algorithm:**
1. Build `prefixSums` where `prefixSums[i] = sum(w[0..i])`.
2. For `pickIndex()`, generate random int in `[1, totalWeight]`.
3. Binary search in `prefixSums` for the leftmost index where `prefixSums[i] >= target`.

**Complexity:**

| | |
|---|---|
| Time | O(n) build, O(log n) per pick |
| Space | O(n) — prefix sums array |
