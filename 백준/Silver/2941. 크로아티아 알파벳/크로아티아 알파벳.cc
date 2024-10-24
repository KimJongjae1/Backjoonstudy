#include <stdio.h>
#include <string.h>

char a[100];
int size=0,sum=0;

int main() {
    scanf("%s", a);

    size = strlen(a); //문자열 구하기

    for (int i = 0; i < strlen(a); i++) {
        if (a[i] == 'c' && (a[i+1] == '=' || a[i+1] == '-')) {
            size--;
        }
        else if (a[i] == 'd' && a[i + 1] == 'z' && a[i + 2] == '=') {
            size-=2;
                
        }
        else if (a[i-1] != 'd' && a[i] == 'z' && a[i + 1] == '=') {
            size--;//z를 기준으로 하기때문에 이놈은 a[i-1]로 설정
           
        }
        else if (a[i] == 'd' && a[i + 1] == '-') {
            size--;
          
        }
        else if ((a[i] == 'l' || a[i] == 'n') && a[i+1] == 'j') {
            size--;
           
        }
        else if (a[i] == 's' && a[i+1] == '=') {
            size--;
        }
        
    }
        printf("%d", size);
    return 0;
}