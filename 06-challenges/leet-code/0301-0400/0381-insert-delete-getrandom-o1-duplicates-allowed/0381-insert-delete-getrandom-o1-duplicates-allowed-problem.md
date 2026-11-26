# 381. Insert Delete GetRandom O(1) - Duplicates allowed

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

---

## Problem Statement

`RandomizedCollection` is a data structure that contains a multiset of numbers. Implement the `RandomizedCollection` class:
- `RandomizedCollection()` Initializes the empty `RandomizedCollection` object.
- `bool insert(int val)` Inserts an item `val` into the multiset if not present. Returns `true` if the item was not present, `false` otherwise.
- `bool remove(int val)` Removes an item `val` from the multiset if present. Returns `true` if the item was present, `false` otherwise.
- `int getRandom()` Returns a random element from the current multiset of elements. The probability of each element being returned is **linearly related to the number of same values** the multiset contains.

You must implement the functions of the class such that each function works in **average O(1) time complexity**.

---

## Examples

**Example 1:**
```
Input:
["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
[[], [1], [1], [2], [], [1], []]

Output:
[null, true, false, true, 2, true, 1]

Explanation:
RandomizedCollection randomizedCollection = new RandomizedCollection();
randomizedCollection.insert(1);   // return true since the collection does not contain 1.
randomizedCollection.insert(1);   // return false since the collection contains 1.
randomizedCollection.insert(2);   // return true since the collection does not contain 2.
randomizedCollection.getRandom(); // 1 and 2 both equally likely, 2/3 chance 1, 1/3 chance 2
randomizedCollection.remove(1);   // return true since collection contains 1.
randomizedCollection.getRandom(); // 1 and 2 equally likely
```

---

## Constraints

- `-2^31 <= val <= 2^31 - 1`
- At most `2 * 10^5` calls will be made to `insert`, `remove`, and `getRandom`.
- There will be at least one element in the data structure when `getRandom` is called.
