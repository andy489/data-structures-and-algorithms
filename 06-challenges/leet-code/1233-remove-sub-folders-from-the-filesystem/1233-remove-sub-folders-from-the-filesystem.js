// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

var removeSubfolders = function(folder) {
    folder.sort(); const res=[]; let last='';
    for(const f of folder){
        if(!last||!f.startsWith(last+'/')){res.push(f);last=f;}
    }
    return res;
};
