# Solution: Maximum Manhattan Distance After K Changes

**Approach:** For each prefix, consider 4 directions: NS axis and EW axis. For each pair of opposite directions (N/S and E/W), greedily change min(k, minority_count) of the minority direction to the majority direction. The Manhattan distance = |N-S| + |E-W|. We try all 4 possible axis combinations (maximize N or S, maximize E or W).

**Complexity:** O(n) time, O(1) space

## Java
```java
class Solution {
    public int maxDistance(String s, int k) {
        int res = 0;
        int[][] dirs = {{1, -1, 1, -1}, {1, -1, -1, 1}};  // NS axis signs, EW axis signs
        // Try 4 target directions: N+E, N+W, S+E, S+W
        int[][] targets = {{'N', 'E'}, {'N', 'W'}, {'S', 'E'}, {'S', 'W'}};
        for (int[] target : targets) {
            int axis1 = 0, axis2 = 0, changes = 0;
            for (char c : s.toCharArray()) {
                if (c == target[0]) {
                    axis1++;
                } else if (c == target[1]) {
                    axis2++;
                } else if (c == opposite(target[0]) || c == opposite(target[1])) {
                    if (changes < k) {
                        changes++;
                        if (c == opposite(target[0])) {
                            axis1++;
                        } else {
                            axis2++;
                        }
                    } else {
                        if (c == opposite(target[0])) {
                            axis1--;
                        } else {
                            axis2--;
                        }
                    }
                }
                res = Math.max(res, axis1 + axis2);
            }
        }
        return res;
    }
    
    private char opposite(char c) {
        if (c == 'N') return 'S';
        if (c == 'S') return 'N';
        if (c == 'E') return 'W';
        return 'E';
    }
}
```

## Python
```python
class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        def opposite(c):
            return {'N': 'S', 'S': 'N', 'E': 'W', 'W': 'E'}[c]
        
        res = 0
        for t1, t2 in [('N', 'E'), ('N', 'W'), ('S', 'E'), ('S', 'W')]:
            a1 = a2 = changes = 0
            for c in s:
                if c == t1:
                    a1 += 1
                elif c == t2:
                    a2 += 1
                elif changes < k:
                    changes += 1
                    if c == opposite(t1):
                        a1 += 1
                    else:
                        a2 += 1
                else:
                    if c == opposite(t1):
                        a1 -= 1
                    else:
                        a2 -= 1
                res = max(res, a1 + a2)
        return res
```

## JavaScript
```javascript
var maxDistance = function(s, k) {
    const opp = {N: 'S', S: 'N', E: 'W', W: 'E'};
    let res = 0;
    for (const [t1, t2] of [['N','E'],['N','W'],['S','E'],['S','W']]) {
        let a1 = 0, a2 = 0, changes = 0;
        for (const c of s) {
            if (c === t1) a1++;
            else if (c === t2) a2++;
            else if (changes < k) {
                changes++;
                if (c === opp[t1]) a1++;
                else a2++;
            } else {
                if (c === opp[t1]) a1--;
                else a2--;
            }
            res = Math.max(res, a1 + a2);
        }
    }
    return res;
};
```
