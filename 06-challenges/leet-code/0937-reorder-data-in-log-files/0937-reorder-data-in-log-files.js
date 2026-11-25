// https://leetcode.com/problems/reorder-data-in-log-files/

var reorderLogFiles = function(logs) {
    const letters = [], digits = [];
    for (const log of logs) {
        const space = log.indexOf(' ');
        if (/\d/.test(log[space + 1])) digits.push(log);
        else letters.push(log);
    }
    letters.sort((a, b) => {
        const ia = a.indexOf(' '), ib = b.indexOf(' ');
        const ca = a.slice(ia+1), cb = b.slice(ib+1);
        return ca !== cb ? ca.localeCompare(cb) : a.slice(0,ia).localeCompare(b.slice(0,ib));
    });
    return [...letters, ...digits];
};
