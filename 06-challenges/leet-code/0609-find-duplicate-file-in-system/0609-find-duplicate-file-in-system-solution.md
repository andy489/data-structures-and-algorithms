# 609. Find Duplicate File in System — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-duplicate-file-in-system/

---

## Solution: Hash Map by Content — O(n·k) time, O(n·k) space

**Idea:** Parse each path string to extract file contents as keys, mapping each content to all file paths that share it. Return all groups with size >= 2.

**Algorithm:**
1. For each path string, split by space to get directory and file tokens.
2. For each file token, extract filename and content (between `(` and `)`).
3. Map content → list of full paths.
4. Return all lists with length >= 2.

**Complexity:**

| | |
|---|---|
| Time | O(n·k) — n paths, k files per path |
| Space | O(n·k) — hash map |
