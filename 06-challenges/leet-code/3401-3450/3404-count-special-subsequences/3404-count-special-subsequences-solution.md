# Solution: Count Special Subsequences

## Approach

The condition nums[p]*nums[r] == nums[q]*nums[s] means nums[p]/nums[q] == nums[s]/nums[r].

Rewrite as: nums[p]*nums[r] == nums[q]*nums[s], or equivalently nums[p]/nums[q] == nums[s]/nums[r].

Iterate over all pairs (q, r) where r - q > 1. For each such pair, we need to count valid p's (p < q-1) and valid s's (s > r+1).

For a fixed (q, r): count pairs (p, s) where nums[p]*nums[r] == nums[q]*nums[s], i.e., nums[p]/nums[q] == nums[s]/nums[r].

Approach: for each index r, maintain a map from (nums[q]/nums[p]) stored as ratio to count. Specifically, as we move r from left to right, for each q = r-1, r-2,... down to 2, we want to pair with earlier p.

Cleaner O(n^2): iterate r from 2 to n-3. For each r, count how many pairs (p,q) with p < q < r-1 satisfy nums[p]*nums[r] == nums[q]*nums[s]... we need s too.

Best approach: iterate over pairs (q, r) where r >= q+2. For each pair, the ratio key is (nums[q], nums[r]) reduced by their gcd. Count how many valid p's have ratio nums[p]:nums[q] matching nums[r]:nums[s]. 

Actually simplest O(n^2) with a map: for each r (from index 2 to n-3), maintain a map `cnt[(a,b)]` = number of pairs (p,q) with q <= r-2 and nums[p]=a, nums[q]=b, q-p>1. For each r, iterate over s > r+1, looking up count with (nums[s], nums[r]) → that's how many (p,q) have nums[p]*nums[r] == nums[q]*nums[s].

Implementation: outer loop on s from 3 to n-1. Inner precompute for each s, count all (p,q,r) with r < s-1. Use a map keyed by (nums[r], ...) ... this gets complex.

Simpler O(n^2) approach: for each pair (q,r) with r-q > 1, the ratio is nums[q]/nums[r] = nums[s]/nums[p] ... 

Final clean approach: enumerate middle pair (q,r). Count of valid (p) where p < q-1 with ratio nums[p]:nums[q] = k:1 (for all valid k). Pair with count of valid (s) where s > r+1 with ratio nums[s]:nums[r] forming the same ratio.

nums[p]*nums[r] == nums[q]*nums[s] → group by ratio nums[p]/nums[q] paired with nums[s]/nums[r].

Iterate pairs (q,r), for each precompute prefix counts of nums[p] for p < q-1 and suffix counts of nums[s] for s > r+1, then for each (a,b) where a*nums[r]==b*nums[q] accumulate count[a]*count[b].

O(n^2 * max_val) is too slow. Use a map: for each (q,r) iterate over all a in left counts, compute needed b = a*nums[r]/nums[q], check if integer, look up in right suffix counts.

But O(n^2 * n) = O(n^3) worst case. For n=1000 that's 10^9 — too slow.

Better: for each (q,r), sum over all a: left[a] * right[a*nums[r]/nums[q]].

This is O(n^2 * sqrt(max_val)) with gcd tricks. For n=1000, it's around 10^7, manageable.

Actually simplest: nested loops over (p,q,r,s) is O(n^4) = too slow. 

Optimal: fix q and r. Left side: count[a] = #{p: p <= q-2, nums[p]=a}. Right: count2[b] = #{s: s >= r+2, nums[s]=b}. Answer += sum over (a,b) where a*nums[r]==b*nums[q] of count[a]*count2[b].

Build prefix count arrays and suffix count arrays, then iterate q,r with r >= q+2, and for each pair iterate over all values a in 1..1000, compute b = a*nums[r]/nums[q], check if integer.

Total: O(n^2 * max_val) = O(1000^2 * 1000) = 10^9, still too slow.

Optimized: group by gcd. For each (q,r), g = gcd(nums[q], nums[r]), aq = nums[q]/g, ar = nums[r]/g. Need a*ar == b*aq → a must be multiple of aq. So a = aq*t, b = ar*t. Iterate t from 1 to 1000/aq. Sum left[aq*t] * right[ar*t].

This runs in O(n^2 * max_val/max(nums[q],nums[r])) which on average is much faster.

## Complexity

| | Complexity |
|---|---|
| Time | O(n^2 * max_val) worst, O(n^2 * max_val/avg) in practice |
| Space | O(max_val) |
