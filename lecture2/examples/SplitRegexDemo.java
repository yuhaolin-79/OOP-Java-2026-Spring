package examples;

import java.util.Arrays;

public class SplitRegexDemo {
    public static void main(String[] args) {
        System.out.println("=== Java String split 与正则表达式演示 ===\n");

        // 1. 基础用法：简单字符分隔
        String text1 = "apple,banana,orange,grape";
        // 正则 "," 表示匹配逗号
        String[] fruits = text1.split(",");
        printResult("简单逗号分隔", fruits);

        // 2. 多字符分隔：同时支持空格和逗号
        // 场景：用户输入格式不统一，有的用逗号，有的用空格
        String text2 = "Java,Python C++  Ruby,Golang";
        // 正则 "[,\\s]+" 解释：
        // [] 表示字符集合
        // , 表示逗号
        // \\s 表示空白字符（空格、制表符等），在 Java 字符串中需双写反斜杠
        // + 表示匹配前面的字符一次或多次（防止出现多个连续空格产生空字符串）
        String[] languages = text2.split("[,\\s]+");
        printResult("混合分隔符 (逗号或空格)", languages);

        // 3. 特殊字符转义：按点号 (.) 分割
        // 注意： "." 在正则中表示"任意字符"，所以必须转义为 "\\."
        String text3 = "www.example.com.cn";
        // 错误写法：text3.split(".") -> 会得到空数组，因为 "." 匹配了所有字符
        String[] domains = text3.split("\\."); 
        printResult("转义特殊字符 (点号)", domains);

        // 4. 复杂场景：按非数字字符分割，提取数字
        String text4 = "Order ID: 1001, Amount: 5000, Tax: 250";
        // 正则 "\\D+" 解释：
        // \\D 表示非数字字符
        // + 表示连续的非数字字符视为一个分隔符
        String[] numbers = text4.split("\\D+");
        // 注意：如果字符串以非数字开头，第一个元素通常是空字符串，需要过滤
        printResult("提取数字 (按非数字分割)", numbers);

        // 5. 限制分割次数 (limit 参数)
        String text5 = "name:John:age:25:city:NYC";
        // 只分割前 2 个冒号，剩下的部分保留在最后一个元素中
        String[] limited = text5.split(":", 3);
        printResult("限制分割次数 (limit=3)", limited);
    }

    // 辅助方法：美观地打印数组结果
    private static void printResult(String description, String[] result) {
        System.out.println("[" + description + "]");
        System.out.println("原始字符串处理后的数组: " + Arrays.toString(result));
        System.out.println("遍历输出:");
        for (int i = 0; i < result.length; i++) {
            // 过滤掉可能产生的空字符串（常见于开头就是分隔符的情况）
            if (!result[i].isEmpty()) {
                System.out.println("  [" + i + "]: \"" + result[i] + "\"");
            }
        }
        System.out.println("-------------------------\n");
    }
}

