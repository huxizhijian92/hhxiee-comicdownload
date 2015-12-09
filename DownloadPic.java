package downloadhhpic;

import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.net.HttpURLConnection;  
import java.net.MalformedURLException;
import java.net.URL; 
import javax.swing.JOptionPane;

/**
 *
 * @author wei
 */
public class DownloadPic {
    public static boolean Download(String jpgUrl,String comicVol,String page,String savePath){
        File makeFile = new File(savePath + "\\" + comicVol + "\\");
        if (makeFile.exists() == false)
            makeFile.mkdirs();
        savePath = savePath + "\\" + comicVol + "\\" + page;
        makeFile = new File(savePath);
        if (makeFile.exists())
            return true;
        try {
        URL url = new URL(jpgUrl);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        InputStream inputStream = conn.getInputStream();   //通过输入流获得图片数据  
        byte[] getData = readInputStream(inputStream);     //获得图片的二进制数据  
        File imageFile = new File(savePath);
        FileOutputStream fos = new FileOutputStream(imageFile);     
        fos.write(getData);  
        fos.close(); 
        } catch (MalformedURLException e){
           JOptionPane.showMessageDialog(null,"URL构造错误!", "错误！", JOptionPane.WARNING_MESSAGE);
           return false;
       } catch (IOException e){
           JOptionPane.showMessageDialog(null,"IO读取错误!", "错误！", JOptionPane.WARNING_MESSAGE);
           return false;
       }
        return true;
    }
        
    
     private static  byte[] readInputStream(InputStream inputStream) throws IOException,MalformedURLException {  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        while((len = inputStream.read(buffer)) != -1) {  
            bos.write(buffer, 0, len);  
        }  
          
        bos.close();  
        return bos.toByteArray();  
    }  
