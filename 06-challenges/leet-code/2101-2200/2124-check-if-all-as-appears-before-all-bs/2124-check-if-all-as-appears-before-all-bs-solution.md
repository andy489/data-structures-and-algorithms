# 2124. Check if All A's Appears Before All B's — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

---

## Solution: Substring Check — O(n) time, O(1) space

**Idea:** If `"ba"` never appears as a substring, then no `'b'` can be immediately followed by an `'a'`, which means no `'a'` can appear after any `'b'`. Equivalently, all `'a'`s precede all `'b'`s.

**Algorithm:**
1. Return `true` if and only if `s` does not contain the substring `"ba"`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass to find the substring |
| Space | O(1) — no extra storage |

---

## Solution 2: Linear Scan — O(n) time, O(1) space

**Idea:** Scan left to right tracking whether a `'b'` has been seen. The moment we see an `'a'` after any `'b'`, the condition is violated.

**Algorithm:**
1. Iterate over each character `c` in `s`.
2. Maintain a flag `seenB` that becomes `true` once a `'b'` is encountered.
3. If `seenB` is `true` and `c == 'a'`, return `false`.
4. After the loop, return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — one boolean flag |
