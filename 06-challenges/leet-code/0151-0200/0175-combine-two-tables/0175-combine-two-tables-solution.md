# 175. Combine Two Tables — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/combine-two-tables/

---

## Solution: LEFT JOIN — O(n·m) time, O(n) space

**Idea:** Every person must appear in the result regardless of whether they have an address — this is the defining use case for a `LEFT JOIN`. Joining `Person` on the left with `Address` on the right preserves all persons and fills unmatched address columns with `NULL`.

**Algorithm:**
1. Select `firstName`, `lastName` from `Person` and `city`, `state` from `Address`.
2. `LEFT JOIN Address ON Person.personId = Address.personId`.
3. Unmatched rows automatically produce `NULL` for `city` and `state`.

**Complexity:**

| | |
|---|---|
| Time | O(n·m) — join of Person (n rows) with Address (m rows); O(n log n) with an index on personId |
| Space | O(n) — result set has one row per person |
