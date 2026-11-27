// https://leetcode.com/problems/find-duplicate-file-in-system/

var findDuplicate = function(paths) {
    const contentToFiles = new Map();
    for (const path of paths) {
        const parts = path.split(" ");
        const dir = parts[0];
        for (let i = 1; i < parts.length; i++) {
            const parenIdx = parts[i].indexOf('(');
            const fileName = parts[i].substring(0, parenIdx);
            const content = parts[i].substring(parenIdx + 1, parts[i].length - 1);
            const fullPath = dir + "/" + fileName;
            if (!contentToFiles.has(content)) contentToFiles.set(content, []);
            contentToFiles.get(content).push(fullPath);
        }
    }
    return [...contentToFiles.values()].filter(files => files.length >= 2);
};
