// https://leetcode.com/problems/basic-calculator-iv/

var basicCalculatorIV = function(expression, evalvars, evalints) {
    const ev = {};
    for (let i = 0; i < evalvars.length; i++) ev[evalvars[i]] = evalints[i];
    const toks = expression.split(' ');
    let idx = 0;
    const peek = () => toks[idx];
    const consume = () => toks[idx++];

    const add = (a, b) => {
        const r = new Map(a);
        for (const [k, v] of b) r.set(k, (r.get(k) || 0) + v);
        for (const [k, v] of r) if (v === 0) r.delete(k);
        return r;
    };
    const sub = (a, b) => {
        const neg = new Map();
        for (const [k, v] of b) neg.set(k, -v);
        return add(a, neg);
    };
    const mul = (a, b) => {
        const r = new Map();
        for (const [ka, va] of a) for (const [kb, vb] of b) {
            const key = [...ka.split(',').filter(Boolean), ...kb.split(',').filter(Boolean)].sort().join(',');
            r.set(key, (r.get(key) || 0) + va * vb);
        }
        for (const [k, v] of r) if (v === 0) r.delete(k);
        return r;
    };
    const makeConst = c => new Map([['', c]]);
    const makeVar = v => new Map([[v, 1]]);

    const pExpr = () => {
        let left = pMult();
        while (peek() === '+' || peek() === '-') {
            const op = consume();
            const right = pMult();
            left = op === '+' ? add(left, right) : sub(left, right);
        }
        return left;
    };
    const pMult = () => {
        let left = pAtom();
        while (peek() === '*') { consume(); left = mul(left, pAtom()); }
        return left;
    };
    const pAtom = () => {
        const t = consume();
        if (t === '(') { const val = pExpr(); consume(); return val; }
        if (/^-?\d+$/.test(t)) return makeConst(parseInt(t));
        if (t in ev) return makeConst(ev[t]);
        return makeVar(t);
    };

    const poly = pExpr();
    const terms = [...poly.entries()].filter(([,v]) => v !== 0);
    terms.sort(([ka], [kb]) => {
        const la = ka ? ka.split(',').length : 0;
        const lb = kb ? kb.split(',').length : 0;
        if (la !== lb) return lb - la;
        return ka < kb ? -1 : ka > kb ? 1 : 0;
    });
    return terms.map(([k, v]) => k ? `${v}*${k.replace(/,/g, '*')}` : `${v}`);
};
