# 1404. Number Of Steps To Reduce A Number In Binary Representation To One — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

---

## Solution: Right-to-Left Carry Simulation — O(n) time, O(1) space

**Idea:** Scan right to left with a carry bit. If bit+carry=1 (odd): add 1 costs 2 steps (add + divide), set carry=1. If 0 (even): 1 step (divide).

**Algorithm:**
1. Set `steps=0, carry=0`.
2. For each bit from right to index 1: if `bit+carry==1` → steps+=2, carry=1; else → steps+=1.
3. Return `steps + carry`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
