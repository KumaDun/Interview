package recursion;

import java.util.*;

public class Strobogrammatic {
    public HashMap<Character, Character> stroboPairs = new HashMap<>();
    public List<String> results = new LinkedList<>();

    public char[] keys = new char[] {'0', '1', '6', '8', '9'};

    public char[] selfStroboKeys = new char[] {'0', '1', '8'};

    public List<String> findStrobogrammatic(int n) {
        if (n == 0) {
            return this.results;
        }

        this.stroboPairs.put('1', '1');
        this.stroboPairs.put('0', '0');
        this.stroboPairs.put('6', '9');
        this.stroboPairs.put('9', '6');
        this.stroboPairs.put('8', '8');

        int filledLength = 0;
        if (n % 2 == 1) {
            this.dfs(0, new char[n], true);
        } else {
            char[] currentNum = new char[n + 1];
            int mid = (n+1)/ 2;
            currentNum[mid] = '0';
            this.dfs(1, currentNum, false);
        }
        return this.results;
    }

    public void dfs(int filledLength, char[] currentNum, boolean isOdd) {
        int n = currentNum.length;
        if (filledLength == n) {
            if (currentNum[0] == '0' && n != 1) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            System.out.println("find result " + Arrays.toString(currentNum));
            for (int i = 0; i < n; i++) {
                if (isOdd || i != n / 2) {
                    sb.append(currentNum[i]);
                }
            }
            System.out.println("find result " + sb.toString());
            this.results.add(sb.toString());
            return;
        }
        int mid = n / 2;
        int leftIdx = mid - (filledLength + 1) / 2;
        int rightIdx = mid + (filledLength + 1) / 2;
        char[] availableKeys = new char[]{};
        if (leftIdx == rightIdx) {
            availableKeys = this.selfStroboKeys;
        } else {
            availableKeys = this.keys;
        }
        for (char key: availableKeys) {
            char[] newNum = Arrays.copyOf(currentNum, n);
            System.out.println("length " + n + " left: " + leftIdx + ", right: " + rightIdx + ", key: " + key);
            newNum[leftIdx] = key;
            newNum[rightIdx] = this.stroboPairs.get(key);
            int newFilledLength = leftIdx == rightIdx ? filledLength + 1 : filledLength + 2;
            this.dfs(newFilledLength, newNum, isOdd);
        }
    }

    public static void main(String[] args) {
        Strobogrammatic strobo = new Strobogrammatic();
        strobo.findStrobogrammatic(2);
    }
}
