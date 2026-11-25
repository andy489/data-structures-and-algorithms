# https://leetcode.com/problems/stream-of-characters/

class StreamChecker:
    def __init__(self, words: list[str]):
        from collections import defaultdict
        self.trie = {}
        for w in words:
            node = self.trie
            for c in reversed(w):
                node = node.setdefault(c, {})
            node['#'] = True
        self.active = []

    def query(self, letter: str) -> bool:
        nxt = [self.trie]
        result = False
        for node in [self.trie] + self.active:
            if letter in node:
                child = node[letter]
                nxt.append(child)
                if '#' in child:
                    result = True
        self.active = nxt[1:]
        return result
