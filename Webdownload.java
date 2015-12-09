package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author wei
 */
public class Webdownload {
    public static String startDownload(String url,String charCode) {                // 开始获取网页内容，处理错误
       String contents= "";
       try{
           URL geturl = getURL(url);
           contents = getContents(geturl,charCode);
       } catch (MalformedURLException e){
           contents = "URL构造错误！";
           JOptionPane.showMessageDialog(null,"URL构造错误!", "错误！", JOptionPane.WARNING_MESSAGE);
       } catch (IOException e){
           contents = "IO读取错误！";
           JOptionPane.showMessageDialog(null,"IO读取错误!", "错误！", JOptionPane.WARNING_MESSAGE);
       } finally{
           return contents;
       }
    }
    
   
    private static URL getURL(String url) throws MalformedURLException{
       return new URL(url);
   }
    
    private static String getContents(URL url,String charCode) throws IOException{    //获取网页内容函数
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
        InputStreamReader stream = new InputStreamReader(httpConn  
            .getInputStream(), charCode);  
        BufferedReader in = new BufferedReader(stream);
         StringBuilder sb = new StringBuilder(); 
        String line;
        while ((line = in.readLine()) != null){
            sb.append(line+"\n");
        }
        in.close();
        return sb.toString();
    }
}
