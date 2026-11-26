# 705. Design HashSet

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/design-hashset/

---

## Problem Statement

Design a HashSet without using any built-in hash table libraries.

Implement `MyHashSet` class:
- `void add(int key)` Inserts the value `key` into the HashSet.
- `bool contains(int key)` Returns whether the value `key` exists in the HashSet or not.
- `void remove(int key)` Removes the value `key` in the HashSet. If `key` does not exist in the HashSet, do nothing.

---

## Examples

**Example 1:**
```
Input:  ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
        [[],[1],[2],[1],[3],[2],[2],[2],[2]]
Output: [null,null,null,true,false,null,true,null,false]
```

---

## Constraints

- `0 <= key <= 10^6`
- At most `10^4` calls will be made to `add`, `remove`, and `contains`.
