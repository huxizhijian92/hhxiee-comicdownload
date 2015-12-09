package scanandparse;

/**
 *
 * @author wei
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ScanVol {
    public static List<String> scanVolInPage(String url,String contents){
        List<String> volList = new ArrayList<>();
        if (url.matches("(.*)hhxiee(.*)") == url.matches("(.*)hhmanhua(.*)")){
            JOptionPane.showMessageDialog(null,"无法解析!", "错误！", JOptionPane.WARNING_MESSAGE);
            volList.add("");
            return volList;
        }
        String[] website = url.split("/");
        String vol = scanVolUrl(contents);
        String[] volcut = vol.split("<li><a href=");
        for (int i = volcut.length - 1; i >= 1; i--){
            volList.add(scanVolName(volcut[i])+ ":"+ "http://" + website[2] + scanUrl(volcut[i]));
        }
        return volList;
    }
    private static String scanVolUrl(String contents){                                        //分析获取的网址，把密文PicListUrl提取出来
        String patternString=
                "ul class=\"bi\">([^\"]*)</ul><div style=\"clear: both;\">";
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(contents);
        String volList = "";
        if (matcher.find())
            volList = matcher.group(1);  
        return volList;
    }
    private static String scanUrl(String volcut){
        String patternString=
                "(/[^\"]*) target=_blank>";
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(volcut);
        String url = "";
        if (matcher.find())
            url = matcher.group(1);  
        return url;
    }
    private static String scanVolName(String volcut){
        String patternString=
                "target=_blank>([^\"]*)</a></li>";
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(volcut);
        String name = "";
        if (matcher.find())
            name = matcher.group(1);  
        return name;
    }
}
