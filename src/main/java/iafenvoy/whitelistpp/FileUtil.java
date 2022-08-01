package iafenvoy.whitelistpp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void writeFile(String path, List<String> data) {
        try {
            FileWriter writer = new FileWriter(path);
            for (String str : data)
                writer.write(str + "\r\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String path) {
        List<String> data = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            while ((str = bf.readLine()) != null)
                data.add(str);
            bf.close();
            fr.close();
        } catch (Exception e) {
            data = new ArrayList<>();
            e.printStackTrace();
        }
        return data;
    }
}
