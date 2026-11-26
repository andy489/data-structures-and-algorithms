// https://leetcode.com/problems/rearrange-spaces-between-words/

var reorderSpaces = function(text) {
    const spaces = [...text].filter(c => c === ' ').length;
    const words = text.trim().split(/\s+/);
    const gaps = words.length - 1;
    const between = gaps === 0 ? 0 : Math.floor(spaces / gaps);
    const trailing = spaces - between * gaps;
    return words.join(' '.repeat(between)) + ' '.repeat(trailing);
};
