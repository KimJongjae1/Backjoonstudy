#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    int N;
    int s[101];
    

    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &s[i]);
    }
    int ans = 0;
    for (int i = 0; i < N; i++) {
        int t = 0;
        int count = 0;
        for (int k = 1; k <= s[i]; k++) { 
            t = s[i] % k;
            if (t > 0) { count++; }
        }if (count == (s[i] - 2)) { ans++; }
    }
    printf("%d", ans);

        return 0;
}