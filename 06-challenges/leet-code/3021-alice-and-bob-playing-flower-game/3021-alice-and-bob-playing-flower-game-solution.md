# 3021. Alice And Bob Playing Flower Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/alice-and-bob-playing-flower-game/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** x+y is odd iff one is odd and the other is even. Count odd x in [1,n] = ceil(n/2) = (n+1)/2. Count even x in [1,n] = floor(n/2) = n/2. Similarly for y. Answer = oddX * evenY + evenX * oddY.

**Algorithm:**
1. oddX = (n+1)/2, evenX = n/2.
2. oddY = (m+1)/2, evenY = m/2.
3. Return oddX * evenY + evenX * oddY.

**Complexity:**

| | |
|---|---|
| Time | O(1) — O(1) |
| Space | O(1) — O(1) |
