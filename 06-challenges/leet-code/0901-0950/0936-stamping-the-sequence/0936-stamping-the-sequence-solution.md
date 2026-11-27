# 936. Stamping the Sequence — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stamping-the-sequence/

---

## Solution: Reverse Greedy — O(n² × m) time, O(n) space

**Idea:** Work backwards: repeatedly find a window in target that matches stamp (allowing '?'s), replace it with '?'s, and record the position. Repeat until all '?'; reverse the recorded positions.

**Algorithm:**
1. Repeat: scan all valid positions; if stamp matches (at least 1 non-'?'), stamp it, record pos, set stamped=true.
2. If a full pass makes no progress and target not all '?', return [].
3. Reverse recorded positions and return.

**Complexity:**

| | |
|---|---|
| Time | O(n² × m) |
| Space | O(n) |
