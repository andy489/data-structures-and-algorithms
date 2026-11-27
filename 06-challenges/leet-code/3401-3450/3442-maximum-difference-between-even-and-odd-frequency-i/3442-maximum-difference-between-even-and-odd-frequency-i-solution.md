# Solution: Maximum Difference Between Even and Odd Frequency I

**Approach:** Count character frequencies, track max odd frequency and min even frequency, return their difference.

**Complexity:** O(n) time, O(1) space (at most 26 chars)

## Java
```java
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxOdd = Integer.MIN_VALUE, minEven = Integer.MAX_VALUE;
        for (int f : freq) {
            if (f == 0) {
                continue;
            }
            if (f % 2 == 1) {
                maxOdd = Math.max(maxOdd, f);
            } else {
                minEven = Math.min(minEven, f);
            }
        }
        return maxOdd - minEven;
    }
}
```

## Python
```python
class Solution:
    def maxDifference(self, s: str) -> int:
        freq = Counter(s)
        max_odd = max(f for f in freq.values() if f % 2 == 1)
        min_even = min(f for f in freq.values() if f % 2 == 0)
        return max_odd - min_even
```

## JavaScript
```javascript
var maxDifference = function(s) {
    const freq = {};
    for (const c of s) {
        freq[c] = (freq[c] || 0) + 1;
    }
    let maxOdd = -Infinity, minEven = Infinity;
    for (const f of Object.values(freq)) {
        if (f % 2 === 1) maxOdd = Math.max(maxOdd, f);
        else minEven = Math.min(minEven, f);
    }
    return maxOdd - minEven;
};
```
