# 2222. Number of Ways to Select Buildings — Solution

**Approach:** Prefix Count / One-pass DP

Track counts of `0`s and `1`s seen so far, plus counts of `01` and `10` pairs. For each new character, the number of valid `010` triples ending here is `count_01`, and `101` triples is `count_10`. Update pair counts accordingly.

**Time Complexity:** O(n)

**Space Complexity:** O(1)
