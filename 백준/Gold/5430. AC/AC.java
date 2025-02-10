import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Loop:
        for (int i = 0; i < T; i++) {
            String commands = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String arrayInput = br.readLine();
            
            // 빈 배열 예외 처리
            if (num == 0) {
                if (commands.contains("D")) {
                    System.out.println("error");
                } else {
                    System.out.println("[]");
                }
                continue;
            }

            // 덱(Deque) 사용
            Deque<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(arrayInput, "[,]", false);
            for (int k = 0; k < num; k++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            // 뒤집기 여부 확인
            boolean reversed = false;
            for (char command : commands.toCharArray()) {
                if (command == 'R') {
                    reversed = !reversed;
                } else { // 'D' 명령어
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        continue Loop;
                    }
                    if (reversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            // 출력 포맷 맞추기
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(reversed ? deque.pollLast() : deque.pollFirst());
                if (!deque.isEmpty()) sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}