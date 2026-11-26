# 1290. Convert Binary Number in a Linked List to Integer — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

---

## Solution: Bit Shifting — O(n) time, O(1) space

**Idea:** Traverse the list, shifting result left by 1 and ORing with the current node's value.

**Algorithm:**
1. Start with result = 0.
2. For each node: result = result * 2 + node.val (or result = (result << 1) | node.val).
3. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
