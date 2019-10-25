package jave2Test.com.hsj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;

import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

/**
 * 获取视频时长
 * @author heshengjin
 * @email:2356899074@qq.com
 */
public class VideoDuration {
	@SuppressWarnings("resource")
	public static void main(String[] args){
//		File file = new File("http://clips.vorwaerts-gmbh.de//big_buck_bunny.mp4");
//		File file = new File("E:\\BaiduNetdiskDownload\\维度 数学漫步【高清中字视频】\\维度_数学漫步_TR_证明.mkv");
//		File file = new File("D:\\BaiduNetdiskDownload\\video\\千与千寻\\千与千寻.rmvb");
		File file = new File("D:\\测试2018-07-19.mp4");
		MultimediaObject multimediaObject = new MultimediaObject(file);
		FileChannel fc= null;
		String size = "";
		try {
			MultimediaInfo m = multimediaObject.getInfo();
			long ls = m.getDuration();//毫秒
			System.out.println("此视频时长为:"+ls/1000+"秒");
			//视频帧宽高
			System.out.println("此视频高度为:"+m.getVideo().getSize().getHeight());
			System.out.println("此视频宽度为:"+m.getVideo().getSize().getWidth());
			System.out.println("此视频格式为:"+m.getFormat());
			System.out.println("此视频码率为:"+m.getVideo().getBitRate());
			System.out.println("此视频加密为:"+m.getVideo().getDecoder());
			System.out.println("此视频每帧速率为:"+m.getVideo().getFrameRate());

			
			FileInputStream fis = new FileInputStream(file);
			fc= fis.getChannel();
			BigDecimal fileSize = new BigDecimal(fc.size());
			size = fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.DOWN) + "MB";
			System.out.println("此视频大小为"+size);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (null!=fc){
				try {
					fc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}