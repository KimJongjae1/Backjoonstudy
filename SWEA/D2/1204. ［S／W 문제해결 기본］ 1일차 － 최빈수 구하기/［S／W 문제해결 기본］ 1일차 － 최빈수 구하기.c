#include <stdio.h>
int main() {
	int T, score[1001], test_num;



	scanf("%d", &T);



	for (int i = 0; i < T; i++) {
		scanf("%d", &test_num);;
		int max = 0; 
		int ans = 0;
		int score_num[102] = { 0, };
		for (int k = 0; k < 1000; k++) {
			scanf("%d", &score[k]);
				score_num[score[k]]++;
		}for (int q = 0; q < 101; q++) {
			if (max <= score_num[q]) {
				max = score_num[q];
				ans = q;
			}
		}printf("#%d %d\n",i+1, ans);
	}
	return 0;
}