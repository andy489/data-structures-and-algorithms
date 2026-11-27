# 17. Letter Combinations of a Phone Number — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/letter-combinations-of-a-phone-number/

---

## Solution

### Approach 1 — Backtracking / DFS — O(4^n · n) time

**Idea:** Build combinations character by character using recursion. At each level of the recursion, try each letter mapped to the current digit.

**Algorithm:**
1. Define `backtrack(index, current)`:
   - If `index == digits.length`: add `current` to the result.
   - For each letter `c` mapped to `digits[index]`:
     - `backtrack(index + 1, current + c)`
2. Call `backtrack(0, "")`.

**Complexity:**
- Time: O(4^n · n) — at most 4 choices per digit, n digits deep; O(n) to copy the string at each leaf.
- Space: O(n) call stack depth + O(4^n · n) for all combinations.

---

### Approach 2 — BFS / Iterative — O(4^n · n) time

**Idea:** Start with a queue containing an empty string. For each digit, dequeue every partial combination and enqueue it extended by each letter of the current digit.

**Algorithm:**
1. Initialize `queue = [""]`.
2. For each `digit` in `digits`:
   - For each `combination` in `queue`:
     - For each `letter` mapped to `digit`:
       - Enqueue `combination + letter`.
   - Clear old combinations that don't have the current digit appended yet.
3. Return the queue contents.

**Why BFS here?** All combinations at the same length are processed together, which matches the level-by-level structure of BFS. The result is equivalent to DFS but built iteratively.

---

### Approach 3 — Iterative with Vectors — O(4^n · n) time

Same as BFS but using a plain vector that is replaced at each digit step with the fully expanded set. Avoids queue overhead.

**Complexity (all approaches):**

| | |
|---|---|
| Time | O(4^n · n) — 4^n combinations, each of length n |
| Space | O(4^n · n) — result storage |
