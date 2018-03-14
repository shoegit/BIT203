
package agn;

import java.util.Comparator;

/**
 * A comparator to compare contributions by value
 * @author ngsm
 */
public class ValueComparator implements Comparator<Contribution> {

    /** 
     * Compares contributions by value
     * @param t
     * @param t1
     * @return 
     */
    @Override
    public int compare(Contribution t, Contribution t1) {
      if (t.getValue()<t1.getValue())
          return -1;
      else if (t.getValue() > t1.getValue())
          return 1;
      else
          return 0;
    }
    
}
