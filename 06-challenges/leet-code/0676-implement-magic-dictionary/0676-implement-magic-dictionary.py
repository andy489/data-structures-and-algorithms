# https://leetcode.com/problems/implement-magic-dictionary/

class MagicDictionary:
    def __init__(self):
        self.words = []

    def buildDict(self, dictionary: list) -> None:
        self.words = dictionary

    def search(self, searchWord: str) -> bool:
        for word in self.words:
            if len(word) == len(searchWord):
                if sum(a != b for a, b in zip(word, searchWord)) == 1:
                    return True
        return False
