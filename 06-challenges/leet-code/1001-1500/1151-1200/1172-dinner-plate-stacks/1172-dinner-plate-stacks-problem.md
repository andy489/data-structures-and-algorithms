# 1172. Dinner Plate Stacks

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/dinner-plate-stacks/

---

## Problem Statement

You have an infinite number of stacks arranged in a row, indexed from `0`. Each stack has a maximum capacity `capacity`.

Implement the `DinnerPlates` class:
- `DinnerPlates(int capacity)` — initializes the object with the given stack `capacity`.
- `void push(int val)` — pushes the given value onto the **leftmost non-full** stack.
- `int pop()` — returns the value at the top of the **rightmost non-empty** stack and removes it, or returns `-1` if all stacks are empty.
- `int popAtStack(int index)` — returns the value at the top of the stack with the given index and removes it, or returns `-1` if that stack is empty.

---

## Examples

**Example 1:**
```
Input:
  ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
  [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
Output: [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
Explanation:
  After 5 pushes (capacity=2): stacks = [[1,2],[3,4],[5]]
  popAtStack(0) → 2; stacks = [[1],[3,4],[5]]
  push(20) → fills leftmost gap: stacks = [[1,20],[3,4],[5]]
  push(21) → stacks = [[1,20],[3,4],[5,21]]  (wait: cap=2 means [5,21] fills [2])
  popAtStack(0) → 20; popAtStack(2) → 21; pop → 5; pop → 4; pop → 3; pop → 1; pop → -1
```

---

## Constraints

- `1 <= capacity <= 2 * 10^4`
- `1 <= val <= 2 * 10^4`
- `0 <= index <= 10^5`
- At most `2 * 10^5` calls will be made to `push`, `pop`, and `popAtStack`
