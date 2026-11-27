# Solution: Find All Groups of Farmland

## Approach: Greedy Rectangle Detection

Scan the grid left-to-right, top-to-bottom. When we find a `1` cell that hasn't been visited (top-left corner of a rectangle), expand right and down to find the bottom-right corner. Mark all cells in the rectangle as visited by setting them to `0`.

**Time:** O(m * n)  
**Space:** O(1) extra (output not counted)
