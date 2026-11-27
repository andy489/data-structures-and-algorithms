# 1105. Filling Bookcase Shelves

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/filling-bookcase-shelves/

---

## Problem Statement

You are given an array `books` where `books[i] = [thickness_i, height_i]` indicates the thickness and height of the i-th book. You are also given an integer `shelfWidth`.

We want to place these books in order onto bookcase shelves that each have a total width `shelfWidth`. We choose some books to put on the first shelf, with their total thickness less than or equal to `shelfWidth`, then all remaining books go on later shelves. The process repeats. The height of each shelf is the maximum height of any book on it. The total height of the bookcase is the sum of heights of all shelves.

Return the minimum possible total height of the bookcase after placing all the books.

---

## Examples

**Example 1:**
```
Input:  books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
Output: 6
```

**Example 2:**
```
Input:  books = [[1,3],[2,4],[3,2]], shelfWidth = 6
Output: 4
```

---

## Constraints

- `1 <= books.length <= 1000`
- `1 <= thickness_i <= shelfWidth <= 1000`
- `1 <= height_i <= 1000`
