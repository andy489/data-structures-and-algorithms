# 745. Prefix and Suffix Search — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/prefix-and-suffix-search/

---

## Solution: HashMap with Combined Key — O(n·L²) build, O(L) query

**Idea:** Precompute all `(prefix, suffix)` pairs for each word at index `i`, storing the max index. For word `apple` at index 0, store keys like `("a","e")`, `("ap","e")`, etc. At query time, look up `(pref, suff)` directly.

**Algorithm:**
1. For each word at index `i`, enumerate all `(prefix, suffix)` combinations.
2. Store `map[(prefix, suffix)] = i` (last write wins = max index since we iterate in order).
3. For `f(pref, suff)`: return `map.getOrDefault((pref, suff), -1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n·L²) build — L = max word length; O(1) query |
| Space | O(n·L²) — hash map entries |
