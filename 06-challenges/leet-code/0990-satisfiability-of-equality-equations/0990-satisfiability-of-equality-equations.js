// https://leetcode.com/problems/satisfiability-of-equality-equations/

var equationsPossible = function(equations) {
    const parent = Array.from({length: 26}, (_, i) => i);
    const find = (x) => { while (parent[x] !== x) { parent[x] = parent[parent[x]]; x = parent[x]; } return x; };
    for (const eq of equations) if (eq[1] === '=') parent[find(eq.charCodeAt(0)-97)] = find(eq.charCodeAt(3)-97);
    for (const eq of equations) if (eq[1] === '!' && find(eq.charCodeAt(0)-97) === find(eq.charCodeAt(3)-97)) return false;
    return true;
};
