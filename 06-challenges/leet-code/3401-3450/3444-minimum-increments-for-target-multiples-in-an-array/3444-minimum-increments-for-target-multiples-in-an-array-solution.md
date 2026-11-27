# Solution: Minimum Increments for Target Multiples in an Array

**Approach:** Since target.length <= 4, we can use bitmask DP over subsets of target. For each subset, compute the LCM of that subset's targets. For each nums[i], find the minimum cost to make it a multiple of any subset's LCM, then assign it to that subset. Use DP where dp[mask] = min ops to cover all targets in mask.

**Complexity:** O(n * 2^T) where T = target.length

## Java
```java
class Solution {
    public long minimumIncrements(int[] nums, int[] target) {
        int t = target.length;
        int masks = 1 << t;
        long[] lcms = new long[masks];
        lcms[0] = 1;
        for (int mask = 1; mask < masks; mask++) {
            int bit = Integer.numberOfTrailingZeros(mask);
            lcms[mask] = lcm(lcms[mask ^ (1 << bit)], target[bit]);
        }
        long[] dp = new long[masks];
        java.util.Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;
        for (int num : nums) {
            long[] ndp = dp.clone();
            for (int prev = 0; prev < masks; prev++) {
                if (dp[prev] == Long.MAX_VALUE / 2) {
                    continue;
                }
                for (int add = 1; add < masks; add++) {
                    if ((prev & add) != 0) {
                        continue;
                    }
                    long lcm = lcms[add];
                    long rem = num % lcm;
                    long cost = (rem == 0) ? 0 : lcm - rem;
                    int next = prev | add;
                    ndp[next] = Math.min(ndp[next], dp[prev] + cost);
                }
            }
            dp = ndp;
        }
        return dp[masks - 1];
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
```

## Python
```python
class Solution:
    def minimumIncrements(self, nums: List[int], target: List[int]) -> int:
        from math import gcd
        
        def lcm(a, b):
            return a // gcd(a, b) * b
        
        t = len(target)
        masks = 1 << t
        lcms = [1] * masks
        for mask in range(1, masks):
            bit = (mask & -mask).bit_length() - 1
            lcms[mask] = lcm(lcms[mask ^ (1 << bit)], target[bit])
        
        INF = float('inf')
        dp = [INF] * masks
        dp[0] = 0
        
        for num in nums:
            ndp = dp[:]
            for prev in range(masks):
                if dp[prev] == INF:
                    continue
                add = 1
                while add < masks:
                    if prev & add == 0:
                        lc = lcms[add]
                        rem = num % lc
                        cost = 0 if rem == 0 else lc - rem
                        nxt = prev | add
                        ndp[nxt] = min(ndp[nxt], dp[prev] + cost)
                    add += 1
            dp = ndp
        
        return dp[masks - 1]
```

## JavaScript
```javascript
var minimumIncrements = function(nums, target) {
    const t = target.length;
    const masks = 1 << t;
    
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    const lcm = (a, b) => BigInt(a) / BigInt(gcd(a, b)) * BigInt(b);
    
    const lcms = new Array(masks).fill(1n);
    for (let mask = 1; mask < masks; mask++) {
        const bit = (mask & -mask).toString(2).length - 1;
        lcms[mask] = lcm(lcms[mask ^ (1 << bit)], target[bit]);
    }
    
    const INF = BigInt(Number.MAX_SAFE_INTEGER);
    let dp = new Array(masks).fill(INF);
    dp[0] = 0n;
    
    for (const num of nums) {
        const ndp = [...dp];
        for (let prev = 0; prev < masks; prev++) {
            if (dp[prev] === INF) continue;
            for (let add = 1; add < masks; add++) {
                if (prev & add) continue;
                const lc = lcms[add];
                const rem = BigInt(num) % lc;
                const cost = rem === 0n ? 0n : lc - rem;
                const nxt = prev | add;
                const cand = dp[prev] + cost;
                if (cand < ndp[nxt]) ndp[nxt] = cand;
            }
        }
        dp = ndp;
    }
    
    return Number(dp[masks - 1]);
};
```
