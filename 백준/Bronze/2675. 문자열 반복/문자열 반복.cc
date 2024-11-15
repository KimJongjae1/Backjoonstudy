#include <stdio.h>
#include <string.h>

int main() {
	int t,r;
	char s[21];

	scanf("%d\n", &t);

	for (int i = 0; i < t; i++) {
		scanf("%d %s", &r, s);

		for (int k = 0; k < strlen(s); k++) {
			for (int q = 0; q < r; q++) {
				printf("%c", s[k]);
			}
		}printf("\n");

	}
	return 0;
}