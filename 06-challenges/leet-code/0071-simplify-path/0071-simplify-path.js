// https://leetcode.com/problems/simplify-path/

var simplifyPath = function(path) {
    const stack = [];
    for (const component of path.split('/')) {
        if (!component || component === '.') continue;
        if (component === '..') {
            if (stack.length > 0) stack.pop();
        } else {
            stack.push(component);
        }
    }
    return '/' + stack.join('/');
};
