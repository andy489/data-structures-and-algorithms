# 1961. Check If String Is a Prefix of Array — Solution

## Approach

Concatenate words one by one and check at each step:
- If the concatenation equals s, return true.
- If the concatenation length exceeds s, return false.

**Complexity:** O(n) time, O(n) space.
