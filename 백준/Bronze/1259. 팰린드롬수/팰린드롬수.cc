#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    char s[6];
    
    while (1) {
        scanf("%s", s);
        int x = strlen(s);
        int count = 0;
        if (x == 1 && s[0] == '0') { break; }
        for (int i = 0; i < x; i++) {///5--- s[0]-s[4] s[1]-s[3] s[2]-s[2] s[3]-s[1] s[4]-s[0] 4--s[0]-s[3] s[1]-s[2] s[2]-s[1]
            if (s[i] == s[x - 1 - i])
                count++;
        }if (count == x) { printf("yes\n"); }
        else { printf("no\n"); }
    }


  
        return 0;
}