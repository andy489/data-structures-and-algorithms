// https://leetcode.com/problems/making-file-names-unique/

var getFolderNames = function(names) {
    const cloned = new Map(), res = [];
    for (const name of names) {
        if (!cloned.has(name)) { res.push(name); cloned.set(name, 1); }
        else {
            let k = cloned.get(name);
            while (cloned.has(`${name}(${k})`)) k++;
            const newName = `${name}(${k})`;
            res.push(newName);
            cloned.set(name, k+1);
            cloned.set(newName, 1);
        }
    }
    return res;
};
