# https://leetcode.com/problems/transpose-file/

# Solution 1: awk — column accumulation — O(n*m) time, O(n*m) space
awk '{
    for (j = 1; j <= NF; j++) {
        if (NR == 1) col[j] = $j
        else col[j] = col[j] " " $j
    }
    cols = NF
}
END {
    for (j = 1; j <= cols; j++) print col[j]
}' file.txt

# Solution 2: awk with printf (no leading/trailing space) — O(n*m) time, O(n*m) space
awk '{
    for (j = 1; j <= NF; j++) {
        if (NR == 1) {
            col[j] = $j
        } else {
            col[j] = col[j] " " $j
        }
    }
    cols = NF
}
END {
    for (j = 1; j <= cols; j++) {
        print col[j]
    }
}' file.txt

# Solution 3: paste columns extracted by awk — O(n*m) time, O(n*m) space
cols=$(awk 'NR==1{print NF}' file.txt)
paste -d' ' $(for i in $(seq 1 $cols); do awk -v col=$i '{print $col}' file.txt | tr '\n' ' ' | sed 's/ $//' | awk '{print}' && echo; done) 2>/dev/null ||
awk 'NR==1{n=NF} {for(j=1;j<=n;j++) a[j][NR]=$j} END{for(j=1;j<=n;j++){for(i=1;i<=NR;i++) printf "%s%s",a[j][i],(i<NR?" ":"\n")}}' file.txt
