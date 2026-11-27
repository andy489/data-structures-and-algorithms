# 1622. Fancy Sequence — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/fancy-sequence/

---

## Solution: Lazy Propagation with Modular Inverse — O(1) per operation time, O(n) space

**Idea:** Maintain global `add` and `mult` lazy multipliers. When appending `val`, normalize it to the "base" value by applying the inverse of current transforms: `base = (val - add) * modInverse(mult)`. When querying, apply current transforms back: `result = base * mult + add`.

**Algorithm:**
1. Maintain `add = 0`, `mult = 1` as lazy global offsets.
2. `append(val)`: store `base = (val - add + MOD) * modInverse(mult) % MOD`.
3. `addAll(inc)`: `add = (add + inc) % MOD`.
4. `multAll(m)`: `mult = mult * m % MOD`; `add = add * m % MOD`.
5. `getIndex(idx)`: return `(seq[idx] * mult + add) % MOD` or `-1` if out of bounds.
6. `modInverse(x)` uses Fermat's little theorem: `x^(MOD-2) % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(log MOD) per append (modular inverse), O(1) for other ops |
| Space | O(n) — stored base values |
