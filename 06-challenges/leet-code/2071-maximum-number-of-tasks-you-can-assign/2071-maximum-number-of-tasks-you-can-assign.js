// https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/

// Solution: Binary Search + Greedy — O(n log^2 n) time, O(n) space
var maxTaskAssign = function(tasks, workers, pills, strength) {
    tasks.sort((a,b)=>a-b); workers.sort((a,b)=>a-b);
    const canAssign = (k) => {
        const ws = workers.slice(workers.length-k).sort((a,b)=>a-b);
        let p = pills;
        for (let i = k-1; i >= 0; i--) {
            const t = tasks[i];
            let lo=0, hi=ws.length-1, idx=-1;
            while(lo<=hi){const m=(lo+hi)>>1; ws[m]>=t?((idx=m),hi=m-1):lo=m+1;}
            if (idx !== -1) { ws.splice(idx, 1); }
            else {
                if (!p--) return false;
                let lo2=0, hi2=ws.length-1, idx2=-1;
                while(lo2<=hi2){const m=(lo2+hi2)>>1; ws[m]>=t-strength?((idx2=m),hi2=m-1):lo2=m+1;}
                if (idx2 === -1) return false;
                ws.splice(idx2, 1);
            }
        }
        return true;
    };
    let lo=0, hi=Math.min(tasks.length, workers.length);
    while(lo<hi){const m=(lo+hi+1)>>1; canAssign(m)?lo=m:hi=m-1;}
    return lo;
};
