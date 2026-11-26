# 860. Lemonade Change — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/lemonade-change/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Track $5 and $10 bills. For $10 bill, give back one $5. For $20 bill, prefer to give $10+$5 (saves $5 bills for more flexibility), else give three $5s.

**Algorithm:**
1. Keep counters five and ten.
2. Bill $5: five++.
3. Bill $10: if five == 0 return false; five--, ten++.
4. Bill $20: if ten > 0 and five > 0: ten--, five--; else if five >= 3: five -= 3; else return false.
5. Return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
