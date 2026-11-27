# 466. Count The Repetitions — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-the-repetitions/

---

## Solution: Cycle Detection — O(|s1| · |s2|) time, O(|s2|) space

**Idea:** Simulate matching `s2` characters against repeated `s1`. After each copy of `s1`, record the state: how far into `s2` we are. When a repeated state is found, compute the number of full `s2` repetitions in the cycle and handle the prefix and suffix separately.

**Algorithm:**
1. Simulate going through `s1` copies one at a time, tracking `s2Index` after each copy.
2. Use a map `s2IndexToRound` to detect when `s2Index` repeats.
3. On cycle detection: compute counts in prefix, cycle, and suffix. Return total `s2` repetitions / `n2`.

**Complexity:**

| | |
|---|---|
| Time | O(|s1| · |s2|) — cycle detected within |s2| iterations |
| Space | O(|s2|) — state map |
