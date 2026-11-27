# 789. Escape the Ghosts

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/escape-the-ghosts/

---

## Problem Statement

You are playing a simplified PAC-MAN game on an infinite 2-D grid. You start at the point `[0, 0]`, and you are chasing a target at the point `target = [xt, yt]`.

There are several ghosts on the map, the `i`-th ghost starts at `ghosts[i] = [xi, yi]`.

Each turn, you and all the ghosts may independently choose to either **move one step** in one of the four cardinal directions, or **stay** in place. You escape if and only if you can reach the target **before** any ghost reaches you (the ghosts may catch you at the target).

Return `true` if it is possible to escape.

---

## Examples

**Example 1:**
```
Input:  ghosts = [[1,0],[0,3]], target = [0,1]
Output: true
```

**Example 2:**
```
Input:  ghosts = [[1,0]], target = [2,0]
Output: false
```

---

## Constraints

- `1 <= ghosts.length <= 100`
- `ghosts[i].length == 2`
- `-10^4 <= xi, yi <= 10^4`
- `target.length == 2`
- `-10^4 <= xt, yt <= 10^4`
