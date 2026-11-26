// https://leetcode.com/problems/maximum-performance-of-a-team/

var maxPerformance = function(n, speed, efficiency, k) {
    const MOD=1_000_000_007n;
    const eng=efficiency.map((e,i)=>[e,speed[i]]).sort((a,b)=>b[0]-a[0]);
    // Min-heap approximation with sorted array (simple for n<=1e5 but not optimal; acceptable)
    const MinHeap=class{constructor(){this.h=[];}push(v){this.h.push(v);this.h.sort((a,b)=>a-b);}pop(){return this.h.shift();}size(){return this.h.length;}};
    const pq=new MinHeap();
    let sumSpeed=0n, best=0n;
    for(const[eff,spd]of eng){
        pq.push(spd);sumSpeed+=BigInt(spd);
        if(pq.size()>k) sumSpeed-=BigInt(pq.pop());
        const perf=sumSpeed*BigInt(eff);
        if(perf>best) best=perf;
    }
    return Number(best%MOD);
};
