#include <stdio.h>
#include <string.h>

int main() {
    int n, m;
    int a[201][101];//a[n][m] b[n][m]

    scanf("%d %d", &n, &m);
    for (int i = 0; i < 2*n; i++) {
        for (int k = 0; k < m; k++) {
            scanf("%d", &a[i][k]);
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int k = 0; k < m; k++) {
            printf("%d ", a[i][k]+a[i+n][k]);
        }printf("\n");
    }




    return 0;
}  