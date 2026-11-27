# Solution: Operations on Tree

## Approach: Tree with Children Map

Build the tree storing children for each node. Use an array `lockedBy` (0 = unlocked) to track who locked each node.

- **lock(num, user):** Return true iff `lockedBy[num] == 0`, then set it.
- **unlock(num, user):** Return true iff `lockedBy[num] == user`, then clear it.
- **upgrade(num, user):** Check node is unlocked, check no ancestor is locked (walk up via parent), check at least one descendant is locked (DFS/BFS), then lock `num` and unlock all descendants.

**Time:** O(n) per upgrade call  
**Space:** O(n)
