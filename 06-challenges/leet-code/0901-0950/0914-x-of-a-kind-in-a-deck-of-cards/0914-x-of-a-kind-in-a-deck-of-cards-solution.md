# 914. X of a Kind in a Deck of Cards — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

---

## Solution: GCD of Frequencies — O(n log n) time, O(n) space

**Idea:** Count frequency of each card. If GCD of all frequencies ≥ 2, we can partition with x = GCD.

**Algorithm:**
1. Count frequencies.
2. Compute GCD of all frequencies.
3. Return GCD ≥ 2.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — GCD computation |
| Space | O(n) — frequency map |
