# https://leetcode.com/problems/longest-absolute-file-path/

class Solution:
    def lengthLongestPath(self, input: str) -> int:
        stack = {0: 0}
        max_len = 0
        for line in input.split('\n'):
            depth = len(line) - len(line.lstrip('\t'))
            name = line.lstrip('\t')
            stack[depth + 1] = stack[depth] + len(name) + 1
            if '.' in name:
                max_len = max(max_len, stack[depth + 1] - 1)
        return max_len
