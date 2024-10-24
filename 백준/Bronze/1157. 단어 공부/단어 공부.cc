#include <stdio.h>
#include <string.h>
char a[1000001];
int arr[27];

int main() {
	int max = 0;
	char ans;
	
	
	scanf("%s", a);
	int size = strlen(a);

	for (int i = 0; i < size; i++) {
		if (a[i] >= 'a') arr[a[i] - 'a']++;
		else arr[a[i] - 'A']++;
	}
	
	for (int i = 0; i < 26; i++) {
		if (max < arr[i]) { max = arr[i]; ans = 'A' + i; }
		else if (max == arr[i]) ans = '?';
	}
	printf("%c", ans);

	return 0;

}