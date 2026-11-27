// https://leetcode.com/problems/avoid-flood-in-the-city/

var avoidFlood = function(rains) {
    const n=rains.length, res=new Array(n).fill(-1);
    const full=new Map();
    const dry=[];
    for(let i=0;i<n;i++){
        if(rains[i]===0){dry.push(i);res[i]=1;}
        else{
            const lake=rains[i];
            if(full.has(lake)){
                const prevDay=full.get(lake);
                const idx=dry.findIndex(d=>d>prevDay);
                if(idx===-1)return[];
                res[dry[idx]]=lake;
                dry.splice(idx,1);
            }
            full.set(lake,i);
        }
    }
    return res;
};
