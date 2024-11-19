#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    int A, B, V, x;
    int ans = 0;
    scanf("%d %d %d", &A, &B, &V);
    if (A > B) {//A=100 B=99 V=1000000000
        ans = (V - A) / (A - B);//99999999900 1
        if ((V - A) % (A - B) > 0) {//
            ans += 2;
        }
        else { ans++; }
        printf("%d", ans);
    }
    else { printf("1");  }

 return 0;
}