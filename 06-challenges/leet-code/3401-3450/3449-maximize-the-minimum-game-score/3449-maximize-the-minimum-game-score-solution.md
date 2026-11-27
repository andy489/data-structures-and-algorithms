# Solution: Maximize the Minimum Game Score

**Approach:** Binary search on the answer (minimum score). For a given minimum score `mid`, greedily check if it's achievable with at most m moves. For each index i, we need ceil(mid / points[i]) visits. We can visit adjacent indices by going back and forth. The key: to visit index i enough times, the optimal strategy involves going to i from i-1 and back, costing 2 visits to i-1 per round trip. Use a greedy scan from left to right, tracking remaining moves.

**Complexity:** O(n log(m * max_points)) for binary search + O(n) for each check

## Java
```java
class Solution {
    public long maxScore(int[] points, int m) {
        int n = points.length;
        long lo = 0, hi = (long) (m + 1) * 1000000L;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (canAchieve(points, m, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    
    private boolean canAchieve(int[] points, long m, long minScore) {
        int n = points.length;
        long moves = m;
        for (int i = 0; i < n; i++) {
            long needed = (minScore + points[i] - 1) / points[i]; // ceil(minScore / points[i])
            // To visit index i 'needed' times from position i-1:
            // First arrival costs 1 move (from left side or start)
            // Each additional visit: go right to i and come back = costs 2 more moves
            // Total moves consumed at i: needed visits, but we need to account for
            // the fact that visiting i 'needed' times also uses moves at i+1 side
            // Greedy: moves -= needed * 2 - 1 (visit i 'needed' times: 1 move to arrive + (needed-1)*2 round trips)
            // But first visit from start costs 1 (move right to i=0 from -1)
            // After visiting i, we're at position i, ready to advance.
            moves -= needed * 2 - 1;
            if (moves < 0) {
                return false;
            }
            // After position i, we move to i+1 (1 more move), but that's counted in next iteration
            // However: if we did extra round trips, we're still at i after
            // moves remaining for i+1, i+2, ...
            if (i < n - 1) {
                // The extra moves spent going back from i means we effectively
                // need 1 more move to get to i+1
                // But this is already accounted in the formula
            }
        }
        return true;
    }
}
```

## Python
```python
class Solution:
    def maxScore(self, points: List[int], m: int) -> int:
        n = len(points)
        
        def canAchieve(min_score):
            moves = m
            for i in range(n):
                needed = (min_score + points[i] - 1) // points[i]
                # Visit index i 'needed' times: costs 2*needed - 1 moves
                # (arrive once + (needed-1) back-and-forth round trips)
                moves -= 2 * needed - 1
                if moves < 0:
                    return False
            return True
        
        lo, hi = 0, (m + 1) * max(points)
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if canAchieve(mid):
                lo = mid
            else:
                hi = mid - 1
        
        return lo
```

## JavaScript
```javascript
var maxScore = function(points, m) {
    const n = points.length;
    
    const canAchieve = (minScore) => {
        let moves = m;
        for (let i = 0; i < n; i++) {
            const needed = Math.ceil(minScore / points[i]);
            moves -= 2 * needed - 1;
            if (moves < 0) return false;
        }
        return true;
    };
    
    let lo = 0n, hi = BigInt(m + 1) * BigInt(Math.max(...points));
    while (lo < hi) {
        const mid = (lo + hi + 1n) / 2n;
        if (canAchieve(mid)) {
            lo = mid;
        } else {
            hi = mid - 1n;
        }
    }
    
    return Number(lo);
};
```
