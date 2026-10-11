# 802J. Send the Fool Further! (easy) — Solution

---

## Key Insight

Define `E[v]` = expected number of steps to reach a leaf starting from node *v*.

- If *v* is a leaf: `E[v] = 0`.
- Otherwise, the fool moves to each child with equal probability 1/*k* (where *k* = number of children):
  ```
  E[v] = 1 + (1/k) * Σ E[child]
  ```

This is a straightforward **tree DP** computed bottom-up.

---

## Algorithm

1. Root the tree at vertex 1.
2. DFS post-order:
   - For leaves: `E[v] = 0.0`.
   - For internal nodes with children `c₁, c₂, ..., cₖ`:
     `E[v] = 1.0 + (E[c₁] + E[c₂] + ... + E[cₖ]) / k`
3. Output `E[1]`.

---

## Example

For a path `1 → 2 → 3` (linear tree):
- `E[3] = 0`
- `E[2] = 1 + E[3] = 1`
- `E[1] = 1 + E[2] = 2`

For a star with root 1 and leaves 2, 3, 4:
- Each child has `E = 0`
- `E[1] = 1 + 0 = 1`

---

## Complexity

| | |
|---|---|
| Time | O(n) — single DFS |
| Space | O(n) — recursion stack + E array |
