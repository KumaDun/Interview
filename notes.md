**
笔记
*** 
double运算之前，要先cast成double
***
int 21亿会超长，转换成long， 2^31 -1
***
String判等用equals
Integer相比用intValue或者equals相比
***
用户输入用scanner获取
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建 Scanner 对象

        System.out.print("请输入一个整数: ");
        int num = scanner.nextInt(); // 读取整数

        System.out.print("请输入一个字符串: ");
        String str = scanner.next(); // 读取单词（空格分隔）

        System.out.print("请输入一行文本: ");
        String line = scanner.nextLine(); // 读取整行（包括空格）

        scanner.close(); // 关闭 Scanner（避免资源泄漏）
    }
}
```