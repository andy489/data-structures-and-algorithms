// https://leetcode.com/problems/text-justification/

var fullJustify = function(words, maxWidth) {
    const result = [];
    let i = 0;
    while (i < words.length) {
        let lineLen = words[i].length;
        let j = i + 1;
        while (j < words.length && lineLen + 1 + words[j].length <= maxWidth) {
            lineLen += 1 + words[j].length;
            j++;
        }
        result.push(buildLine(words.slice(i, j), maxWidth, j === words.length));
        i = j;
    }
    return result;
};

function buildLine(words, maxWidth, isLast) {
    const gaps = words.length - 1;
    if (isLast || gaps === 0) {
        return words.join(' ').padEnd(maxWidth);
    }
    const totalSpaces = maxWidth - words.reduce((s, w) => s + w.length, 0);
    const spacePerGap = Math.floor(totalSpaces / gaps);
    const extra = totalSpaces % gaps;
    let line = '';
    for (let k = 0; k < words.length; k++) {
        line += words[k];
        if (k < gaps) {
            line += ' '.repeat(spacePerGap + (k < extra ? 1 : 0));
        }
    }
    return line;
}
