# Solution: Sort Matrix by Diagonals

**Approach:** Each diagonal is identified by (row - col). For the bottom-left triangle (row - col >= 0), sort in non-increasing order. For the top-right triangle (row - col < 0), sort in non-decreasing order.

**Complexity:** O(n^2 log n) time, O(n^2) space

## Java
```java
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        // Group elements by diagonal key (row - col)
        Map<Integer, List<Integer>> diags = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diags.computeIfAbsent(key, x -> new ArrayList<>()).add(grid[i][j]);
            }
        }
        // Sort each diagonal
        for (Map.Entry<Integer, List<Integer>> entry : diags.entrySet()) {
            List<Integer> vals = entry.getValue();
            if (entry.getKey() >= 0) {
                // Bottom-left triangle including main diagonal: non-increasing
                vals.sort(Collections.reverseOrder());
            } else {
                // Top-right triangle: non-decreasing
                Collections.sort(vals);
            }
        }
        // Track position in each diagonal
        Map<Integer, Integer> idx = new HashMap<>();
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int pos = idx.getOrDefault(key, 0);
                res[i][j] = diags.get(key).get(pos);
                idx.put(key, pos + 1);
            }
        }
        return res;
    }
}
```

## Python
```python
class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        from collections import defaultdict
        diags = defaultdict(list)
        
        for i in range(n):
            for j in range(n):
                diags[i - j].append(grid[i][j])
        
        for key in diags:
            if key >= 0:
                diags[key].sort(reverse=True)
            else:
                diags[key].sort()
        
        idx = defaultdict(int)
        res = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                key = i - j
                res[i][j] = diags[key][idx[key]]
                idx[key] += 1
        
        return res
```

## JavaScript
```javascript
var sortMatrix = function(grid) {
    const n = grid.length;
    const diags = new Map();
    
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            const key = i - j;
            if (!diags.has(key)) diags.set(key, []);
            diags.get(key).push(grid[i][j]);
        }
    }
    
    for (const [key, vals] of diags) {
        if (key >= 0) {
            vals.sort((a, b) => b - a);
        } else {
            vals.sort((a, b) => a - b);
        }
    }
    
    const idx = new Map();
    const res = Array.from({length: n}, () => new Array(n).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            const key = i - j;
            const pos = idx.get(key) || 0;
            res[i][j] = diags.get(key)[pos];
            idx.set(key, pos + 1);
        }
    }
    
    return res;
};
```
