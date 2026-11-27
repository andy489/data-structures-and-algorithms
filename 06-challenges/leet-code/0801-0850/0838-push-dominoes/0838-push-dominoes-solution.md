# 838. Push Dominoes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/push-dominoes/

---

## Solution: Two-Pass Force Propagation — O(n) time, O(n) space

**Idea:** Compute rightward force (R propagates right) and leftward force (L propagates left). Net force at each position determines final state.

**Algorithm:**
1. Forward pass: propagate R force (decreasing from large value).
2. Backward pass: propagate L force.
3. Each position: if right > left → 'R', right < left → 'L', else '.'.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(n) — force arrays |
