#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	char a[9], b[9] , c[9] ;

	scanf("%s", a);
	scanf("%s", b);
	scanf("%s", c);
	//9 10 11
	int x = strlen(a);
	int y = strlen(b);
	int z = strlen(c);
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		if (a[0] != (i + '0')) { continue; }
		else if (a[0] == (i+'0')) {
			for (int k = 0; k < x; k++) {//2
				sum += (a[k] - '0') * (int)pow(10, x - 1 - k); //1-0
			}
			if ((sum + 3) % 3 == 0 && (sum + 3) % 5 == 0) {
				printf("FizzBuzz");
			}
			else if ((sum + 3) % 3 == 0 && (sum + 3) % 5 != 0) {
				printf("Fizz");
			}
			else if ((sum + 3) % 3 != 0 && (sum + 3) % 5 == 0) {
				printf("Buzz");
			}
			else { printf("%d", sum+3); }
			return 0;
		}
	}
	sum = 0;
	for (int i = 0; i < 10; i++) {
		if (b[0] != (i + '0')) { continue; }
		else if (b[0] == (i + '0')) {
			for (int k = 0; k < y; k++) {//2
				sum += (b[k] - '0') * (int)pow(10, y - 1 - k); //1-0
			}
			if ((sum + 2) % 3 == 0 && (sum + 2) % 5 == 0) {
				printf("FizzBuzz");
			}
			else if ((sum + 2) % 3 == 0 && (sum + 2) % 5 != 0) {
				printf("Fizz");
			}
			else if ((sum + 2) % 3 != 0 && (sum + 2) % 5 == 0) {
				printf("Buzz");
			}
			else { printf("%d", sum+2); }
			return 0;
		}
	}
	sum = 0;
	for (int i = 0; i < 10; i++) {
		if (c[0] != (i + '0')) { continue; }
		else if (c[0] == (i + '0')) {
			for (int k = 0; k < z; k++) {//2
				sum += (c[k] - '0') * (int)pow(10, z - 1 - k); //1-0
			}
			if ((sum + 1) % 3 == 0 && (sum + 1) % 5 == 0) {
				printf("FizzBuzz");
			}
			else if ((sum + 1) % 3 == 0 && (sum + 1) % 5 != 0) {
				printf("Fizz");
			}
			else if ((sum + 1) % 3 != 0 && (sum + 1) % 5 == 0) {
				printf("Buzz");
			}
			else { printf("%d", sum+1); }
			return 0;
		}
	}



 return 0;
}
