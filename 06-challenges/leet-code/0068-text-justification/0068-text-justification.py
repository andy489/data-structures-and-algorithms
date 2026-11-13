# https://leetcode.com/problems/text-justification/

class Solution:
    def fullJustify(self, words: list[str], maxWidth: int) -> list[str]:
        result = []
        i = 0
        while i < len(words):
            line_len = len(words[i])
            j = i + 1
            while j < len(words) and line_len + 1 + len(words[j]) <= maxWidth:
                line_len += 1 + len(words[j])
                j += 1
            line_words = words[i:j]
            result.append(self._build_line(line_words, maxWidth, j == len(words)))
            i = j
        return result

    def _build_line(self, words: list[str], max_width: int, is_last: bool) -> str:
        gaps = len(words) - 1
        if is_last or gaps == 0:
            return ' '.join(words).ljust(max_width)
        total_spaces = max_width - sum(len(w) for w in words)
        space_per_gap, extra = divmod(total_spaces, gaps)
        line = []
        for k, word in enumerate(words):
            line.append(word)
            if k < gaps:
                line.append(' ' * (space_per_gap + (1 if k < extra else 0)))
        return ''.join(line)
