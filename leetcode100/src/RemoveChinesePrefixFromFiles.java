import java.io.File;
/*
 * 文件夹名称：D:\OLD\歌曲。该文件夹下有150个mp4文件，文件名均有类似于【P1】、【P12】的前缀
    需求：写一个java函数，去除前缀.文件名前缀中的括号都是中文的：【】，输出目录命名为：D:\OLD\output.
 */
public class RemoveChinesePrefixFromFiles {

    public static void main(String[] args) {
        // 输入文件夹路径
        String inputFolderPath = "D:\\OLD\\歌曲";
        // 输出文件夹路径
        String outputFolderPath = "D:\\OLD\\output";
        
        // 创建输入文件夹和输出文件夹对象
        File inputFolder = new File(inputFolderPath);
        File outputFolder = new File(outputFolderPath);
        
        // 检查输入文件夹是否存在且为目录
        if (inputFolder.exists() && inputFolder.isDirectory()) {
            // 创建输出文件夹，如果不存在
            if (!outputFolder.exists()) {
                outputFolder.mkdirs();
            }
            
            // 获取所有文件
            File[] files = inputFolder.listFiles();
            
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".mp4")) {
                        String oldFileName = file.getName();
                        
                        // 使用正则表达式去除中文括号前缀 "【Pn】"，其中 n 是一位或多位数字
                        String newFileName = oldFileName.replaceFirst("^【P\\d+】", "").trim();
                        
                        // 新的文件路径（放在输出文件夹中）
                        File newFile = new File(outputFolderPath + File.separator + newFileName);
                        
                        // 将文件复制到输出目录并重命名
                        if (file.renameTo(newFile)) {
                            System.out.println("Renamed and moved: " + oldFileName + " -> " + newFile.getName());
                        } else {
                            System.out.println("Failed to rename and move: " + oldFileName);
                        }
                    }
                }
            }
        } else {
            System.out.println("Input folder does not exist or is not a directory.");
        }
    }
}
