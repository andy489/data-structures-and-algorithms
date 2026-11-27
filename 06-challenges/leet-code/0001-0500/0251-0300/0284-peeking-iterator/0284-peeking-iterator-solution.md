# 284. Peeking Iterator — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/peeking-iterator/

---

## Solution: Cache Next Element — O(1) per operation, O(1) space

**Idea:** Pre-fetch the next element from the underlying iterator and cache it. `peek()` returns the cache without advancing; `next()` returns the cache and refetches; `hasNext()` checks if the cache is non-null.

**Algorithm:**
1. In the constructor, call `next()` on the iterator to prime the cache (`peeked`).
2. `peek()`: return `peeked`.
3. `next()`: save `peeked`, advance the cache (or null if no more), return saved.
4. `hasNext()`: return `peeked != null`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — per operation |
| Space | O(1) — single cached element |
