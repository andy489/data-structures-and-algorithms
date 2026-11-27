// https://leetcode.com/problems/goal-parser-interpretation/

var interpret = function(command) {
    return command.replace(/\(\)/g, 'o').replace(/\(al\)/g, 'al');
};
