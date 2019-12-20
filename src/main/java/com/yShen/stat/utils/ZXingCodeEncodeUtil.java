package com.yShen.stat.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.EnumMap;

import javax.imageio.ImageIO;


public class ZXingCodeEncodeUtil {

	// 二维码颜色
	private static final int BLACK = 0xFF000000;

	// 二维码背景颜色
	private static final int WHITE = 0xFFFFFFFF;
	// 二维码格式参数
	private static final EnumMap<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);

	static {
		/*
		 * 二维码的纠错级别(排错率),4个级别： L (7%)、 M (15%)、 Q (25%)、 H (30%)(最高H)
		 * 纠错信息同样存储在二维码中，纠错级别越高，纠错信息占用的空间越多，那么能存储的有用讯息就越少；共有四级； 选择M，扫描速度快。
		 */
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 二维码边界空白大小 1,2,3,4 (4为默认,最大)
		hints.put(EncodeHintType.MARGIN, 1);
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");//设置放入的字符的编码
	}




	/**
	 * 创建一个二维码保存到d盘
	 */
	public static BufferedImage createZXingCodeSaveToDpan(String content, int width, int height, String path, String imageType) {
		//
		try {
			BitMatrix encode = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);

			// 得到二维码的宽度
			int code_width = encode.getWidth();
			// 得到二维码的高度
			int code_height = encode.getHeight();

			// 创建一张图片
			BufferedImage bufferedImage = new BufferedImage(code_width, code_height, BufferedImage.TYPE_INT_RGB);
			// 向图片中添加内容
			for(int i = 0; i < code_width; i++) {
				for(int j = 0; j < code_height; j++) {
					bufferedImage.setRGB(i, j, encode.get(i, j)?BLACK:WHITE);
				}
			}
			File file = new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
			ImageIO.write(bufferedImage, imageType, file);
			// 将图片保存在d盘

			System.out.println("二维码生成成功");
			return bufferedImage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}



	/**
	 * 创建一个带LOGO的二维码
	 */
	public static void createZXingCodeWithLogoSaveToDpan(String content, int width, int height, String path, String imageType,InputStream logoStream) {
		try {
			// 获得二维码
			BufferedImage codeNormal  = createZXingCodeSaveToDpan(content, width, height, path, imageType);
			if(null != codeNormal) {
				if(null != logoStream) {
					// 获得二维码的宽高
					int code_width = codeNormal.getWidth();
					int code_height = codeNormal.getHeight();
					// 获得图片的宽高
					BufferedImage image = ImageIO.read(logoStream);
					int image_width = image.getWidth();
					int image_height = image.getHeight();
					// 计算初始坐标
					int x = (code_width - image_width) / 2;
					int y = (code_height - image_height) / 2;

					// 计算应画在二维码上的宽高
					int code_logo_width = ((code_width)/5) < image_width ? ((code_width)/5) : image_width;
					int code_logo_height = ((code_height)/5) < image_height ?  ((code_height)/5) : image_height;

					// 定义画笔

					Graphics2D graphics = codeNormal.createGraphics();
					graphics.setStroke(new BasicStroke(2));
					// 在二维码上画出图片
					graphics.drawImage(image, x, y, code_logo_width, code_logo_height, null);
					// 让画上去的内容生效
					graphics.dispose();
					// 将二维码保存到d盘

					File file = new File(path);
					if(!file.exists()) {
						file.createNewFile();
					}
					ImageIO.write(codeNormal, imageType, file);
				}
			}else {
				System.out.println("二维码生成失败");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		InputStream logoStream = ZXingCodeEncodeUtil.class.getClassLoader().getResourceAsStream("logo.jpg");
////		createZXingCodeSaveToDpan("一脸正经", 400, 400, "F://一脸正经.gif", "JPEG");
//		createZXingCodeWithLogoSaveToDpan("一脸正经", 400, 400, "F://一脸正经.gif", "JPEG", logoStream);
//	}

}
