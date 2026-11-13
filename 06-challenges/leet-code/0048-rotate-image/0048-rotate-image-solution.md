# 48. Rotate Image — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rotate-image/

---

## Solution: Transpose + Reverse rows — O(n²) time, O(1) space

**Idea:**

A 90° clockwise rotation is equivalent to two simpler operations done in sequence:

1. **Transpose** — swap `matrix[i][j]` with `matrix[j][i]` (reflect across the main diagonal).
2. **Reverse each row** — flip every row left-to-right.

Why does this work? After transposing, column `j` of the original becomes row `j`. Reversing each row then puts the leftmost element (which was the top of the original column) at the right — exactly where a clockwise rotation puts it.

**Example:** `[[1,2,3],[4,5,6],[7,8,9]]`

```
Transpose:        Reverse rows:
1 4 7             7 4 1
2 5 8    →        8 5 2
3 6 9             9 6 3  ✓
```

**Algorithm:**
1. Transpose: for each `i` from `0` to `n-1`, for each `j` from `i+1` to `n-1`, swap `matrix[i][j]` and `matrix[j][i]`.
2. Reverse rows: for each row, swap `matrix[i][j]` with `matrix[i][n-1-j]` for `j` from `0` to `n/2 - 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — visit every cell twice |
| Space | O(1) — in-place, only a swap temp variable |

---

## Solution 2: Layer-by-layer 4-way cycle — O(n²) time, O(1) space

**Idea:**

Process the matrix ring by ring from the outside in. Within each ring, rotate four elements at a time in a cycle: top→right, right→bottom, bottom→left, left→top.

For ring `layer`, elements span indices `layer` to `n-1-layer`. For each element `i` in that range (offset `first` to `last-1`):

```
offset = i - layer
top    = matrix[layer][i]
matrix[layer][i]             = matrix[last-offset][layer]      (left → top)
matrix[last-offset][layer]   = matrix[last][last-offset]       (bottom → left)
matrix[last][last-offset]    = matrix[i][last]                 (right → bottom)
matrix[i][last]              = top                             (top → right)
```

**Complexity:**

| | |
|---|---|
| Time | O(n²) — each element touched once |
| Space | O(1) — one temp variable per cycle |
