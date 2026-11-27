# https://leetcode.com/problems/encrypt-and-decrypt-strings/
class Encrypter:
    def __init__(self, keys: List[str], values: List[str], dictionary: List[str]):
        self.encrypt_map = {k: v for k, v in zip(keys, values)}
        self.decrypt_count = {}
        for word in dictionary:
            encrypted = self.encrypt(word)
            if encrypted:
                self.decrypt_count[encrypted] = self.decrypt_count.get(encrypted, 0) + 1

    def encrypt(self, word1: str) -> str:
        result = []
        for c in word1:
            if c not in self.encrypt_map:
                return ""
            result.append(self.encrypt_map[c])
        return "".join(result)

    def decrypt(self, word2: str) -> int:
        return self.decrypt_count.get(word2, 0)
