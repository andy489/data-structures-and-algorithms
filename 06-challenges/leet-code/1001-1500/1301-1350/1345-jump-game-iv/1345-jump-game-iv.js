// https://leetcode.com/problems/jump-game-iv/

var minJumps = function(arr) {
    const n=arr.length;
    if(n===1) return 0;
    const same=new Map();
    for(let i=0;i<n;i++){if(!same.has(arr[i]))same.set(arr[i],[]);same.get(arr[i]).push(i);}
    const visited=new Set([0]);
    let q=[0], steps=0;
    while(q.length){
        steps++;
        const next=[];
        for(const cur of q){
            const candidates=[cur-1,cur+1,...(same.get(arr[cur])||[])];
            same.delete(arr[cur]);
            for(const nxt of candidates){
                if(nxt===n-1) return steps;
                if(nxt>=0&&nxt<n&&!visited.has(nxt)){visited.add(nxt);next.push(nxt);}
            }
        }
        q=next;
    }
    return steps;
};
