# 341. Flatten Nested List Iterator — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flatten-nested-list-iterator/

---

## Solution: Eager Flattening — O(n) build, O(1) next, O(n) space

**Idea:** Flatten the entire nested list into a flat list at construction time. `next()` and `hasNext()` are then O(1) pointer operations.

**Algorithm:**
1. DFS/recursion to flatten: if element is integer, add to list; if list, recurse.
2. Use an index pointer for `next()` and `hasNext()`.

**Complexity:**

| | |
|---|---|
| Time | O(n) build, O(1) per next/hasNext |
| Space | O(n) — flattened list |

---

## Solution 2: Lazy Stack — O(1) build, O(1) amortized next, O(d) space

**Idea:** Use a stack of iterators. `hasNext()` ensures the stack top is a ready integer by expanding lists. This processes elements lazily.

**Algorithm:**
1. Push an iterator over `nestedList` onto the stack.
2. `hasNext()`: while stack not empty, peek at current iterator; if it has a next integer, return true; if next is a list, push its iterator; if exhausted, pop.
3. `next()`: call `hasNext()` then pop the integer.

**Complexity:**

| | |
|---|---|
| Time | O(1) amortized per operation |
| Space | O(d) — d is nesting depth |
