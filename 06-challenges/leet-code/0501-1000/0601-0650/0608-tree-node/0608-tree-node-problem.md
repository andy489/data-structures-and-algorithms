# 608. Tree Node

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/tree-node/

---

## Problem Statement

Table `Tree`:

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| p_id        | int  |
+-------------+------+
```

Each row includes `id` and its parent node `p_id`. Given the `Tree` table, classify each tree node as:

- `Root`: if the node is the root node
- `Leaf`: if the node is a leaf node
- `Inner`: if the node is neither root nor leaf

---

## Examples

**Example 1:**
```
Input:
Tree table:
+----+------+
| id | p_id |
+----+------+
| 1  | null |
| 2  | 1    |
| 3  | 1    |
| 4  | 2    |
| 5  | 2    |
+----+------+

Output:
+----+-------+
| id | type  |
+----+-------+
| 1  | Root  |
| 2  | Inner |
| 3  | Leaf  |
| 4  | Leaf  |
| 5  | Leaf  |
+----+-------+
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`
- Each node has a unique `id`
