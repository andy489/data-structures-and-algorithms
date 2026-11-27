# 1629. Slowest Key — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/slowest-key/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Compute each key's duration in a single pass. Track the maximum duration seen; on a tie, prefer the lexicographically larger key.

**Algorithm:**
1. Initialize `maxDuration = releaseTimes[0]`, `ans = keysPressed[0]`.
2. For each `i` from `1` to `n - 1`:
   - Compute `dur = releaseTimes[i] - releaseTimes[i - 1]`.
   - If `dur > maxDuration` or (`dur == maxDuration` and `keysPressed[i] > ans`): update.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra |
