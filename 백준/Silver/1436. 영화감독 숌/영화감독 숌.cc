#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
	int N;
	scanf("%d", &N);
	int ans = 665;
	int ans_num = 0;

	while (1) {//++하면서 계속 나머지가 666인지 ㅇㅇ /10하면서 
		ans++;
		int temp = ans;
		int count = 0;//초기화좀 잘하자;;

		for (int i = 0; temp > 0; i++) {//for문의 가운데는 충족 못 할때까지 진행한다.
			if (temp % 10 == 6) {//while문도 충족못할때까지.... temp=0
				count++;
			}else  {
				count = 0;
			}
			if (count ==3) {
				ans_num++;
				break;
			}
			temp /= 10;
		}
		if (ans_num == N) {
			printf("%d", ans);
			break;
		}
	}

 return 0;
}
