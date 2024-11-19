#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    int N, M;
    int s[101] = { 0, };
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++) {
        scanf("%d",&s[i]);
    }
    int ans = 0;
    int max = 0;
    int i=0, k=1,q;
        for(int i=0;i<N-2;i++){
            for ( k = i+1; k < N-1; k++) {
                for (q = k+1; q < N; q++) {
                    ans = s[i] + s[k] + s[q];//i=1 k=
                    if (ans <= M&&max<ans) {
                        max = ans;
                    }
                }
            }
        }
    printf("%d", max);
        return 0;
}