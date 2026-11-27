# 1171. Remove Zero Sum Consecutive Nodes from Linked List

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

---

## Problem Statement

Given the `head` of a linked list, repeatedly delete consecutive sequences of nodes that sum to `0` until no such sequence remains.

Return the `head` of the final linked list. The answer may differ from the original list, so any valid answer will be accepted.

---

## Examples

**Example 1:**
```
Input:  head = [1,2,-3,3,1]
Output: [3,1]
Explanation: [2,-3,3] sums to 0; removing it gives [1,3,1]. Then [1,-...] — the answer [3,1] is also valid.
```

**Example 2:**
```
Input:  head = [1,2,3,-3,4]
Output: [1,2,4]
Explanation: [3,-3] sums to 0; removing it gives [1,2,4].
```

**Example 3:**
```
Input:  head = [1,2,3,-3,-2]
Output: [1]
Explanation: [2,3,-3,-2] sums to 0; removing it gives [1].
```

---

## Constraints

- The number of nodes in the list is in the range `[1, 1000]`
- `-1000 <= Node.val <= 1000`
