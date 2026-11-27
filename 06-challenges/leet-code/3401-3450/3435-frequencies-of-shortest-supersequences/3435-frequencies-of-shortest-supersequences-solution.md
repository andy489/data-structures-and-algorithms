# 3435. Frequencies of Shortest Supersequences — Solution

## Approach

Each word has length 2. For a pair `(a, b)` to both be subsequences of a supersequence, we need to handle ordering constraints: if word is "ab", then 'a' must appear before 'b'. If two words create a cycle in the ordering (e.g., "ab" and "ba" both require a before b and b before a), we need an extra character.

**Key Insight:**
1. Build a constraint graph among the unique characters. For each word "xy":
   - If `x != y`: add a directed edge `x -> y` (x must come before y)
   - If `x == y`: character `x` appears at least 2 times
2. For each character, the minimum count is `max(1 from any word, explicit duplicates)`.
3. The length of the SCS = sum of max frequencies + number of "back edges" (cycle-creating edges in the topological sense).
4. Use bitmask DP over the unique characters (up to 16) to enumerate all valid topological orderings and find minimum-length SCSs.

The problem reduces to: find minimum vertex feedback arc sets in a tournament-like DAG, then enumerate all resulting frequency arrays.

**Time Complexity:** O(2^16 * 16) for bitmask DP
**Space Complexity:** O(2^16)
