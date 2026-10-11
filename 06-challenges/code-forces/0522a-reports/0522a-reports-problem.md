# 522A. Reposts

**Rating:** 1200  
**Tags:** dfs and similar, dp, graphs, trees, special problem  
**Link:** https://codeforces.com/problemset/problem/522/A

---

## Problem Statement

Polycarp posts a picture. Other users repost it, forming a chain. Each repost is recorded as:

```
name1 reposted name2
```

meaning `name1` saw and reposted `name2`'s post. The chain starts from Polycarp.

Find the **maximum length of a repost chain** starting from Polycarp. The chain length includes Polycarp's original post.

**Note:** Usernames are case-insensitive.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 200)
- Next *n* lines: repost records in format `name1 reposted name2`

---

## Output Format

Single integer — maximum repost chain length.

---

## Examples

**Example 1:**
```
Input:
5
tourist reposted Polycarp
Petr reposted Tourist
WJMZBMR reposted Petr
sdya reposted wjmzbmr
vepifanov reposted sdya

Output:
6
```
Chain: Polycarp → tourist → Petr → WJMZBMR → sdya → vepifanov (length 6)

**Example 2:**
```
Input:
6
Mike reposted Polycarp
Max reposted Polycarp
EveryOne reposted Polycarp
111 reposted Polycarp
VkCup reposted Polycarp
Codeforces reposted Polycarp

Output:
2
```

**Example 3:**
```
Input:
1
SoMeStRaNgEgUe reposted PoLyCaRp

Output:
2
```

---

## Constraints

- 1 ≤ *n* ≤ 200
- Usernames: 1–40 characters, letters and digits, case-insensitive
- Time limit: 1 second, Memory limit: 256 MB
