# https://leetcode.com/problems/goat-latin/

class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        vowels = set('aeiouAEIOU')
        result = []
        for i, w in enumerate(sentence.split(), 1):
            if w[0] in vowels:
                result.append(w + 'ma' + 'a' * i)
            else:
                result.append(w[1:] + w[0] + 'ma' + 'a' * i)
        return ' '.join(result)
