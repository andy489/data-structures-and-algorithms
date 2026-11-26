# 1206. Design Skiplist

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/design-skiplist/

---

## Problem Statement

Design a Skiplist without using any built-in libraries.

A skiplist is a data structure that takes O(log(n)) time to add, erase and search. Implement the `Skiplist` class:
- `Skiplist()` Initializes the object of the skiplist.
- `bool search(int target)` Returns `true` if the integer `target` exists in the Skiplist or `false` otherwise.
- `void add(int num)` Inserts the value `num` into the skiplist.
- `bool erase(int num)` Removes the value `num` from the skiplist and returns `true`. If `num` does not exist, return `false`.

---

## Examples

**Example 1:**
```
Input:  ["Skiplist","add","add","add","search","add","search","erase","erase","search"]
Output: [null,null,null,null,false,null,true,true,false,false]
```

---

## Constraints

- `0 <= num, target <= 2 * 10^4`
- `At most 5 * 10^4 calls will be made to search, add, and erase`
