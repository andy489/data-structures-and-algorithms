# 382. Linked List Random Node — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/linked-list-random-node/

---

## Solution: Reservoir Sampling — O(n) time, O(1) space

**Idea:** Walk the list, maintaining a reservoir of size 1. For the `k`-th node (1-indexed), replace the current result with that node's value with probability `1/k`. By induction this guarantees each node ends up chosen with equal probability `1/n` regardless of the list length — making it ideal when `n` is unknown at construction time.

**Algorithm:**
1. Start with `result = head.val`, `k = 1`.
2. Advance to the next node, increment `k`.
3. With probability `1/k` (i.e. `rand() % k == 0`), set `result = current.val`.
4. Repeat until the end of the list.
5. Return `result`.

**Why it works:** After seeing `k` nodes the probability of any specific node being the reservoir element is `1/k`. When node `k+1` arrives: it is chosen with probability `1/(k+1)`, and each prior node survives with probability `k/(k+1)`, giving each prior node `(1/k) * (k/(k+1)) = 1/(k+1)`. All `k+1` nodes are equally likely.

**Complexity:**

| | |
|---|---|
| Time  | O(n) per `getRandom()` call — full traversal each time |
| Space | O(1) — only a pointer and two integers |
