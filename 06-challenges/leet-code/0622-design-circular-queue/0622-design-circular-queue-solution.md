# 622. Design Circular Queue — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-circular-queue/

---

## Solution: Array with Head/Tail Pointers — O(1) operations, O(k) space

**Idea:** Use a fixed-size array with `head`, `tail`, and `size` trackers. `head` points to the front element; `tail` to the next write position (mod k).

**Algorithm:**
1. Initialize array of size k, head=0, tail=0, size=0.
2. `enQueue`: write at tail, advance tail mod k, increment size.
3. `deQueue`: advance head mod k, decrement size.
4. `Front`: return `data[head]`.
5. `Rear`: return `data[(tail - 1 + k) % k]`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — all operations |
| Space | O(k) — fixed array |
