// https://leetcode.com/problems/remove-comments/

var removeComments = function(source) {
    const result = [];
    let buf = '';
    let inBlock = false;
    for (const line of source) {
        let i = 0;
        if (!inBlock) buf = '';
        while (i < line.length) {
            if (inBlock) {
                if (line[i] === '*' && line[i+1] === '/') {
                    inBlock = false;
                    i += 2;
                } else {
                    i++;
                }
            } else {
                if (line[i] === '/' && line[i+1] === '/') {
                    break;
                } else if (line[i] === '/' && line[i+1] === '*') {
                    inBlock = true;
                    i += 2;
                } else {
                    buf += line[i];
                    i++;
                }
            }
        }
        if (!inBlock && buf.length > 0) result.push(buf);
    }
    return result;
};
