# 1600. Throne Inheritance — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/throne-inheritance/

---

## Solution: N-ary Tree with HashMap — O(n) per getInheritanceOrder, O(n) space

**Idea:** Model the family as an n-ary tree rooted at the king using a HashMap. DFS in pre-order gives the correct inheritance order, skipping dead members.

**Algorithm:**
1. `birth(parent, child)`: add `child` to `children[parent]`.
2. `death(name)`: add `name` to `dead` set.
3. `getInheritanceOrder()`: DFS from king, visit node before children (pre-order), skip dead people.

**Complexity:**

| | |
|---|---|
| Time | O(n) per getInheritanceOrder — visit every person once |
| Space | O(n) — children map and dead set |
