package liu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import liu.domain.City;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author liuqian
 * @date 2018/2/4 21:19.
 */
public class ReadJsonTest {

  private ObjectMapper objectMapper;

  /**
   * run test
   *
   * @throws IOException
   */
  @Test
  public void readJsonTest() throws IOException {
    objectMapper = getObjectMapper();
    String cityJsonContext = readFile("src/main/resources/json/city.json");
    List<City> cityList = objectMapper.readValue(cityJsonContext, new TypeReference<List<City>>() {
    });
    System.out.println("size is " + cityList.size());
    for (City city : cityList) {
      System.out.println(city.toString());
    }
  }

  /**
   * 读取json文件
   *
   * @param path
   * @return
   */
  private String readFile(String path) {
    BufferedReader reader = null;
    StringBuilder lastStr = new StringBuilder();
    try {
      FileInputStream fileInputStream = new FileInputStream(path);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
      reader = new BufferedReader(inputStreamReader);
      String tempString;
      while ((tempString = reader.readLine()) != null) {
        lastStr.append(tempString);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return lastStr.toString();
  }

  private ObjectMapper getObjectMapper() {
    if (objectMapper == null) {
      return new ObjectMapper();
    }
    return objectMapper;
  }


}
