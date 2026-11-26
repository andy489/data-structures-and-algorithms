# 138. Copy List with Random Pointer — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/copy-list-with-random-pointer/

---

## Solution 1: HashMap — O(n) time, O(n) space

**Idea:** Use a hash map from each original node to its cloned counterpart. First pass creates all clone nodes; second pass wires `next` and `random` using the map.

**Algorithm:**
1. First pass: iterate the list, create `cloned[node] = new Node(node.val)` for every node.
2. Second pass: for each original node, set `cloned[node].next = cloned[node.next]` and `cloned[node].random = cloned[node.random]`.
3. Return `cloned[head]`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — two linear passes |
| Space | O(n) — hash map storing n entries |

---

## Solution 2: Interleaving (O(1) extra space) — O(n) time, O(1) space

**Idea:** Weave cloned nodes directly into the original list (`A → A' → B → B' → ...`), set `random` pointers using the interleaved structure, then split the two lists apart.

**Algorithm:**
1. **Interleave:** for each original node `x`, insert a new clone node between `x` and `x.next`.
2. **Set randoms:** for each original node `x`, `x.next.random = x.random != null ? x.random.next : null`.
3. **Split:** restore original list and extract cloned list by relinking `next` pointers.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — three linear passes |
| Space | O(1) — no auxiliary data structure |
