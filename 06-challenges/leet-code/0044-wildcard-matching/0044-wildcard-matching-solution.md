# 44. Wildcard Matching — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/wildcard-matching/

---

## Solution: NFA simulation with OOP node hierarchy — O(m·n) time, O(n) space

**What is an NFA?**

Imagine you're reading the pattern left to right and placing a set of "tokens" on it. Each token sits on a node in the pattern. As you read each character of `s`, every token tries to advance according to the rule at its node. Some tokens may die (can't advance), some survive, some split into two.

At the end, if any token has reached the `AcceptNode`, the string matches.

Two kinds of moves:
- **Read move** — consume one character from `s` and advance to the next node. Used by `LiteralNode` and `WildcardNode`.
- **Free move (epsilon)** — jump to the next node *without* consuming any character. Used by `StarNode` to skip over itself when matching nothing.

**Node class hierarchy:**

```
abstract Node
    ├─ LiteralNode   — matches exactly one specific character ('a', 'b', …)
    ├─ WildcardNode  — matches exactly one arbitrary character ('?')
    ├─ StarNode      — matches zero or more arbitrary characters ('*')
    └─ AcceptNode    — terminal; being here means the whole pattern matched
```

Each node implements two methods:
- `fire(c, result)` — given a character, add the nodes reachable by a read move into `result`.
- `epsilonReach(result)` — add nodes reachable for free (no character consumed). Only `StarNode` overrides this.

**Building the NFA from pattern `"a*b"`:**

```
LiteralNode(0,'a') → StarNode(1) → LiteralNode(2,'b') → AcceptNode(3)
```

**Edges fired by each node type:**

| Node | `fire(c)` | `epsilonReach()` |
|---|---|---|
| `LiteralNode('a')` | if `c == 'a'`: add `next` | — |
| `WildcardNode` | always add `next` | — |
| `StarNode` | add `self` (loop) + add `next` | add `next` (skip for free) |
| `AcceptNode` | nothing | — |

**Trace on `s = "acdb"`, pattern `"a*b"`:**

| After reading | Active nodes | Why |
|---|---|---|
| (start) | {0} | initial; epsilon-close: no `*` at 0 |
| 'a' | {1, 2} | node 0 `LiteralNode('a')` fires → 1; epsilon node 1 `StarNode` → 2 |
| 'c' | {1, 2} | node 1 `StarNode` fires 'c' → {1, 2}; epsilon 1 → 2 |
| 'd' | {1, 2} | same |
| 'b' | {1, 2, 3} | node 1 loops → 1; node 2 `LiteralNode('b')` fires → 3 |

`AcceptNode(3)` is active → **match ✓**

**Algorithm:**
1. Build the node list: one `Node` subclass per pattern character, plus a terminal `AcceptNode`.
2. Wire each node's `next` pointer to the node after it.
3. Start `activeNodes = {node 0}`. Follow epsilon edges: for every `StarNode` in the set, also add its `next`.
4. For each character `s[i]`: call `fire(s[i], nextNodes)` on every active node. Follow epsilon edges on the result. Replace `activeNodes = nextNodes`.
5. Return whether `AcceptNode` is in `activeNodes`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — for each of m characters, process up to n active nodes |
| Space | O(n) — two node-id sets, each holding at most n+1 entries |

---

## Solution 2: 2D DP — O(m·n) time, O(m·n) space

**Idea:**

Think of it as filling a grid. `dp[i][j]` answers: "do the first `i` characters of `s` match the first `j` characters of `p`?"

We fill this grid left-to-right, top-to-bottom, using previously computed answers.

**Base cases:**
- `dp[0][0] = true` — empty string matches empty pattern.
- `dp[0][j] = dp[0][j-1]` when `p[j-1] == '*'` — a `*` at the start of the pattern can match nothing, so it's as if it isn't there.
- All other `dp[0][j] = false` — a non-empty pattern can't match an empty string.

**Filling the rest:** for each character pair `s[i-1]` and `p[j-1]`:
- If they match directly (same letter, or `p[j-1] == '?'`): the answer is whatever was true one step diagonally back — `dp[i-1][j-1]`.
- If `p[j-1] == '*'`: the star can either match nothing (`dp[i][j-1]` — pretend the star isn't there) or match one more character (`dp[i-1][j]` — consume a char from `s` and keep the star active).
- Otherwise: `false`.

**Example:** `s = "adceb"`, `p = "*a*b"`

```
    ""  *   a   *   b
""   T   T   F   F   F
a    F   T   T   T   F
d    F   T   F   T   F
c    F   T   F   T   F
e    F   T   F   T   F
b    F   T   F   T   T  ← dp[5][4] = true ✓
```

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — fill every cell of the m×n grid once |
| Space | O(m·n) — the grid itself |

---

## Solution 3: Greedy with backtracking — O(m·n) worst case, O(1) space

**Idea:**

Walk through `s` and `p` together with two pointers. Most of the time this is straightforward — if the characters match, advance both. The tricky part is `*`.

When we see a `*` in the pattern, we don't know yet how many characters it should consume. So we **bookmark** it: remember where the `*` was in the pattern (`starJ`) and where we are in the string (`matchI`). Then we optimistically assume the `*` matches nothing and move on.

If we later hit a mismatch and there's a bookmark, we go back to it and say "OK, the `*` actually consumed one more character" — increment `matchI` and try again from just after the `*` in the pattern.

**Trace:** `s = "adceb"`, `p = "*a*b"`

```
j=0 is '*': bookmark starJ=0, matchI=0, advance j→1
i=0 'a' vs p[1]='a': match, i→1, j→2
j=2 is '*': bookmark starJ=2, matchI=1, advance j→3
i=1 'd' vs p[3]='b': mismatch → backtrack: j=3, matchI=2, i=2
i=2 'c' vs p[3]='b': mismatch → backtrack: j=3, matchI=3, i=3
i=3 'e' vs p[3]='b': mismatch → backtrack: j=3, matchI=4, i=4
i=4 'b' vs p[3]='b': match, i→5, j→4
i=5 = m, loop ends. j=4=n → true ✓
```

**Algorithm:**
1. `i = j = 0`, `starJ = -1`, `matchI = 0`.
2. While `i < m`:
   - Characters match or `p[j] == '?'`: advance both `i` and `j`.
   - `p[j] == '*'`: save bookmark (`starJ = j`, `matchI = i`), advance `j` only.
   - Mismatch but bookmark exists: reset `j = starJ + 1`, `i = ++matchI` (star takes one more char).
   - Mismatch, no bookmark: return `false`.
3. Skip any remaining `*`s in `p` (they can all match empty). Return `j == n`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) worst case, O(m+n) average |
| Space | O(1) — just four integer variables |
