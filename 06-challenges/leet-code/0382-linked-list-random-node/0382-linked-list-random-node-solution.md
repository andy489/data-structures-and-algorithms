# 382. Linked List Random Node — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/linked-list-random-node/

---

## Solution: Reservoir Sampling — O(n) time, O(1) space

**Idea:** Walk the list, maintaining a reservoir of size 1. For the `k`-th node (1-indexed), replace the current result with that node's value with probability `1/k`. This guarantees each node ends up chosen with equal probability `1/n` regardless of the list length — making it ideal when `n` is unknown at construction time.

**Algorithm:**
1. Start with `result = head.val`, `k = 1`.
2. Advance to the next node, increment `k`.
3. With probability `1/k` (i.e. `rand() % k == 0`), set `result = current.val`.
4. Repeat until the end of the list.
5. Return `result`.

---

## Why It Works — Proof by Induction

**Claim:** after processing `k` nodes, each of the first `k` nodes is the current reservoir element with probability exactly `1/k`.

**Base case (k = 1):** The first node is always chosen. P = 1/1 = 1. ✓

**Inductive step:** Assume after `k` nodes each is held with probability `1/k`. When node `k+1` arrives:

- Node `k+1` is chosen with probability `1/(k+1)`. ✓
- Each of the previous `k` nodes **survives** (is not replaced) with probability `k/(k+1)`.
  So any previous node's probability becomes: `(1/k) × (k/(k+1)) = 1/(k+1)`. ✓

All `k+1` nodes are equally likely. By induction, after all `n` nodes, each is chosen with probability `1/n`. ✓

---

## Worked Example — List `[A, B, C]` (n = 3)

| Step | Node | k | Accept prob | Action | result |
|------|------|---|-------------|--------|--------|
| 1 | A | 1 | 1/1 = 1 | Always pick A | A |
| 2 | B | 2 | 1/2 | Pick B with prob 1/2 | A or B |
| 3 | C | 3 | 1/3 | Pick C with prob 1/3 | A, B, or C |

**Probability each node ends up as result:**

- **P(result = A)** = P(A kept at step 2) × P(A kept at step 3)
  = (1/2) × (2/3) = **1/3** ✓
- **P(result = B)** = P(B chosen at step 2) × P(B kept at step 3)
  = (1/2) × (2/3) = **1/3** ✓
- **P(result = C)** = P(C chosen at step 3)
  = **1/3** ✓

---

## Worked Example — List `[A, B, C, D]` (n = 4)

- **P(result = A)** = (1/2) × (2/3) × (3/4) = 6/24 = **1/4** ✓
- **P(result = B)** = (1/2) × (2/3) × (3/4) = 6/24 = **1/4** ✓
- **P(result = C)** = (1/3) × (3/4) = 3/12 = **1/4** ✓
- **P(result = D)** = 1/4 = **1/4** ✓

The telescoping product `(k/(k+1)) × ((k+1)/(k+2)) × … × ((n-1)/n) = k/n` always reduces neatly, so node `k` (chosen with prob `1/k`) ends up selected with final probability `(1/k) × (k/n) = 1/n`.

---

**Complexity:**

| | |
|---|---|
| Time  | O(n) per `getRandom()` call — full traversal each time |
| Space | O(1) — only a pointer and two integers |
