# 2029. Stone Game IX — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game-ix/

---

## Solution: Math/Counting — O(n) time, O(1) space

**Idea:** Count c0, c1, c2 (stones mod 3). Key insight: if c0 is even, Alice wins iff c1 > 0 and c2 > 0. If c0 is odd, Alice wins iff |c1-c2| > 2.

**Algorithm:**
1. Count c0, c1, c2.
2. If c0 even: Alice wins iff c1 > 0 and c2 > 0.
3. If c0 odd: Alice wins iff |c1 - c2| > 2.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
