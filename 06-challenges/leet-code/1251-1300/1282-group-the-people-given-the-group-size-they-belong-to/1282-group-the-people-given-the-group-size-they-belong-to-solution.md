# 1282. Group the People Given the Group Size They Belong To — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

---

## Solution: HashMap Grouping — O(n) time, O(n) space

**Idea:** Group people by their group size. When a bucket for size k reaches k people, emit it as a group.

**Algorithm:**
1. Map each size to a list of pending people.
2. When list length hits the size, add to result and clear.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
