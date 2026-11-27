// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

var maxLength = function(arr) {
    const masks=[];
    for(const s of arr){
        let m=0,dup=false;
        for(const c of s){const b=1<<(c.charCodeAt(0)-97);if(m&b){dup=true;break;}m|=b;}
        if(!dup)masks.push(m);
    }
    let dp=[0],res=0;
    for(const m of masks){
        const nw=[];
        for(const d of dp) if(!(d&m)){nw.push(d|m);res=Math.max(res,(d|m).toString(2).split('1').length-1);}
        dp=dp.concat(nw);
    }
    return res;
};
