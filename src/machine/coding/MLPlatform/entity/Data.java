package machine.coding.MLPlatform.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    3:10 AM
 */

@Setter
@Getter
@ToString
public class Data<T> {
  T data;
}
