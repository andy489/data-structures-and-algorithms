# 1694. Reformat Phone Number

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reformat-phone-number/

---

## Problem Statement

You are given a phone number as a string `number`. `number` consists of digits, spaces `' '`, and/or dashes `'-'`.

You would like to reformat the phone number in a certain manner. Firstly, **remove** all spaces and dashes. Then, **group** the digits from left to right into blocks of length 3 **until** there are 4 or fewer digits. The final digits are then grouped as follows:

- 2 digits: a single block of length 2.
- 3 digits: a single block of length 3.
- 4 digits: two blocks of length 2 each.

The blocks are then joined by dashes. Notice that the reformatting process should **never** produce any blocks of length 1 and produce **at most two** blocks of length 2.

Return the phone number after formatting.

---

## Examples

**Example 1:**
```
Input: number = "1-23-45 6"
Output: "123-456"
```

**Example 2:**
```
Input: number = "123 4-567"
Output: "123-45-67"
Explanation: The digits are "1234567". Step 1: group 3 -> "123". Remaining: "4567" -> two blocks of 2: "45-67".
```

**Example 3:**
```
Input: number = "123 4-5678"
Output: "123-456-78"
```

---

## Constraints

- `2 <= number.length <= 100`
- `number` consists of digits and the characters `'-'` and `' '`.
- There are at least **two** digits in `number`.
