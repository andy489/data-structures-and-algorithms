# 3374. First Letter Capitalization II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/first-letter-capitalization-ii/

---

## Problem Statement

**Table:** `user_content`

```
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| content_id   | int     |
| content_text | varchar |
+--------------+---------+
```
`content_id` is the unique key. Each row contains a unique ID and the corresponding text content.

A **word** is a maximal non-empty sequence of characters that does not contain a space.

Write a solution to transform the text in the `content_text` column by applying the following rules to each word:

- If the word starts with a character that is **not** an English letter, leave the entire word **unchanged**.
- Otherwise, if the word consists of two or more non-empty parts of English letters connected by hyphens `-`, convert the **first letter of each part** to uppercase and the **remaining letters of each part** to lowercase. For example, `top-rated` becomes `Top-Rated` and `FR-ONT-end` becomes `Fr-Ont-End`.
- Otherwise, convert the **first letter** of the word to uppercase and all **remaining English letters** to lowercase. Any special characters remain unchanged.

All other **formatting** and **spacing** must remain **unchanged**.

Return the result table that includes both the original `content_text` and the modified text.

---

## Examples

**Example:**
```
Input:
user_content:
| content_id | content_text                    |
|------------|----------------------------------|
| 1          | hello world of SQL              |
| 2          | the QUICK-brown fox             |
| 3          | modern-day DATA science         |
| 4          | web-based FRONT-end development |

Output:
| content_id | original_text                   | converted_text                  |
|------------|----------------------------------|----------------------------------|
| 1          | hello world of SQL              | Hello World Of Sql              |
| 2          | the QUICK-brown fox             | The Quick-Brown Fox             |
| 3          | modern-day DATA science         | Modern-Day Data Science         |
| 4          | web-based FRONT-end development | Web-Based Front-End Development |
```

---

## Constraints

- `content_text` contains only English letters, spaces, and the characters `\`, `@`, `-`, `/`, `^`, and `,`.
