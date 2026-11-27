# 1993. Operations on Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/operations-on-tree/

## Description

You are given a tree with `n` nodes numbered from `0` to `n - 1` in the form of a parent array `parent` where `parent[i]` is the parent of the `i`th node. The root of the tree is node `0`, so `parent[0] = -1` since it has no parent. You want to design a data structure that allows users to lock, unlock, and upgrade nodes in the tree.

The data structure should support the following functions:

- **Lock:** Locks the given node for the given user and prevents other users from locking the same node. You may only lock a node using this function if the node is unlocked.
- **Unlock:** Unlocks the given node for the given user. You may only unlock a node using this function if it is currently locked by the same user.
- **Upgrade:** Locks the given node for the given user and unlocks all of its descendants regardless of who locked it. You may only upgrade a node if all 3 conditions are true:
  - The node is unlocked,
  - It has at least one locked descendant (by any user), and
  - It does not have any locked ancestors.

Implement the `LockingTree` class:

- `LockingTree(int[] parent)` initializes the data structure with the parent array.
- `lock(int num, int user)` returns `true` if it is possible for the user with id `user` to lock the node `num`, or `false` otherwise.
- `unlock(int num, int user)` returns `true` if it is possible for the user with id `user` to unlock the node `num`, or `false` otherwise.
- `upgrade(int num, int user)` returns `true` if it is possible for the user with id `user` to upgrade the node `num`, or `false` otherwise.

## Examples

**Example 1:**
```
Input:
["LockingTree", "lock", "unlock", "unlock", "lock", "upgrade", "lock"]
[[[-1, 0, 0, 1, 1, 2, 2]], [2, 2], [2, 3], [2, 2], [4, 5], [0, 1], [0, 1]]
Output:
[null, true, false, true, true, true, false]
```

## Constraints

- `n == parent.length`
- `2 <= n <= 2000`
- `0 <= parent[i] <= n - 1` for `i != 0`
- `parent[0] == -1`
- `0 <= num <= n - 1`
- `1 <= user <= 10^4`
- `parent` represents a valid tree.
- At most `2000` calls in total will be made to `lock`, `unlock`, and `upgrade`.
