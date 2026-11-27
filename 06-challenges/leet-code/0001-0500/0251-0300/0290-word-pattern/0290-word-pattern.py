# https://leetcode.com/problems/word-pattern/

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        if len(words) != len(pattern):
            return False
        char_to_word = {}
        word_to_char = {}
        for ch, word in zip(pattern, words):
            if char_to_word.get(ch, word) != word:
                return False
            if word_to_char.get(word, ch) != ch:
                return False
            char_to_word[ch] = word
            word_to_char[word] = ch
        return True
