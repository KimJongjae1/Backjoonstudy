#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    int T;
    
    scanf("%d", &T);

    for (int i = 0; i < T; i++) {
        char score[80] = { 0, };//48이다 0이 아님
        int lenght, sum = 0,count=0;
        scanf("%s", score);
        lenght = strlen(score);
        for (int k = 0; k < lenght; k++) {
            if (score[k] == 'O') {
                count++;
                sum += count;
            }
            else {
                count = 0;
            }
        }printf("%d\n", sum);
        
    }
        return 0;
}