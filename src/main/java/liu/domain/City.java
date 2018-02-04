package liu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuqian
 * @date 2018/2/4 21:15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
  /**
   * 城市id
   */
  private Integer id;
  /**
   * 城市名称
   */
  private String name;
  /**
   * 城市区号
   */
  private String areaCode;
  /**
   * 省份id
   */
  private Integer provinceId;
  /**
   * 是否为省会城市
   */
  private Boolean isCapital;
  /**
   * 城市首字母
   */
  private String initial;

  @Override
  public String toString() {
    return "City: id is " + id + "; name is " + name + "; initial is " + initial + ".";
  }

}
