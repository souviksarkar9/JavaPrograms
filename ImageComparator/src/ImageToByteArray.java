import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageToByteArray {

	private static File[] listfiles(String targetDir) {
		File dir = new File(targetDir);
		return dir.listFiles();
	}
	
	private static byte[]  getByteImage(File f) {
		byte[] img = null;
		if (f.isFile()) {
			BufferedImage bImage = null;
			try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
				bImage = ImageIO.read(f);
				if (bImage != null) {
					ImageIO.write(bImage, "jpg", bos);
					img = bos.toByteArray();
					return img;
				} else {
					System.out.println(f.getName() + " is not an image file");
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				return img;
			} finally {
				if (bImage != null)
					bImage.flush();
			}
		}
		return img;
	}

	public static void main(String args[]) throws Exception {		
		String targetDir = "./images";
		List<byte[]> imgList = new ArrayList<>();
		for (File f : listfiles(targetDir)) 
			imgList.add(getByteImage(f));
		System.out.println(compareImage(imgList));
	}

	private static boolean compareImage(List<byte[]> imgList) {
		return Arrays.equals(imgList.get(1), imgList.get(2));
	}
}