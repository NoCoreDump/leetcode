import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: leetcode
 * @description: test
 * @author: sunwb
 * @create: 2020-04-11 20:26
 */
public class Test {

    public static void output(String outFile, String[] res) {
        try {
            File file = new File(outFile);
            if (!file.exists()) file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String l : res) {
                bw.write(l);
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Fail: write to file!");
        }
    }

    public static void output(String outFile, int[] res) {
        try {
            File file = new File(outFile);
            if (!file.exists()) file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int n : res) {
                bw.write(String.valueOf(n) + ",");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Fail: write to file!");
        }
    }
    public static void readData(String filename) throws IOException{

        File file = new File(filename);
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] ss = line.split(",");
            System.out.println((int)ss[0].charAt(1));
        }

    }
    public static void main(String[] args) {
        String str = "你好";
        System.out.println();
        byte[] bytes = str.getBytes();
        System.out.println(bytes.toString());
        System.out.println(bytes.length);
    }
}
