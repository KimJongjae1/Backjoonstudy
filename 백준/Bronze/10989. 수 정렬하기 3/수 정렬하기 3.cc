#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {//4바이트-
    int N,c;
    int b[10002] = { 0, };
    scanf("%d", &N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &c);
        b[c]++;//++가 들어가면 항상 초기화필요
    }
  
    for (int i = 1; i <= 10000; i++) {
         if (b[i] > 0) {
            for (int k = 0; k < b[i]; k++) {
                printf("%d\n", i);
            }
         }
    }
 return 0;
}