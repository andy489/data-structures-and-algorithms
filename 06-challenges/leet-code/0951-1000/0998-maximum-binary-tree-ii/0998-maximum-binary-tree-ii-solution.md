# 998. Maximum Binary Tree II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-binary-tree-ii/

---

## Solution: Right Spine Traversal — O(h) time, O(1) space

**Idea:** `val` is appended to the end, so it goes somewhere on the right spine. Find the first node on the right spine with value less than `val`; insert there.

**Complexity:**

| | |
|---|---|
| Time | O(h) — right spine only |
| Space | O(1) |
