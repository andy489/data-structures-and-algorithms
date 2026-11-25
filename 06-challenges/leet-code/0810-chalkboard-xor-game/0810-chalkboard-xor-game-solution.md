# 810. Chalkboard XOR Game — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/chalkboard-xor-game/

---

## Solution: Math Insight — O(n) time, O(1) space

**Idea:** Alice wins iff the XOR of all nums is 0, OR the array has even length. Key insight: if XOR ≠ 0 and length is odd, Alice is forced to lose; if length is even, Alice can always mirror Bob's strategy.

**Algorithm:**
1. Compute XOR of all elements.
2. Return true if xor == 0 OR n is even.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single XOR pass |
| Space | O(1) — constant space |
