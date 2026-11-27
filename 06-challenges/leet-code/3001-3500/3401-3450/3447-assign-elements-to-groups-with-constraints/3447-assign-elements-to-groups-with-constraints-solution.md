# Solution: Assign Elements to Groups with Constraints

**Approach:** For each element value v at index j (taking the first occurrence for each value), enumerate all multiples of v up to max(groups). For each group size that equals a multiple, record the smallest j. Use a lookup array indexed by group size.

**Complexity:** O(E * max_G / E) = O(max_G) for each element, overall O(max_G * log(max_G)) for sieve-like traversal

## Java
```java
class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int maxG = 0;
        for (int g : groups) {
            maxG = Math.max(maxG, g);
        }
        int[] lookup = new int[maxG + 1];
        java.util.Arrays.fill(lookup, -1);
        
        for (int j = elements.length - 1; j >= 0; j--) {
            int e = elements[j];
            if (e > maxG) {
                continue;
            }
            for (int multiple = e; multiple <= maxG; multiple += e) {
                lookup[multiple] = j;
            }
        }
        
        int[] assigned = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            assigned[i] = lookup[groups[i]];
        }
        return assigned;
    }
}
```

## Python
```python
class Solution:
    def assignElements(self, groups: List[int], elements: List[int]) -> List[int]:
        max_g = max(groups)
        lookup = [-1] * (max_g + 1)
        
        for j in range(len(elements) - 1, -1, -1):
            e = elements[j]
            if e > max_g:
                continue
            for multiple in range(e, max_g + 1, e):
                lookup[multiple] = j
        
        return [lookup[g] for g in groups]
```

## JavaScript
```javascript
var assignElements = function(groups, elements) {
    const maxG = Math.max(...groups);
    const lookup = new Array(maxG + 1).fill(-1);
    
    for (let j = elements.length - 1; j >= 0; j--) {
        const e = elements[j];
        if (e > maxG) continue;
        for (let multiple = e; multiple <= maxG; multiple += e) {
            lookup[multiple] = j;
        }
    }
    
    return groups.map(g => lookup[g]);
};
```
