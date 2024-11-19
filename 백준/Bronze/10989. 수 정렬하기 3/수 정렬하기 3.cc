#include <stdio.h>
#include <string.h>

int main() {
    int N, c;
    int b[10001] = { 0 };  // 배열 크기를 10001로 수정
    scanf("%d", &N);

    // 입력 값에 대해 등장 횟수를 카운트
    for (int i = 0; i < N; i++) {
        scanf("%d", &c);
        b[c]++;  // 각 숫자 c의 등장 횟수를 카운트
    }

    // 출력: 오름차순으로 숫자 출력
    for (int i = 1; i <= 10000; i++) {  // 1부터 10000까지 출력
        if (b[i] > 0) {  // 숫자 i가 등장했다면
            for (int k = 0; k < b[i]; k++) {  // 해당 숫자만큼 출력
                printf("%d\n", i);
            }
        }
    }
    
    return 0;
}