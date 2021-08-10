import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author chenxuegui
 * @since 2021.08.04
 */
public class CommandGen {

    public static void main(String[] args) throws Exception{

        String filePath = "E://git//redis-java//src//test//resources//commandTable.txt";
        File file = new File(filePath);
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader bufferReader = new BufferedReader(read);

        String lineTXT = null;
        while ((lineTXT = bufferReader.readLine()) != null) {
            lineTXT = lineTXT.replace("{","").replace("}","").replace("NULL","null");
            String[] datas = lineTXT.split(",");
            if(datas.length>3){
                int i = 0;
                StringBuilder sb = new StringBuilder();
                sb.append(datas[i+1]).append("(").append(datas[i]).append(",");
                i+=2;
                sb.append(datas[i++]).append(",").append(datas[i++]).append(",");
                i++;
                sb.append(datas[i++]).append(",");
                sb.append(datas[i++]).append(",");
                sb.append(datas[i++]).append(",");
                sb.append(datas[i++]).append(")");

                sb.append("{ void proc(RedisClient redisClient) { }},");

                System.out.println(sb.toString());

            }

        }
    }
}
