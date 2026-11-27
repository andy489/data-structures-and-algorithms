# 403. Frog Jump — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/frog-jump/

---

## Solution: Dynamic Programming with HashSet — O(n²) time, O(n²) space

**Idea:** Use a map from each stone position to the set of jump sizes that can reach it. Start with stone 0 reachable by jump 0. For each stone, try k-1, k, k+1 and add to the target stone's set if that position exists.

**Algorithm:**
1. Build a set of all stone positions for O(1) lookup, and a map from position → set of valid incoming jumps.
2. Seed stone 0 with jump size 0.
3. For each stone in order, for each jump k in its set, try positions stone+k-1, stone+k, stone+k+1; if valid stone, add jump to its set.
4. Return true if the last stone's set is non-empty.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — at most n jump sizes per stone |
| Space | O(n²) — sets across all stones |
