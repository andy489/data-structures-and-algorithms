# https://leetcode.com/problems/remove-comments/

class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        result = []
        buf = []
        in_block = False
        for line in source:
            i = 0
            if not in_block:
                buf = []
            while i < len(line):
                if in_block:
                    if line[i:i+2] == '*/':
                        in_block = False
                        i += 2
                    else:
                        i += 1
                else:
                    if line[i:i+2] == '//':
                        break
                    elif line[i:i+2] == '/*':
                        in_block = True
                        i += 2
                    else:
                        buf.append(line[i])
                        i += 1
            if not in_block and buf:
                result.append(''.join(buf))
        return result
