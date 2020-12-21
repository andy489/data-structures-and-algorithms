void dfs(int u = 1) {
        for (int i = 1; i <= states; ++i)
            adj[par[i]].push_back(i); // adj list for suff tree
        int j(1);
        queue<int> Q;
        Q.push(u);
        int SZ = Q.size();
        while (!Q.empty()) {
            while (SZ--) {
                int cur = Q.front();
                Q.pop();
                c[j++] = cur;
                for (const int child: adj[cur])
                    Q.push(child);
            }
            SZ=Q.size();
        }
        for (int i = states; i ; --i)
            cnt[par[c[i]]]+=cnt[c[i]];
   }
