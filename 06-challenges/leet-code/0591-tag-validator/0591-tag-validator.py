# https://leetcode.com/problems/tag-validator/
class Solution:
    def isValid(self, code: str) -> bool:
        tag_stack = []
        i = 0
        n = len(code)
        while i < n:
            if i > 0 and not tag_stack:
                return False
            if code[i:i+9] == '<![CDATA[':
                end = code.find(']]>', i + 9)
                if end == -1:
                    return False
                i = end + 3
            elif code[i:i+2] == '</':
                end = code.find('>', i)
                if end == -1:
                    return False
                tag = code[i+2:end]
                if not self._valid_tag(tag):
                    return False
                if not tag_stack or tag_stack[-1] != tag:
                    return False
                tag_stack.pop()
                i = end + 1
            elif code[i] == '<':
                end = code.find('>', i)
                if end == -1:
                    return False
                tag = code[i+1:end]
                if not self._valid_tag(tag):
                    return False
                tag_stack.append(tag)
                i = end + 1
            else:
                i += 1
        return not tag_stack

    def _valid_tag(self, tag: str) -> bool:
        return 1 <= len(tag) <= 9 and tag.isupper()
