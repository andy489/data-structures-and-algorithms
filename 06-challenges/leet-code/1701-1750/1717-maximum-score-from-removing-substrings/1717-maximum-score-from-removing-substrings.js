// https://leetcode.com/problems/maximum-score-from-removing-substrings/

var maximumGain = function(s, x, y) {
    const removePair = (chars, first, second, points) => {
        const stack = [];
        let score = 0;
        for (const c of chars) {
            if (stack.length > 0 && stack[stack.length - 1] === first && c === second) {
                stack.pop();
                score += points;
            } else {
                stack.push(c);
            }
        }
        return [stack, score];
    };

    let chars = [...s];
    let score1, score2, remaining;
    if (x >= y) {
        [remaining, score1] = removePair(chars, 'a', 'b', x);
        [, score2] = removePair(remaining, 'b', 'a', y);
    } else {
        [remaining, score1] = removePair(chars, 'b', 'a', y);
        [, score2] = removePair(remaining, 'a', 'b', x);
    }
    return score1 + score2;
};
