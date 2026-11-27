# 895. Maximum Frequency Stack

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-frequency-stack/

---

## Problem Statement

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the `FreqStack` class:
- `FreqStack()` constructs an empty frequency stack.
- `void push(int val)` pushes an integer `val` onto the top of the stack.
- `int pop()` removes and returns the most frequent element in the stack. If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

---

## Examples

**Example 1:**
```
Input:  ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"]
        [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
```

---

## Constraints

- `0 <= val <= 10^9`
- At most `2 * 10^4` calls will be made to `push` and `pop`.
- It is guaranteed that there will be at least one element in the stack before calling `pop`.
