// https://leetcode.com/problems/keyboard-row/

var findWords = function(words) {
    const rows = ["qwertyuiop", "asdfghjkl", "zxcvbnm"];
    const charToRow = {};
    rows.forEach((row, r) => { for (const c of row) charToRow[c] = r; });
    return words.filter(word => {
        const lower = word.toLowerCase();
        const row = charToRow[lower[0]];
        return [...lower].every(c => charToRow[c] === row);
    });
};
