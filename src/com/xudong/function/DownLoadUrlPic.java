package com.xudong.function;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;


public class DownLoadUrlPic {

	@Test
	public void downLoadUrlPic() throws URISyntaxException, ClientProtocolException, IOException{
		/**
		 * 下载网络图片
		 *	 		
		 */
		
		String picUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526989579472&di=030b2be68528af3960f36addc96470e9&imgtype=0&src=http%3A%2F%2Fs9.rr.itc.cn%2Fr%2FwapChange%2F20176_2_22%2Fa7ugea4796940846619.jpg";
		String path = "D:/Work/MyJava/Project/TestJavaProject/src/com/xudong/function";
		//如果文件夹不存在则创建    
		File file =new File(path);    
		if(!file.exists() && !file.isDirectory()){       
			file.mkdirs();    
		}
		
		//生成流1.0
		CloseableHttpClient httpClient = HttpClients.custom().build();
		HttpGet get = new HttpGet();
		get.setURI(new URI(picUrl));//下载的图片路径
		CloseableHttpResponse response = httpClient.execute(get);
		InputStream in = response.getEntity().getContent();
		
		//实际文件名
		String fileName = UUID.randomUUID().toString();;
		//实际生成文件目录
		String uploadUrl_file = path.concat("/").concat(fileName + ".jpg");
		File fileSource = new File(uploadUrl_file);
		
		byte [] b = new byte[1024];
		int length = 0;
		int allLength = 0;//总大小
		try(FileOutputStream out = new FileOutputStream(fileSource)){
			//创建文件
            while((length=in.read(b))!=-1){
				out.write(b,0,length);
				allLength+=length;
			}
            
            //创建缩略图
            this.autoCreatePicView(fileSource, fileName);
		}catch(Exception e){
//			log.error("报单平台附件下载上传失败！", e);
		}finally{
			try{
				in.close();
			}catch (Exception e){}
			try{
//				com.microcredit.utils.HttpClientUtil.relaseReponse();
			}catch (Exception e){}
			
		}
		
	}
	
	public static void autoCreatePicView(File imageFile,String fileUUID){
		 String suffix = StringUtils.substringAfterLast(imageFile.getName(), ".").toLowerCase();
		 if("png".equals(suffix) || "jpeg".equals(suffix) || "jpg".equals(suffix) 
					 || "bmp".equals(suffix) || "gif".equals(suffix)){
			 try{
				 String path = imageFile.getParent()+ File.separator+fileUUID+"_50."+suffix;
				 zoomImageScale(imageFile,path , 200);
			 }catch(Exception e){
				 
			 }
		 }
	}
	
	public static void zoomImageScale(File imageFile, String newPath, int newWidth) throws IOException {
        if(!imageFile.canRead())
            return;
       BufferedImage bufferedImage = ImageIO.read(imageFile);
       if (null == bufferedImage) 
           return;
       
       int originalWidth = bufferedImage.getWidth();
       int originalHeight = bufferedImage.getHeight();
       double scale = (double)originalWidth / (double)newWidth;    // 缩放的比例
       
       int newHeight =  (int)(originalHeight / scale);

       zoomImageUtils(imageFile, newPath, bufferedImage, newWidth, newHeight);
   }
	
   private static void zoomImageUtils(File imageFile, String newPath, BufferedImage bufferedImage, int width, int height)
           throws IOException{
       
        String suffix = StringUtils.substringAfterLast(imageFile.getName(), ".");
       
        // 处理 png 背景变黑的问题
       if(suffix != null && (suffix.trim().toLowerCase().endsWith("png") || suffix.trim().toLowerCase().endsWith("gif"))){
           BufferedImage to= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
           Graphics2D g2d = to.createGraphics(); 
           to = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT); 
           g2d.dispose(); 
           
           g2d = to.createGraphics(); 
           Image from = bufferedImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING); 
           g2d.drawImage(from, 0, 0, null);
           g2d.dispose(); 
           
           ImageIO.write(to, suffix, new File(newPath));
       }else{
           // 高质量压缩，其实对清晰度而言没有太多的帮助
//           BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//           tag.getGraphics().drawImage(bufferedImage, 0, 0, width, height, null);
//
//           FileOutputStream out = new FileOutputStream(newPath);    // 将图片写入 newPath
//           JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//           JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//           jep.setQuality(1f, true);    //压缩质量, 1 是最高值
//           encoder.encode(tag, jep);
//           out.close();
           
           BufferedImage newImage = new BufferedImage(width, height, bufferedImage.getType());
           Graphics g = newImage.getGraphics();
           g.drawImage(bufferedImage, 0, 0, width, height, null);
           g.dispose();
           ImageIO.write(newImage, suffix, new File(newPath));
       }
   }
}
