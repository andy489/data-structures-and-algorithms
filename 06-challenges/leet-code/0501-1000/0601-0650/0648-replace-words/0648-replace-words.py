# https://leetcode.com/problems/replace-words/

class Solution:
    def replaceWords(self, dictionary: list[str], sentence: str) -> str:
        root_set = set(dictionary)
        result = []
        for word in sentence.split():
            replacement = word
            for length in range(1, len(word) + 1):
                prefix = word[:length]
                if prefix in root_set:
                    replacement = prefix
                    break
            result.append(replacement)
        return " ".join(result)
