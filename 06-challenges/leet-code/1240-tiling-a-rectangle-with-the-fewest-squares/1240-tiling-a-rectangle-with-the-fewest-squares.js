// https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/

var tilingRectangle = function(n, m) {
    let res=n*m;
    function dfs(sky,cnt){
        if(cnt>=res)return;
        const minH=Math.min(...sky);
        if(minH===n){res=cnt;return;}
        const pos=sky.indexOf(minH);
        const maxSz=Math.min(n-minH,m-pos);
        for(let sz=maxSz;sz>=1;sz--){
            if(sky.slice(pos,pos+sz).every(h=>h===minH)){
                const bak=[...sky];
                for(let j=pos;j<pos+sz;j++)sky[j]+=sz;
                dfs(sky,cnt+1);
                sky.splice(0,sky.length,...bak);
            }
        }
    }
    dfs(new Array(m).fill(0),0);return res;
};
