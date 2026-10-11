# 1139C. Edgy Trees — Solution

---

## Key Insight

Use **complementary counting**:

```
good sequences = total sequences − bad sequences
```

A sequence is **bad** if it uses **only red edges** (zero black edges traversed). A path uses only red edges if and only if both endpoints are connected through red-only edges — i.e., they are in the **same red-only connected component**.

**Red-only components:** Remove all black edges from the tree. The remaining red edges partition the vertices into connected components. A sequence is bad only if all *k* vertices lie within the same red component.

---

## Algorithm

1. Build DSU using only **red edges** (color = 0).
2. For each component, compute its size `sᵢ`.
3. Total sequences = `nᵏ mod (10⁹+7)`.
4. Bad sequences = `Σ sᵢᵏ mod (10⁹+7)` (all *k* vertices in same component).
5. Answer = `(total − bad + MOD) % MOD`.

### DFS Approach (alternative to DSU)

Remove black edges and run DFS/BFS to find connected components in the red-only forest. Then apply the same formula.

---

## Complexity

| | |
|---|---|
| Time | O(n · α(n)) for DSU, or O(n) for DFS |
| Space | O(n) |

**Note:** Use modular exponentiation (`fast_pow(base, exp, mod)`) for computing `nᵏ` and `sᵢᵏ` since *k* ≤ 100.
