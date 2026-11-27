# https://leetcode.com/problems/parse-lisp-expression/

class Solution:
    def evaluate(self, expression: str) -> int:
        self.expr = expression
        self.idx = 0

        def parse(scope):
            if self.expr[self.idx] == '(':
                self.idx += 1
                if self.expr[self.idx:self.idx+3] == 'let':
                    self.idx += 3
                    local = dict(scope)
                    while True:
                        self.idx += 1  # skip space
                        c = self.expr[self.idx]
                        if c == '(' or c == '-' or c.isdigit():
                            res = parse(local)
                            break
                        start = self.idx
                        while self.idx < len(self.expr) and self.expr[self.idx] not in ' )':
                            self.idx += 1
                        name = self.expr[start:self.idx]
                        if self.expr[self.idx] == ')':
                            res = local.get(name, 0)
                            break
                        self.idx += 1
                        val = parse(local)
                        local[name] = val
                elif self.expr[self.idx:self.idx+3] == 'add':
                    self.idx += 3; self.idx += 1
                    a = parse(scope); self.idx += 1
                    b = parse(scope)
                    res = a + b
                else:
                    self.idx += 4; self.idx += 1
                    a = parse(scope); self.idx += 1
                    b = parse(scope)
                    res = a * b
                self.idx += 1  # skip ')'
                return res
            elif self.expr[self.idx] == '-' or self.expr[self.idx].isdigit():
                start = self.idx
                if self.expr[self.idx] == '-':
                    self.idx += 1
                while self.idx < len(self.expr) and self.expr[self.idx].isdigit():
                    self.idx += 1
                return int(self.expr[start:self.idx])
            else:
                start = self.idx
                while self.idx < len(self.expr) and self.expr[self.idx] not in ' )':
                    self.idx += 1
                return scope.get(self.expr[start:self.idx], 0)

        return parse({})
