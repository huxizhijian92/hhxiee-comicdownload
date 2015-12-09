package scanandparse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author wei
 */
public class ScanHHPic {
     public static List<String> scanPicInPage(String url,String contents){                        //获取图片网址列表
        String picListUrl=scanPicListUrl(contents);
        List<String> picList = new ArrayList<String>();
        if (picListUrl == ""){
            JOptionPane.showMessageDialog(null,"无法解析!", "错误！", JOptionPane.WARNING_MESSAGE);
            picList.add("");
            return picList;
        } 
        if (url.matches("(.*)hhxiee(.*)"))
            picList=parsePicUrl(picListUrl,"tahfcioewrm",url);
        else if (url.matches("(.*)hhmanhua(.*)"))
            picList=parsePicUrl(picListUrl,"tazsicoewrn",url);
        else
            picList.add("");
        return picList;
    }
    private static String scanPicListUrl(String contents){                                        //分析获取的网址，把密文PicListUrl提取出来
        String patternString=
                "var PicListUrl = \"([^\"]*)\"";
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(contents);
        String picList = "";
        if (matcher.find())
            picList = matcher.group(1);  
        return picList;
    }
    
    private static List<String> parsePicUrl(String picListUrl,String keyWord,String url){           //分析隐藏的图片网址,根据网站的js代码获取网址
        String[] num = url.split("s=");
        if (num.length < 2) {
            JOptionPane.showMessageDialog(null,"无法解析!", "错误！", JOptionPane.WARNING_MESSAGE);
            List<String> fail = new ArrayList<String>();
            fail.add("");
            return fail;
        }
        String number;
        if (num[1].length() == 1)
            number="0"+num[1];
        else
            number = num[1];
        String serverUrl="http://hhxiee.1112223333.com/dm" + number + "/";
        String k = keyWord.substring(0,keyWord.length()-1);
        String f = keyWord.substring(keyWord.length()-1);
        char charnum='0';
        for (int i =0;i<k.length();i++){
            picListUrl=picListUrl.replaceAll(k.substring(i,i+1), String.valueOf(charnum));
            charnum++;
        }
        String[] result = picListUrl.split(f);
        String fi="";
        for (int i = 0; i<result.length;i++){
            fi+=String.valueOf((char)(Integer.valueOf(result[i]).intValue()));
        }
        String[] jpgUrl = fi.split("\\|");
        List<String> picList = new ArrayList<String>();
        for (int i = 0; i<jpgUrl.length;i++){
            picList.add(serverUrl+jpgUrl[i]);
        }
        return picList;
    }
}
