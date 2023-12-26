
import java.io.*;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileListWriter {

    public static void main(String[] args) {
/*          link: https://developer.apple.com/library/archive/documentation/FileManagement/Conceptual/FileSystemProgrammingGuide/FileSystemDetails/FileSystemDetails.html  
            mac默认的文件名排序规则，是中文（拼音排序），它是
            以「拼音」为基础的Unicode 排序，并在此基础上，做了以下更改：
            a. 数字子串根据其数值进行排序，而不是对数字中的实际字符进行排序。
            b. 排序时不考虑大小写。 */

/* 具体实现方法如下
对文件名的排序排两次，第一次：以「拼音」为基础的Unicode 排序。
第二次排序规则为：
a. 文件名包含中文的，不进行第二次排序
b. 从文件名的开头截取数字子串，根据其数值大小对原文件名进行排序
c. 数字子串一样的，对数字子串后面的部分做Unicode 排序，根据这个顺序对原文件名进行排序
d. 排序时不考虑大小写。 */

        // 获取用户的home目录
        String userHome = System.getProperty("user.home");

        // 构建文件夹路径和a.txt文件路径
        String folderPath = userHome + "/Desktop/英语作文";
        String outputFilePath = userHome + "/Desktop/a.txt";

        // 获取文件夹中的所有文件
        File folder = new File(folderPath);
        File[] files = folder.listFiles(file -> !file.isHidden() && !file.getName().startsWith("."));

        if (files != null) {
            // 第一次按照拼音的 Unicode 排序进行排序
            Arrays.sort(files, new PinyinComparator());

            // 第二次排序
            Arrays.sort(files, new CustomComparator());

            // 写入文件名到a.txt，每个文件名之间空两行
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (File file : files) {
                    //writer.write(file.getName() + System.lineSeparator());
                    writer.write(file.getName() + System.lineSeparator() + System.lineSeparator()+ System.lineSeparator());
                }
                System.out.println("文件名已成功写入a.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件夹中没有文件");
        }
    }

    // 第一次排序的比较器，按照拼音的 Unicode 排序
    static class PinyinComparator implements Comparator<File> {
        private Collator collator = Collator.getInstance(Locale.getDefault());

        @Override
        public int compare(File file1, File file2) {
            String name1 = file1.getName();
            String name2 = file2.getName();
            return collator.compare(name1, name2);
        }
    }

    // 第二次排序的比较器，根据规则排序
    static class CustomComparator implements Comparator<File> {
        private Pattern digitPattern = Pattern.compile("\\d+");

        @Override
        public int compare(File file1, File file2) {
            String name1 = file1.getName();
            String name2 = file2.getName();

            // 判断文件名是否包含中文
            boolean hasChinese1 = hasChinese(name1);
            boolean hasChinese2 = hasChinese(name2);

            if (hasChinese1 || hasChinese2) {
                // 如果文件名包含中文，不进行第二次排序
                return 0;
            } else {
                // 从文件名的开头截取数字子串，根据其数值大小对原文件名进行排序
                String numericSubstring1 = extractNumericSubstring(name1);
                String numericSubstring2 = extractNumericSubstring(name2);

                int numericComparison = Integer.compare(
                        Integer.parseInt(numericSubstring1), Integer.parseInt(numericSubstring2));

                if (numericComparison != 0) {
                    // 数字子串不相等，返回数值比较结果
                    return numericComparison;
                } else {
                    // 数字子串一样的，对数字子串后面的部分做 Unicode 排序
                    return name1.substring(numericSubstring1.length()).compareToIgnoreCase(
                            name2.substring(numericSubstring2.length()));
                }
            }
        }

        // 判断字符串是否包含中文
        private boolean hasChinese(String str) {
            for (char c : str.toCharArray()) {
                if (Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN) {
                    return true;
                }
            }
            return false;
        }

        // 从字符串的开头截取数字子串
        private String extractNumericSubstring(String str) {
            Matcher matcher = digitPattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            } else {
                // 如果没有数字子串，默认返回空字符串
                return "";
            }
        }
    }
}
