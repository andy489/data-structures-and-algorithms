# 843. Guess the Word — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/guess-the-word/

---

## Solution: Minimax — O(n² · L) time, O(n) space

**Idea:** Each guess filters the candidate list to those with the same match count. Pick the word that minimizes the worst-case remaining candidates (minimax). A simpler heuristic: pick the word with fewest zero-match pairs.

**Algorithm:**
1. Maintain a candidate list (initially all words).
2. For each guess, pick the candidate that minimizes max remaining (or minimize zero-match count).
3. After guessing, filter candidates to those matching the returned score.
4. Repeat up to 10 times.

**Complexity:**

| | |
|---|---|
| Time | O(n² · L) — n² candidate pairs, L=6 comparison |
| Space | O(n) — candidate list |
