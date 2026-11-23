# 591. Tag Validator

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/tag-validator/

---

## Problem Statement

Given a string representing a code snippet, implement a tag validator to parse the code and return whether it is valid.

A code snippet is valid if all the following rules hold:

1. The code must be wrapped in a **valid closed tag**. A closed tag is `<TAG_NAME>TAG_CONTENT</TAG_NAME>` where `TAG_NAME` is 1–9 uppercase English letters, and `TAG_CONTENT` can contain other **valid closed tags**, **cdata**, and any characters except `<`.
2. A **CDATA** section is `<![CDATA[CDATA_CONTENT]]>` where `CDATA_CONTENT` can contain any characters. The `]]>` closes the cdata.
3. An **open tag** cannot appear after a valid closed tag at the same level.

---

## Examples

**Example 1:**
```
Input:  code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
Output: true
```

**Example 2:**
```
Input:  code = "<DIV>>>  div tag is not closed  <DIV>"
Output: false
```

**Example 3:**
```
Input:  code = "<DIV>  div tag is not closed  <DIV>"
Output: false
```

---

## Constraints

- `1 <= code.length <= 500`
- `code` consists of uppercase and lowercase English letters, digits, `'<'`, `'>'`, `'/'`, `'!'`, `'['`, `']'`, and `' '`.
