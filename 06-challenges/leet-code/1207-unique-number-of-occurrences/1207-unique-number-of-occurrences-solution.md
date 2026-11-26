# 1207. Unique Number of Occurrences — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/unique-number-of-occurrences/

---

## Solution: HashMap + HashSet — O(n) time, O(n) space

**Idea:** Count frequencies with a map, then check all frequencies are distinct using a set.

**Algorithm:**
1. Count each value's frequency.
2. Put all frequencies in a set.
3. Return true if set size equals map size.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
