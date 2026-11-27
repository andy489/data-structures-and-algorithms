# 393. UTF-8 Validation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/utf-8-validation/

---

## Problem Statement

Given an integer array `data` representing the data, return whether it is a valid UTF-8 encoding (i.e., it translates to a sequence of valid UTF-8 encoded characters).

A character in UTF-8 can be from 1 to 4 bytes long, with each byte following these rules:

- 1-byte: `0xxxxxxx`
- 2-byte: `110xxxxx 10xxxxxx`
- 3-byte: `1110xxxx 10xxxxxx 10xxxxxx`
- 4-byte: `11110xxx 10xxxxxx 10xxxxxx 10xxxxxx`

---

## Examples

**Example 1:**
```
Input:  data = [197,130,1]
Output: true
Explanation: data represents the octet sequence: 11000101 10000010 00000001.
  It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
```

**Example 2:**
```
Input:  data = [235,140,4]
Output: false
Explanation: data represented the octet sequence: 11101011 10001100 00000100.
  The first 3 bits are all set, the 4th bit is not set, so it is a 3-bytes character.
  The next byte is a continuation byte which is correct.
  But the second continuation byte does not start with 10, so it is invalid.
```

---

## Constraints

- `1 <= data.length <= 2 * 10^4`
- `0 <= data[i] <= 255`
