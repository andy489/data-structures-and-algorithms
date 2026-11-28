# 2949. Count Beautiful Substrings II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-beautiful-substrings-ii/

---

## Solution: Prefix Sum + HashMap by (prefix_diff, prefix_mod) — O(n * sqrt(k)) time, O(n * sqrt(k)) space

**Idea:** A substring `s[i+1..j]` is beautiful when:
1. vowels == consonants: encode each character as +1 (vowel) or -1 (consonant). The prefix sum difference `pre[j] - pre[i] == 0` means vowels == consonants.
2. vowels * consonants % k == 0: since vowels == consonants == len/2, condition becomes `(len/2)^2 % k == 0`, i.e., `len^2 / 4 % k == 0`, i.e., `len % (4k / gcd(4k, ...)) == 0`. More precisely, the minimum valid half-length `p` satisfies `p^2 % k == 0`. We find the smallest such `p` (which divides 2*k), so valid lengths are multiples of `2p`.

For each valid period `2p`, use a prefix map keyed on `(prefix_sum_diff, (index % (2p)))` to count how many previous indices had the same key.

**Algorithm:**
1. Find the smallest `p` such that `p * p % k == 0` (p = ceil(sqrt(k)) rounded up to satisfy divisibility).
2. Use prefix array where +1 = vowel, -1 = consonant.
3. For each `j`, the valid start `i` satisfies: `pre[i] == pre[j]` and `(j - i) % (2p) == 0`.
4. Count using a hashmap keyed by `(pre[j], j % (2p))`.

**Complexity:**

| | |
|---|---|
| Time | O(n * sqrt(k)) |
| Space | O(n * sqrt(k)) |
