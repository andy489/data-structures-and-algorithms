# 1733. Minimum Number of People to Teach

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-people-to-teach/

---

## Problem Statement

On a social network consisting of `m` users and some friendships between users, two users can communicate with each other if they know a common language.

You are given an integer `n`, an array `languages`, and an array `friendships` where:

- There are `n` languages numbered `1` through `n`.
- `languages[i]` is the set of languages the `i`th user knows.
- `friendships[i] = [ui, vi]` denotes a friendship between the users `ui` and `vi`.

You can choose **one** language and teach it to some users so that all friends can communicate with each other. Return *the* **minimum** *number of users you need to teach.*

Note that friendships are not transitive; meaning if x is a friend of y and y is a friend of z, they don't have to be friends of each other.

---

## Examples

**Example 1:**
```
Input: n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
Output: 1
Explanation: Teach user 1 language 2 or teach user 2 language 1.
```

**Example 2:**
```
Input: n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
Output: 2
```

---

## Constraints

- `2 <= n <= 500`
- `languages.length == m`
- `1 <= m <= 500`
- `1 <= languages[i].length <= n`
- `1 <= languages[i][j] <= n`
- `1 <= ui < vi <= languages.length`
- `1 <= friendships.length <= 500`
- All tuples `(ui, vi)` are unique.
- `languages[i]` contains no duplicates.
