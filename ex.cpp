void counting() {
        int i(0);
        for (i = 1; i <= states; ++i) ++c[len[i]];
        for (i = 1; i <= states; ++i)c[i] += c[i - 1];
        for (i = states; i; --i) a[c[len[i]]--] = i;
        for (i = states; i; --i) cnt[par[a[i]]] += cnt[a[i]];
    }
