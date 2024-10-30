#include <stdio.h>
int main() {
	int N;

	

	for (int i = 0; i < 10; i++) {
		scanf("%d", &N);
		int sum = 0;
		int height[1001] = { 0, };//N이 4일때도?  0 0  254 185 76 227 84 175 0 0
		

		for (int k = 0; k < N; k++) {
			scanf("%d", &height[k]);
		}for (int w = 2; w < N - 2; w++) {
			int min = 255;
			if (height[w] > height[w - 1] && height[w] > height[w - 2] && height[w] > height[w + 1] && height[w] > height[w + 2]) {
				for (int e = w - 2; e <= w + 2; e++) {
					if (height[w] - height[e] != 0 && (height[w] - height[e]) < min) {
						min = (height[w] - height[e]);
					}
				}sum += min;
			}
		}printf("#%d %d\n",i+1, sum);
	}
	return 0;
}