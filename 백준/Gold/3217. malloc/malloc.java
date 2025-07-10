import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_N = 100000;
    static final int HASH_SIZE = 26 * 26 * 26 * 26;
    static int N, totalSize;

    static class Block {
        int s, size;
        Block next;

        Block(int s, int size) {
            this.s = s;
            this.size = size;
        }
    }

    static Block freeBlock = new Block(0, 0); // dummy head
    static Block[] varTable = new Block[HASH_SIZE + 10];

    public static void main(String[] args) throws Exception {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if (cmd.charAt(4) == '=') { // malloc
                int key = getKey(cmd);
                int size = getSize(cmd.substring(12));
                varTable[key] = myMalloc(size);
            } else if (cmd.charAt(4) == '(') { // free
                int key = getKey(cmd.substring(5));
                myFree(varTable[key]);
                varTable[key] = null;
            } else { // print
                int key = getKey(cmd.substring(6));
                if (varTable[key] == null) System.out.println(0);
                else System.out.println(varTable[key].s);
            }
        }
    }

    static void init() {
        freeBlock.next = new Block(1, MAX_N);
        totalSize = MAX_N;
        for (int i = 0; i <= HASH_SIZE; i++) {
            varTable[i] = null;
        }
    }

    static int getKey(String str) {
        int hash = 0;
        for (int i = 0; i < 4; i++) {
            hash = hash * 26 + (str.charAt(i) - 'a');
        }
        return hash;
    }

    static int getSize(String str) {
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('0' <= ch && ch <= '9') {
                size = size * 10 + (ch - '0');
            } else break;
        }
        return size;
    }

    static Block myMalloc(int size) {
        Block p = freeBlock;
        if (totalSize < size) return null;

        int remain = totalSize;
        while (p.next != null && remain >= size) {
            if (p.next.size == size) {
                Block allocBlock = p.next;
                p.next = allocBlock.next;
                allocBlock.next = null;
                totalSize -= size;
                return allocBlock;
            }
            if (p.next.size > size) {
                Block allocBlock = new Block(p.next.s, size);
                p.next.s += size;
                p.next.size -= size;
                totalSize -= size;
                return allocBlock;
            }
            remain -= p.next.size;
            p = p.next;
        }
        return null;
    }

    static void myFree(Block target) {
        if (target == null) return;

        Block p = freeBlock;
        totalSize += target.size;

        if (p.next == null) {
            p.next = target;
            return;
        }

        while (p.next != null) {
            if (target.s + target.size < p.next.s) {
                target.next = p.next;
                p.next = target;
                return;
            }
            p = p.next;

            if (target.s + target.size == p.s) {
                p.s = target.s;
                p.size += target.size;
                return;
            }

            if (target.s == p.s + p.size) {
                p.size += target.size;
                if (p.next != null && p.next.s == p.s + p.size) {
                    p.size += p.next.size;
                    p.next = p.next.next;
                }
                return;
            }
        }
    }
}