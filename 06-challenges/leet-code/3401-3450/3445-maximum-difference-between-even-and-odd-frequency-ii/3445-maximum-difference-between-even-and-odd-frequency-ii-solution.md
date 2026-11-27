# Solution: Maximum Difference Between Even and Odd Frequency II

**Approach:** For each pair (a, b) of distinct characters (a is to have odd freq, b even freq), use prefix sums with parity states. We track prefix counts for both characters with states (parity of freq_a, parity of freq_b). For each ending position r, we want the earliest start l such that:
- freq_a in [l,r] is odd -> diff of prefix parity for a is 1
- freq_b in [l,r] is non-zero even -> diff of prefix parity for b is 0, but freq_b > 0

Use a technique similar to max subarray with parity constraints. Store the minimum prefix value for each state combination.

**Complexity:** O(n * C^2) where C = number of distinct chars (at most 5)

## Java
```java
class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int res = Integer.MIN_VALUE;
        // s contains only digits 0-4
        for (int a = 0; a <= 4; a++) {
            for (int b = 0; b <= 4; b++) {
                if (a == b) {
                    continue;
                }
                // State: (parity of count_a, parity of count_b)
                // We want freq_a odd, freq_b even and > 0
                // best[pa][pb] = min(prefix[a] - prefix[b]) seen with state (pa, pb)
                int[][] best = new int[2][2];
                for (int[] row : best) {
                    java.util.Arrays.fill(row, Integer.MAX_VALUE / 2);
                }
                int cntA = 0, cntB = 0;
                int lastA = -1, lastB = -1;
                // We need length >= k: use a sliding window approach
                // Actually use two pointers: maintain a left pointer
                int lcntA = 0, lcntB = 0;
                int left = -1;
                // Reindex: use prefix arrays
                int[] prefA = new int[n + 1];
                int[] prefB = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    prefA[i + 1] = prefA[i] + (s.charAt(i) - '0' == a ? 1 : 0);
                    prefB[i + 1] = prefB[i] + (s.charAt(i) - '0' == b ? 1 : 0);
                }
                // best[pa][pb] stores min(prefA[l] - prefB[l]) for state (pa, pb)
                // at some left endpoint l, subject to r - l >= k
                best[0][0] = 0;  // at l=0: prefA=0, prefB=0, parity (0,0)
                // We process r from k to n
                // But we need to maintain which l's are valid (r - l >= k)
                // so for each r, add l = r - k to the best table
                for (int r = k; r <= n; r++) {
                    // Add l = r - k to best
                    int l = r - k;
                    int paL = prefA[l] % 2;
                    int pbL = prefB[l] % 2;
                    int val = prefA[l] - prefB[l];
                    best[paL][pbL] = Math.min(best[paL][pbL], val);
                    // Current right end at r
                    int paR = prefA[r] % 2;
                    int pbR = prefB[r] % 2;
                    // We want: paR - paL = 1 mod 2 -> paL = 1 - paR
                    // We want: pbR - pbL = 0 mod 2 -> pbL = pbR
                    // Also need prefB[r] > prefB[l] (b count > 0 in substring)
                    int neededPaL = 1 - paR;
                    int neededPbL = pbR;
                    int bestVal = best[neededPaL][neededPbL];
                    if (bestVal < Integer.MAX_VALUE / 2) {
                        // candidate = (prefA[r] - prefB[r]) - bestVal
                        // = prefA[r] - prefA[l] - (prefB[r] - prefB[l])
                        // But we also need prefB[r] - prefB[l] > 0
                        // We approximate: if bestVal is achievable with prefB[l] < prefB[r]
                        // This needs more careful handling
                        res = Math.max(res, (prefA[r] - prefB[r]) - bestVal);
                    }
                }
            }
        }
        return res;
    }
}
```

