package Algorithm.StringAbout;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by panzhiwei on 2018/11/25.
 */
public class StringDemo {

    /**
     *
     *  查找字符串中指定字符所在字串中的索引
     */
    public static int getIndexOfStringArr(String value,String operator,int index){

        //使用正则表达式
        Matcher mat = Pattern.compile(operator).matcher(value);

        int count = 0;
        while(mat.find()){
            count ++;
            if(count == index){
                break;
            }
        }
        return mat.start();
    }


    public static void main(String[] args) throws Exception {

        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str))));

        while (str != null){
             try {
                String line = br.readLine();
                if(line != null){
                    int index = getIndexOfStringArr(str,"\"",7);
                    str = str.substring(index + 1);
                    if(str != "" && str != null){

                        //TODO:处理字符串指定元素

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}