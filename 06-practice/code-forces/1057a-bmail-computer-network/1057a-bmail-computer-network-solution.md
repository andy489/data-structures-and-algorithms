# 1057A. Bmail Computer Network — Solution

---

## Key Insight

Since the tree is given via parent pointers (`pᵢ < i`), we can trace **backwards from router *n* to router 1** using parent pointers, collecting the path, then reverse it.

---

## Algorithm

1. Read parent array `p[2..n]`.
2. Start at `current = n`.
3. While `current != 1`:
   - Append `current` to path.
   - `current = p[current]`
4. Append `1` to path.
5. Reverse the path and output.

**Why it terminates:** Each step moves to a strictly smaller index (`pᵢ < i`), so we reach 1 in at most *n* − 1 steps.

---

## Complexity

| | |
|---|---|
| Time | O(n) — path length ≤ n |
| Space | O(n) — path storage |
