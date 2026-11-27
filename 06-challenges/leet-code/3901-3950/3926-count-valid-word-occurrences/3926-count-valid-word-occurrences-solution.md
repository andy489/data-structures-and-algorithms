# 3926. Count Valid Word Occurrences — Solution

## Approach: String Parsing with Joiner Hyphen Logic

1. Concatenate all `chunks` into a single string `s`.
2. Parse `s` character by character to extract words:
   - A character starts or continues a word if it is a lowercase letter.
   - A hyphen `'-'` is a **joiner hyphen** (part of the word) only if both the previous and next characters are lowercase letters.
   - Spaces and non-joiner hyphens act as separators.
3. Use a hash map to count word frequencies.
4. For each query, look up its count in the map.

**Parsing strategy:** Iterate through `s`. When we see a letter, start collecting a word token. At a hyphen, check if the next character is also a letter — if yes, include it; if no, end the word at the hyphen. End the word at any space.

Actually, the cleanest approach: collect characters into a current token. When we reach a separator (space or non-joiner hyphen), flush the token as a word. A hyphen at position `i` is a joiner if `s[i-1]` and `s[i+1]` are both letters.

## Complexity

- **Time:** O(|s| + |queries total length|) — one pass to parse words, one lookup per query
- **Space:** O(W) — where W is the number of unique words
