# 721. Accounts Merge — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/accounts-merge/

---

## Solution: Union-Find — O(n·k·α(n·k)) time, O(n·k) space

**Idea:** Use Union-Find. Map each email to an index. Union all emails in the same account. Then group emails by their root, and map root back to account name.

**Algorithm:**
1. Assign each email a unique integer ID. Map email → ID and email → name.
2. For each account, union all its emails (email[0] with email[1], email[1] with email[2], ...).
3. Group emails by their find(root). For each group, prepend the name and sort emails.
4. Return all groups.

**Complexity:**

| | |
|---|---|
| Time | O(n·k·α(n·k)) — near-linear with path compression |
| Space | O(n·k) — storing all emails |
