# 1958. Check if Move is Legal — Solution

## Approach

For each of the 8 directions (horizontal, vertical, diagonal), check if placing color at (rMove, cMove) creates a "good line":
1. Move in the direction, counting cells of the opposite color.
2. If we encounter 1+ opposite colored cells followed by a cell of the same color, the move is legal.

**Complexity:** O(1) time (8 x 8 board), O(1) space.
