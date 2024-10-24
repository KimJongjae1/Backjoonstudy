#include <stdio.h>
#include <string.h>

char a[100];
int size=0,sum=0;

int main() {
    scanf("%s", a);

    size = strlen(a); //문자열 구하기

    for (int i = 0; i < size; i++) {
        if (a[i] == 'c' && (a[i+1] == '=' || a[i+1] == '-')) {
            sum++;
            i++;//c= c-
        }
        else if (a[i] == 'd' && a[i + 1] == 'z' && a[i + 2] == '=') {
            sum ++;
            i+=2;//dz= 
        }
        else if (a[i-1] != 'd' && a[i] == 'z' && a[i + 1] == '=') {
            sum++;
            i++;//z=
        }
        else if (a[i] == 'd' && a[i + 1] == '-') {
            sum++;
            i++;
        }
        else if ((a[i] == 'l' || a[i] == 'n') && a[i+1] == 'j') {
            sum++;
            i++;
        }
        else if (a[i] == 's' && a[i+1] == '=') {
            sum++;
            i++;
        }
        else sum++;
    }
        printf("%d", sum);
    return 0;
}