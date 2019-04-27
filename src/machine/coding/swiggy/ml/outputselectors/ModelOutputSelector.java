package machine.coding.swiggy.ml.outputselectors;

import machine.coding.swiggy.ml.entity.ModelResult;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/04/19
 * Time:    6:18 PM
 */

public interface ModelOutputSelector {
  ModelResult selectBestOutput(List<ModelResult> results);
}
