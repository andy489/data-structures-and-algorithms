// https://leetcode.com/problems/path-crossing/

var isPathCrossing = function(path) {
    let x=0,y=0;
    const seen=new Set(['0,0']);
    const moves={'N':[0,1],'S':[0,-1],'E':[1,0],'W':[-1,0]};
    for(const c of path){
        [x,y]=[x+moves[c][0],y+moves[c][1]];
        const k=`${x},${y}`;
        if(seen.has(k))return true;
        seen.add(k);
    }
    return false;
};
