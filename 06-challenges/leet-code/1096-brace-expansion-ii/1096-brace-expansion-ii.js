// https://leetcode.com/problems/brace-expansion-ii/

var braceExpansionII = function(expression) {
    let idx = 0;
    function parse() {
        let result = new Set(['']);
        while (idx < expression.length && expression[idx] !== '}' && expression[idx] !== ',') {
            let nxt;
            if (expression[idx] === '{') {
                idx++;
                nxt = parse();
                while (expression[idx] === ',') { idx++; for (const s of parse()) nxt.add(s); }
                idx++;
            } else {
                nxt = new Set([expression[idx++]]);
            }
            const combined = new Set();
            for (const a of result) for (const b of nxt) combined.add(a+b);
            result = combined;
        }
        return result;
    }
    return [...parse()].sort();
};
