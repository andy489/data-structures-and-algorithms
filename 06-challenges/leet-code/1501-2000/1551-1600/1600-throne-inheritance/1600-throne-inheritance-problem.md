# 1600. Throne Inheritance

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/throne-inheritance/

---

## Problem Statement

A kingdom consists of a king, his children, his grandchildren, and so on. Over time, this kingdom has overgone the following events:

1. **A person is born** and added as a child of another person.
2. **A person dies**.

The kingdom has a well-defined order of inheritance that consists of the king as the first member. Let's define the recursive function `Successor(x, curOrder)`, which given a person `x` and the inheritance order so far, returns who should be the next person after `x` in the order of inheritance.

```
Successor(x, curOrder):
    if x has no children or all of x's children are in curOrder:
        if x is the king return null
        else return Successor(x's parent, curOrder)
    else return x's oldest child who's not in curOrder
```

Implement the `ThroneInheritance` class:
- `ThroneInheritance(String kingName)` Initializes an object of the `ThroneInheritance` class. The name of the king is given as part of the constructor.
- `void birth(String parentName, String childName)` Indicates that `parentName` gave birth to `childName`.
- `void death(String name)` Indicates the death of `name`. The death of the person doesn't affect the `Successor` function nor the current inheritance order. You can treat it temporarily as just marking the person as dead.
- `String[] getInheritanceOrder()` Returns a list representing the current order of inheritance **excluding** dead people.

---

## Examples

**Example 1:**
```
Input:
["ThroneInheritance","birth","birth","birth","birth","birth","birth","getInheritanceOrder","death","getInheritanceOrder"]
[["king"],["king","andy"],["king","bob"],["king","catherine"],["andy","matthew"],["bob","alex"],["bob","asha"],["death","bob"]]
Output: [null,null,null,null,null,null,null,["king","andy","matthew","bob","alex","asha","catherine"],null,["king","andy","matthew","alex","asha","catherine"]]
```

---

## Constraints

- `1 <= kingName.length, parentName.length, childName.length, name.length <= 15`
- `kingName`, `parentName`, `childName`, and `name` consist of lowercase English letters only
- All arguments `childName` and `kingName` are **distinct**
- All `name` arguments of `death` will be passed to either the constructor or as `childName` to `birth` first
- For each call to `birth(parentName, childName)`, it is guaranteed that `parentName` is alive
- At most `10^5` calls will be made to `birth` and `death`
- At most `10` calls will be made to `getInheritanceOrder`
