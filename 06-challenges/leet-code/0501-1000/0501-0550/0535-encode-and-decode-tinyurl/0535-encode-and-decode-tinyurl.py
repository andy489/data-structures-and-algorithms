# https://leetcode.com/problems/encode-and-decode-tinyurl/

class Codec:
    def __init__(self) -> None:
        self._code_to_url: dict[int, str] = {}
        self._counter = 0

    def encode(self, longUrl: str) -> str:
        self._counter += 1
        self._code_to_url[self._counter] = longUrl
        return f"http://tinyurl.com/{self._counter}"

    def decode(self, shortUrl: str) -> str:
        key = int(shortUrl.split('/')[-1])
        return self._code_to_url[key]
