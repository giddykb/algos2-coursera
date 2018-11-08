package consistent.hashing;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/10/18
 * Time:    12:04 AM
 */
public interface HashFunction {

  long hash(String key);
}