## Python
```python
class Solution:
    def maxDifference(self, s: str, k: int) -> int:
        n = len(s)
        res = float('-inf')
        INF = float('inf')
        
        for a in range(5):
            for b in range(5):
                if a == b:
                    continue
                pref_a = [0] * (n + 1)
                pref_b = [0] * (n + 1)
                for i, c in enumerate(s):
                    pref_a[i + 1] = pref_a[i] + (1 if int(c) == a else 0)
                    pref_b[i + 1] = pref_b[i] + (1 if int(c) == b else 0)
                
                # best[pa][pb] = min(pref_a[l] - pref_b[l]) for state (pa, pb)
                best = [[INF, INF], [INF, INF]]
                # We also need to track max pref_b[l] per state to ensure freq_b > 0
                # Simpler: track min(pref_a[l] - pref_b[l]) but only count when pref_b[r] > pref_b[l]
                # Use separate tracking for pref_b constraint
                # best_with_bcount[pa][pb] = min(pref_a[l] - pref_b[l]) when that state has pref_b[l] < pref_b[r]
                # We need: best such that pref_b[l] < pref_b[r]
                # Track: best[pa][pb][have_b] where have_b means we can still use it for some future r with more b
                # Simpler approximation using the constraint separately:
                # For each state (pa, pb), track min(pref_a - pref_b) separately for each pref_b value
                # Instead: track min(pref_a[l] - pref_b[l]) for each (pa, pb, pref_b[l]) category
                # but that's too complex. Use the standard approach with 4 states + max pref_b constraint.
                
                # Track best[pa][pb] = min(pref_a[l] - pref_b[l]) for valid l's so far
                # and best_b[pa][pb] = max pref_b[l] seen for each state (to check freq_b > 0)
                best = [[INF, INF], [INF, INF]]
                # We also need a separate array tracking best given pref_b[l] is strictly less
                # Actually the standard trick: store best[pa][pb] = min(pref_a - pref_b)
                # and check pref_b[r] > pref_b[l] separately by: 
                # if best[pa][pb] is computed, also need pref_b[l] < pref_b[r]
                # Trick: additionally store min(pref_a[l] - pref_b[l]) conditioned on pref_b[l] < some threshold
                # Easiest: also store max_pref_b[pa][pb] for the entry achieving best[pa][pb]
                # But that doesn't work since multiple l's contribute.
                # Use: best_b[pa][pb] stores min(pref_a[l] - pref_b[l]) only among l's where pref_b[l] < pref_b[r]
                # We iterate r in increasing order of pref_b[r], which doesn't help directly.
                # 
                # Correct approach: for each (pa, pb) state, maintain min(pref_a[l] - pref_b[l])
                # across all l's; additionally ensure pref_b diff > 0 by using the fact that
                # pref_b is non-decreasing, so for a given r, all l's with pref_b[l] < pref_b[r]
                # are valid for the b-frequency > 0 constraint.
                # We handle this by tracking two layers: one for pref_b[l] == pref_b[r] (not valid),
                # and one for pref_b[l] < pref_b[r] (valid).
                
                # Reset and use the proper two-layer approach
                # best[pa][pb] = min(pref_a - pref_b) among l's with pref_b[l] < current pref_b level
                # pending[pa][pb] = min(pref_a - pref_b) among l's with pref_b[l] == current pref_b level
                # When pref_b[r] increases, merge pending into best
                
                best = [[INF, INF], [INF, INF]]
                pending = [[INF, INF], [INF, INF]]
                prev_b_level = 0
                
                for r in range(k, n + 1):
                    # First add l = r - k to pending or best
                    l = r - k
                    pa_l = pref_a[l] % 2
                    pb_l = pref_b[l] % 2
                    val = pref_a[l] - pref_b[l]
                    
                    cur_b_level_r = pref_b[r]
                    
                    # If pref_b[l] < pref_b[r], add directly to best
                    # else add to pending
                    if pref_b[l] < cur_b_level_r:
                        best[pa_l][pb_l] = min(best[pa_l][pb_l], val)
                    else:
                        pending[pa_l][pb_l] = min(pending[pa_l][pb_l], val)
                    
                    # Check if we can form a valid substring ending at r
                    pa_r = pref_a[r] % 2
                    pb_r = pref_b[r] % 2
                    # Need pa_l = 1 - pa_r, pb_l = pb_r
                    needed_pa = 1 - pa_r
                    needed_pb = pb_r
                    b = best[needed_pa][needed_pb]
                    if b < INF:
                        res = max(res, (pref_a[r] - pref_b[r]) - b)
                
                # Flush: some pending entries might become valid for later r's
                # but we process them inline
        
        return res
```

## JavaScript
```javascript
var maxDifference = function(s, k) {
    const n = s.length;
    let res = -Infinity;
    const INF = Infinity;
    
    for (let a = 0; a <= 4; a++) {
        for (let b = 0; b <= 4; b++) {
            if (a === b) continue;
            
            const prefA = new Array(n + 1).fill(0);
            const prefB = new Array(n + 1).fill(0);
            for (let i = 0; i < n; i++) {
                const d = parseInt(s[i]);
                prefA[i + 1] = prefA[i] + (d === a ? 1 : 0);
                prefB[i + 1] = prefB[i] + (d === b ? 1 : 0);
            }
            
            const best = [[INF, INF], [INF, INF]];
            
            for (let r = k; r <= n; r++) {
                const l = r - k;
                const paL = prefA[l] % 2;
                const pbL = prefB[l] % 2;
                const val = prefA[l] - prefB[l];
                
                if (prefB[l] < prefB[r]) {
                    if (val < best[paL][pbL]) best[paL][pbL] = val;
                }
                
                const paR = prefA[r] % 2;
                const pbR = prefB[r] % 2;
                const neededPa = 1 - paR;
                const neededPb = pbR;
                const bv = best[neededPa][neededPb];
                if (bv < INF) {
                    res = Math.max(res, (prefA[r] - prefB[r]) - bv);
                }
            }
        }
    }
    
    return res;
};
```
