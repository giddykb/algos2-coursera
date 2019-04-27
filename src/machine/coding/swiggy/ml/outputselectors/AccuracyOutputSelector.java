package machine.coding.swiggy.ml.outputselectors;

import machine.coding.swiggy.ml.entity.ModelResult;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:19 PM
 */
public class AccuracyOutputSelector implements ModelOutputSelector {
  @Override
  public ModelResult selectBestOutput(List<ModelResult> results) {
    results.sort(((o1, o2) -> o2.getAccuracy() - o1.getAccuracy()));
    return results.get(0);
  }
}
