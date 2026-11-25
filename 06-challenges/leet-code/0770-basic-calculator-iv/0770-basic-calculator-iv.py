# https://leetcode.com/problems/basic-calculator-iv/

from collections import defaultdict

class Solution:
    def basicCalculatorIV(self, expression: str, evalvars: list[str], evalints: list[int]) -> list[str]:
        ev = dict(zip(evalvars, evalints))
        tokens = iter(expression.split())

        def make_const(c):
            return {(): c}

        def make_var(v):
            return {(v,): 1}

        def add(a, b):
            r = defaultdict(int, a)
            for k, v in b.items():
                r[k] += v
            return {k: v for k, v in r.items() if v != 0}

        def sub(a, b):
            return add(a, {k: -v for k, v in b.items()})

        def mul(a, b):
            r = defaultdict(int)
            for ka, va in a.items():
                for kb, vb in b.items():
                    key = tuple(sorted(ka + kb))
                    r[key] += va * vb
            return {k: v for k, v in r.items() if v != 0}

        def parse():
            addends, signs = [parse_mult()], [1]
            tok = next(tokens, None)
            while tok in ('+', '-'):
                signs.append(1 if tok == '+' else -1)
                addends.append(parse_mult())
                tok = next(tokens, None)
            if tok is not None and tok != ')':
                # shouldn't happen, but push back isn't possible — handled by the structure
                pass
            result = {}
            for s, a in zip(signs, addends):
                result = add(result, {k: s*v for k, v in a.items()})
            return result

        def parse_mult():
            result = parse_atom()
            tok = next(tokens, None)
            while tok == '*':
                result = mul(result, parse_atom())
                tok = next(tokens, None)
            # tok is either None, '+', '-', ')' — need to "unget" it
            if tok is not None:
                nonlocal lookahead
                lookahead = tok
            return result

        # Rewrite using a list-based token approach for proper lookahead
        toks = expression.split()
        idx = [0]

        def peek():
            return toks[idx[0]] if idx[0] < len(toks) else None

        def consume():
            t = toks[idx[0]]
            idx[0] += 1
            return t

        def p_expr():
            left = p_mult()
            while peek() in ('+', '-'):
                op = consume()
                right = p_mult()
                if op == '+':
                    left = add(left, right)
                else:
                    left = sub(left, right)
            return left

        def p_mult():
            left = p_atom()
            while peek() == '*':
                consume()
                left = mul(left, p_atom())
            return left

        def p_atom():
            t = consume()
            if t == '(':
                val = p_expr()
                consume()  # ')'
                return val
            if t.lstrip('-').isdigit():
                return make_const(int(t))
            if t in ev:
                return make_const(ev[t])
            return make_var(t)

        poly = p_expr()

        def key_order(item):
            k, v = item
            return (-len(k), k)

        result = []
        for k, v in sorted(poly.items(), key=key_order):
            if v != 0:
                parts = [str(v)] + list(k)
                result.append('*'.join(parts))
        return result
