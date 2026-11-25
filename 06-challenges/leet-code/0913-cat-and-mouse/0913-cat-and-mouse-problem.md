# 913. Cat and Mouse

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cat-and-mouse/

---

## Problem Statement

A game on an **undirected** graph is played by two players, Mouse and Cat, who alternate turns.

The graph is given as follows: `graph[a]` is a list of all nodes `b` such that `ab` is an edge of the graph.

The mouse starts at node `1` and goes first, the cat starts at node `2`, and there is a hole at node `0`.

During each player's turn, they **must** travel along one edge of the graph that meets where they are. The cat cannot travel to the hole (node `0`).

Then, the game can end in three ways:
- If ever the cat occupies the same node as the mouse, the cat wins.
- If ever the mouse reaches the hole (node `0`), the mouse wins.
- If ever a position is repeated (i.e., the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.

Return `1` if the mouse wins, `2` if the cat wins, or `0` if the game is a draw.

---

## Examples

**Example 1:**
```
Input:  graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
Output: 0
```

---

## Constraints

- `3 <= graph.length <= 50`
- `1 <= graph[i].length < graph.length`
- `0 <= graph[i][j] < graph.length`
- `graph[i][j] != i`
- `graph` is undirected.
- The mouse and the cat can always move.
