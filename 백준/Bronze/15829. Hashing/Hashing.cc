#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {//a 97//int 4바이트 char가 1바이트
    char s[51];
    int L,x;
    scanf("%d", &L);
    scanf("%s", s);
    x = (int)strlen(s);
    double ans = 0;
    for (int i = 0; i < x; i++) {
        ans += (s[i] - 96) * (int)pow(31, i);
    }
    printf("%0.0f", ans);
        return 0;
}