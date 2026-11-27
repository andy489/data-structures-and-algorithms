# Solution for 3901. Good Subsequence Queries

## Approach

**Key insight:** A good subsequence of GCD exactly `p` exists if and only if at least two elements in `nums` are divisible by `p`, but not all `n` elements are multiples of `p/2` (or more precisely, if there exists a subset of size < n with GCD exactly p).

More precisely: A good subsequence (length < n, GCD = p) exists if:
1. There are at least 2 elements divisible by `p`, AND
2. There is at least one element divisible by `p` but NOT by `2p`, OR the size of multiples-of-p is less than n.

Actually the precise condition: GCD exactly p means all selected elements divisible by p and GCD = p (not 2p, 3p, etc.). The key simplification: if there exist at least 2 elements divisible by p but not all by 2p (i.e., at least one is divisible by p but not by 2p), or more generally, if we can pick a set with GCD exactly p.

**Simplified condition:** A subsequence with GCD = p of length < n exists if and only if:
- There are >= 2 elements divisible by p, AND the number of elements divisible by p is < n, OR
- We can pick a subset that achieves GCD exactly p.

A cleaner approach: GCD = p exactly means the GCD of chosen elements is p (all divisible by p, and GCD of (elements/p) is 1). The smallest check: if at least 2 elements are divisible by p and not all n elements have GCD > p (meaning GCD of all divisible-by-p elements is exactly p), and the subset size < n.

**Practical approach:**
- Maintain a frequency/count array of multiples.
- For each query update, check: for every divisor `d` of p's multiples (d > 1), count elements divisible by `p*d`. A good subseq exists iff `count[p] >= 2` and `count[p] < n`, or `count[p] >= 1` and there's a second element that together gives GCD = p.

**Key simplification used in competitive programming:** A good subsequence with GCD = p exists iff:
1. `count[p] >= 2` (at least 2 multiples of p), AND
2. At least one element is divisible by p but NOT by 2p (so their GCD can be exactly p), OR the subset doesn't include all elements with GCD > p.

For Hard problems like this, the standard approach: iterate over all multiples of p. The GCD of elements divisible by p equals `p * gcd(e1/p, e2/p, ...)`. We want this inner GCD to be 1. We need to find if we can pick < n elements all divisible by p whose inner GCDs form 1. If `count_p < n`: take all count_p elements; their inner GCD g. If g == 1 we have it. If g > 1, pick 2 elements not both divisible by g*p.

**Efficient solution:** Track `cnt[v]` = number of elements equal to `v`. For good subsequence check after each update:
- Let `S` = set of distinct values divisible by `p`.
- A good subseq exists if |S| (counting multiplicities) >= 2 AND GCD of all S/p is 1, OR can find subset.

For competition: a good subseq (GCD=p, len<n) exists iff:
- Number of distinct multiples of p present = at least 2 and are not all also multiples of some prime factor's multiple (complexity)

**Working approach:** Count elements divisible by p. If count >= 2: check if the GCD of `(count_p elements / p)` equals 1. If the count >= 2 and gcd != 1, we can still check pairs. For this problem: since we track counts, after each update compute the GCD of all values divisible by p (divided by p), and if that GCD is 1 AND count >= 2 AND count < n, then yes.

Actually: count < n is important only if all n elements are multiples of p and GCD(all/p) = 1 — but then we can pick any n-1 of them (still < n, still GCD p if there's no common factor), which still works if GCD of n-1 elements is p.

**Final algorithm:**
- Maintain `cnt` array of current values.
- After each update, track the multiset of values.
- For answer: if at least 2 elements are divisible by p, and GCD of those elements / p = 1, and (count_p < n OR we can form a subseq of len < n with GCD = p): answer YES.

The simplest valid check: **count_p_nonzero >= 2** (there are at least 2 distinct value-slots divisible by p present) **AND** `gcd_of_multiples_of_p / p = 1`.

## Complexity

- Time: O(q * sqrt(max_val)) per query for GCD computation
- Space: O(max_val) for count array
