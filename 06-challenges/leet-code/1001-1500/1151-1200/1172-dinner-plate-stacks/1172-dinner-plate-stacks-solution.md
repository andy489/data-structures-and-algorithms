# 1172. Dinner Plate Stacks — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/dinner-plate-stacks/

---

## Solution: Min-Heap for Available + Right Pointer — O(log n) per operation amortized

**Idea:**
- Track the leftmost available stack index using a **min-heap** of indices that have free space.
- Track the rightmost non-empty stack with a pointer that is decremented lazily.
- Keep a list of stacks (dynamic array).

**Algorithm:**
1. `push(val)`: pop from the min-heap to get the leftmost available index; push val there; re-add to heap if still not full; grow stacks list if needed.
2. `pop()`: decrement `right` while `stacks[right]` is empty; pop from `stacks[right]`; if that stack now has space, add index to min-heap.
3. `popAtStack(index)`: if index is out of range or stack empty return -1; otherwise pop from `stacks[index]`; add index to heap if capacity freed; update `right` lazily.

**Complexity:**

| | |
|---|---|
| Time | O(log n) per push/pop amortized — heap operations |
| Space | O(n) — total elements across all stacks |
