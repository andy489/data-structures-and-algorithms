# 1054. Distant Barcodes

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/distant-barcodes/

---

## Problem Statement

In a warehouse, there is a row of barcodes, where the `i`th barcode is `barcodes[i]`.

Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.

Return an array of the rearranged barcodes.

---

## Examples

**Example 1:**
```
Input:  barcodes = [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
```

**Example 2:**
```
Input:  barcodes = [1,1,1,1,2,2,3,3]
Output: [1,2,1,2,1,3,1,3]
```

---

## Constraints

- `1 <= barcodes.length <= 10000`
- `1 <= barcodes[i] <= 10000`
