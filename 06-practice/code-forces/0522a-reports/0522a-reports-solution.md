# 522A. Reposts — Solution

---

## Key Insight

The repost relationships form a **rooted tree** (or forest, but Polycarp is the root of the relevant component). Each edge `name1 reposted name2` means `name1` is a child of `name2` in the tree. The answer is the **maximum depth** of any node, where Polycarp has depth 1.

---

## Algorithm

### DFS / BFS from Polycarp

1. Normalize all usernames to lowercase (case-insensitive matching).
2. Build an adjacency list: for each record `name1 reposted name2`, add `name1` as a child of `name2`.
3. BFS or DFS from `"polycarp"`, tracking depth at each node.
4. Return the maximum depth reached.

### DP Approach

Define `depth[user]` = length of the longest chain ending at `user`.
- `depth["polycarp"] = 1`
- `depth[name1] = depth[name2] + 1` for each record `name1 reposted name2`

Process records in dependency order (BFS layer by layer, or process until no updates occur).

**Edge case:** Since `pᵢ < i` in general tree problems this wouldn't apply, but here the repost order isn't guaranteed. Use BFS queue initialized with Polycarp.

---

## Complexity

| | |
|---|---|
| Time | O(n) — each repost processed once |
| Space | O(n) — depth map + adjacency list |
