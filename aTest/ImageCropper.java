import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageCropper {
        //截图
        /* 电脑是macbook，桌面上有2个文件夹，名字是“截图1”和“截图2”。截图1中有一些png图片，大小相同，把它们做为原始图片进行如下裁剪：
    a. 原始图片右下角的顶点保持不动；
    b. 原始图片左上角的顶点沿着对角线向右下角移动，移动路程为原始图片对角线长度的0.3倍；
    c. 保存此时原始图片的剩余部分，得到了目标图片，存入截图2
*/    
    public static void main(String[] args) {
        try {
            // 读取原始图片路径
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            String inputFolderPath = desktopPath + "截图1/";
            String outputFolderPath = desktopPath + "截图2/";

            // 获取截图1文件夹中的所有png图片
            File inputFolder = new File(inputFolderPath);
            File[] inputFiles = inputFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

            // 创建截图2文件夹
            File outputFolder = new File(outputFolderPath);
            if (!outputFolder.exists()) {
                outputFolder.mkdirs();
            }

            // 循环处理每个图片
            if (inputFiles != null) {
                for (File inputFile : inputFiles) {
                    BufferedImage originalImage = ImageIO.read(inputFile);

                    // 计算左上角顶点的新坐标，原始图片的坐标：(originalImage.getMinX() ，originalImage.getMinY())
                    int newTopLeftX = (int) (originalImage.getMinX() + 0.17 *  originalImage.getWidth());
                    int newTopLeftY = (int) (originalImage.getMinY() + 0.22 * originalImage.getHeight() );

                    // 计算目标图片的宽高
                    int newWidth = (int) (0.81 * originalImage.getWidth());
                    int newHeight = (int) (0.76 * originalImage.getHeight() );

                    // 创建目标图片
                    BufferedImage targetImage = originalImage.getSubimage(newTopLeftX, newTopLeftY, newWidth, newHeight);

                    // 写入截图2文件夹
                    String outputFilePath = outputFolderPath + "cropped_" + inputFile.getName();
                    ImageIO.write(targetImage, "png", new File(outputFilePath));

                    System.out.println("处理完成：" + outputFilePath);
                }
            } else {
                System.out.println("截图1文件夹中没有png图片。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
