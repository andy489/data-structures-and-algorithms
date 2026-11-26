// https://leetcode.com/problems/design-skiplist/

class Skiplist {
    constructor() {
        this.MAX_LEVEL = 16; this.P = 0.5;
        this.head = {val:-1, next:new Array(this.MAX_LEVEL).fill(null)};
    }
    _level(){ let l=1; while(Math.random()<this.P&&l<this.MAX_LEVEL)l++; return l; }
    search(target){
        let cur=this.head;
        for(let i=this.MAX_LEVEL-1;i>=0;i--) while(cur.next[i]&&cur.next[i].val<target)cur=cur.next[i];
        return cur.next[0]!==null&&cur.next[0].val===target;
    }
    add(num){
        const upd=new Array(this.MAX_LEVEL).fill(null); let cur=this.head;
        for(let i=this.MAX_LEVEL-1;i>=0;i--){while(cur.next[i]&&cur.next[i].val<num)cur=cur.next[i];upd[i]=cur;}
        const l=this._level(),node={val:num,next:new Array(l).fill(null)};
        for(let i=0;i<l;i++){node.next[i]=upd[i].next[i];upd[i].next[i]=node;}
    }
    erase(num){
        const upd=new Array(this.MAX_LEVEL).fill(null); let cur=this.head;
        for(let i=this.MAX_LEVEL-1;i>=0;i--){while(cur.next[i]&&cur.next[i].val<num)cur=cur.next[i];upd[i]=cur;}
        if(!cur.next[0]||cur.next[0].val!==num)return false;
        const t=cur.next[0];
        for(let i=0;i<this.MAX_LEVEL&&upd[i].next[i]===t;i++)upd[i].next[i]=t.next[i];
        return true;
    }
}
