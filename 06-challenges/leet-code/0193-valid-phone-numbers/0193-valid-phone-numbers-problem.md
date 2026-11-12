# 193. Valid Phone Numbers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-phone-numbers/

---

## Problem Statement

Given a text file `file.txt` that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers.

A phone number is valid if it matches **exactly one** of the following formats:
- `(xxx) xxx-xxxx`
- `xxx-xxx-xxxx`

where `x` is a digit. There is no leading or trailing whitespace on any line.

---

## Examples

**Example:**
```
Input (file.txt):
  987-123-4567
  123 456 7890
  (123) 456-7890

Output:
  987-123-4567
  (123) 456-7890
```

---

## Constraints

- Each line contains no leading or trailing whitespace.
- A valid phone number must strictly match one of the two formats above.
