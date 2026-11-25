# 929. Unique Email Addresses

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/unique-email-addresses/

---

## Problem Statement

Every **valid email** consists of a **local name** and a **domain name**, separated by the `'@'` sign.

Rules for local name normalization:
- Periods `'.'` between letters in the local name are ignored.
- Everything after a `'+'` in the local name is ignored.

Given an array of strings `emails`, return *the number of different addresses* that actually receive mails.

---

## Examples

**Example 1:**
```
Input:  emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
```

---

## Constraints

- `1 <= emails.length <= 100`
- `1 <= emails[i].length <= 100`
- `emails[i]` consist of lowercase English letters, `'+'`, `'.'` and `'@'`.
