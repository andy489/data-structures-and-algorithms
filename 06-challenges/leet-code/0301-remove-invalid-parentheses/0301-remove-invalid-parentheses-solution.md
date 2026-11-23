# 301. Remove Invalid Parentheses — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/remove-invalid-parentheses/

---

## Solution: BFS Level-by-Level — O(2^n) time, O(2^n) space

**Idea:** Use BFS where each level removes one more character. The first level where we find any valid string gives us all answers with minimum removals. At each level, generate all strings with one character removed; skip duplicates with a visited set.

**Algorithm:**
1. Start with `{s}` in the queue.
2. For each string in the current level, check validity. If valid, record it and stop expanding.
3. If none valid, generate all strings with one character removed and add unseen ones to next level.
4. Return all recorded valid strings.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — each removal doubles candidates |
| Space | O(2^n) — visited set |

---

## Solution 2: DFS with Counting — O(2^n) time, O(n) space

**Idea:** Count the number of mismatched `(` and `)` to know exactly how many to remove. Then DFS, pruning when we've removed more than the allowed count.

**Algorithm:**
1. Count `leftRem` (extra `(`) and `rightRem` (extra `)`) in one pass.
2. DFS: at each index, try keeping or removing the character.
3. Skip duplicates by not removing the same character twice in a row.
4. When index reaches end, check if 0 removals remain and string is valid.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — but heavily pruned in practice |
| Space | O(n) — recursion depth |
