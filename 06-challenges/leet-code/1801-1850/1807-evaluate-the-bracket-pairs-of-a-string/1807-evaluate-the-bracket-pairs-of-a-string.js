// https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

var evaluate = function(s, knowledge) {
    const dict = new Map(knowledge);
    return s.replace(/\((\w+)\)/g, (_, key) => dict.has(key) ? dict.get(key) : '?');
};
