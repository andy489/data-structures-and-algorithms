# 1970. Last Day Where You Can Still Cross — Solution

## Approach

Binary search on the day. For a given day d, all cells[0..d-1] are flooded. Check if we can cross using BFS/DFS.

Alternatively, use Union-Find (Disjoint Set Union) in reverse: start from the last day and add land cells back one by one. Connect adjacent land cells. Maintain virtual nodes for top row and bottom row. When top and bottom nodes become connected, that's the answer.

**Complexity:** O(row * col * alpha(row * col)) with Union-Find (nearly linear), or O(row * col * log(row * col)) with binary search + BFS.
