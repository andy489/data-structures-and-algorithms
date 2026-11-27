# 853. Car Fleet — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/car-fleet/

---

## Solution: Sort + Stack — O(n log n) time, O(n) space

**Idea:** Sort cars by position descending (closest to target first). Compute time-to-reach for each car. Use a stack: if the current car's time is <= the top of the stack, it merges into that fleet. Otherwise it forms a new fleet (push its time).

**Algorithm:**
1. Sort cars by position descending.
2. For each car compute time = (target - pos) / speed.
3. If time > stack top, push (new fleet); otherwise it merges.
4. Return stack size.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(n) — stack |
