# 1687. Delivering Boxes from Storage to Ports

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/

---

## Problem Statement

You have the task of delivering some boxes from storage to their ports using only one ship. However, this ship has a **weight limit** and a **maximum number of boxes** limit.

The boxes are stored in a warehouse and you are given an array `boxes` where `boxes[i] = [ports_i, weight_i]`.

You will iteratively go through the list of boxes in order and attempt to put them on the ship. The ship's journey proceeds as follows:

- Load `boxes[i]` on the ship if `boxes.length <= maxBoxes` and `boxes.weight <= maxWeight`.
- Otherwise the ship travels to its port and unloads all its boxes and comes back to the warehouse (counted as 2 trips), and then attempts to load boxes again.
- The ship makes 2 more trips when unloading.

Formally, the **minimum number of trips** to deliver all boxes is calculated.

Return the **minimum** number of trips the ship needs to make to deliver all boxes to their respective ports.

---

## Examples

**Example 1:**
```
Input: boxes = [[1,1],[2,1],[1,1]], maxBoxes = 3, maxWeight = 3
Output: 4
```

**Example 2:**
```
Input: boxes = [[1,2],[3,3],[3,1],[3,1],[2,4]], maxBoxes = 3, maxWeight = 6
Output: 6
```

**Example 3:**
```
Input: boxes = [[1,4],[1,2],[2,1],[2,1],[3,2],[3,4]], maxBoxes = 6, maxWeight = 7
Output: 6
```

---

## Constraints

- `1 <= boxes.length <= 10^5`
- `1 <= portsCount, maxBoxes, maxWeight <= 10^4`
- `1 <= ports_i <= portsCount`
- `1 <= weight_i <= maxWeight`
