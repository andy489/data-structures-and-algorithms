# Solution: 2581. Count Number of Possible Root Nodes

## Approach: Rerooting DP (Tree DP)

**Key Insight:** Use rerooting technique — compute the number of correct guesses when rooted at node 0, then recompute for all other roots efficiently.

**Step 1: Root at node 0**
- Build a directed tree rooted at 0.
- Store guesses in a HashSet as `{u, v}` pairs.
- DFS from root 0: count how many guesses `[parent, child]` are correct (i.e., the edge direction matches the guess).
- Let `correct[0]` = this count.

**Step 2: Rerooting**
- When we "reroot" from node `u` to its child `v`:
  - The edge `u → v` becomes `v → u`.
  - If `[u, v]` was a correct guess, it's now wrong: `correct -= 1`.
  - If `[v, u]` was a correct guess (the reverse direction), it's now correct: `correct += 1`.
- Do DFS again, maintaining the current correct count as we move from parent to child.

**Step 3: Count valid roots**
- Count nodes where `correct >= k`.

## Complexity

- **Time:** O(n + g) where g = number of guesses
- **Space:** O(n + g)
