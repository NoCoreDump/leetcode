import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


/**
 * @program: leetcode
 * @description: test
 * @author: sunwb
 * @create: 2020-04-11 20:26
 */
public class Test {

    public static void main(String[] args) {
        String urlStr = "http://www.baidu.com";
        try {
            URL url = new URL(urlStr);
            InputStream is = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
