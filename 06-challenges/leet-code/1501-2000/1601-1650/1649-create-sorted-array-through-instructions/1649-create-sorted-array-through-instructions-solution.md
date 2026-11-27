# 1649. Create Sorted Array Through Instructions — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/create-sorted-array-through-instructions/

---

## Solution: Binary Indexed Tree (Fenwick Tree) — O(n log M) time, O(M) space

**Idea:** Use a Fenwick tree over the value range [1, MAX] to query prefix sums. For each instruction value `v`:
- `less = query(v - 1)` — count of inserted elements < v
- `greater = i - query(v)` — count of inserted elements > v (total so far minus elements ≤ v)
- `cost += min(less, greater)`
- Update the Fenwick tree at position `v`.

**Algorithm:**
1. Initialize Fenwick tree of size `MAX = 100001`.
2. For each `v` in `instructions`:
   - Query prefix sum up to `v-1` for `less`.
   - Query prefix sum up to `v` for `lessOrEqual`; compute `greater = i - lessOrEqual`.
   - Accumulate `min(less, greater)`.
   - Update tree at `v`.
3. Return total cost modulo `10^9 + 7`.

**Complexity:**

| | |
|---|---|
| Time | O(n log M) — n insertions, each O(log M) query and update |
| Space | O(M) — Fenwick tree |
