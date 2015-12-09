package scanandparse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author wei
 */
public class ParseName {                                                                    //分析该地址的漫画名和第几集
    public static List<String> ParseHHFileName(String contents){
        String patternString=
                "title>([^\"]*)title";
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(contents);
        //String result = "";
        //String[] splitResult = result.split(" ");        
        List<String> picName = new ArrayList<String>(); 
        String result = "";
        if (matcher.find()){
            result = matcher.group(1);
        }   
        String[] parseResult = result.split(" ");
        for (String i : parseResult){
            picName.add(i);
        }
        return picName;
    }
}
