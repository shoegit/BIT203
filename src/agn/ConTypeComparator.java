
package agn;

import java.util.Comparator;

/**
 * A comparator to compare contributions by Type
 * @author ngsm
 */
public class ConTypeComparator implements Comparator<Contribution> {

    /** 
     * Return Materials, then Monetary, then Sponsorships
     * @param t
     * @param t1
     * @return 
     */
    @Override
    public int compare(Contribution t, Contribution t1) {
     // same class, return 0
     if (t.getClass().equals(t1.getClass()))
         return 0;
    // not same class, return Material first
     if (t instanceof Material )
          return -1;
     else if (t1 instanceof Material)
         return -1;
     // neither one is Material, return Monetary first
     if (t instanceof Monetary)
         return -1;
     // if t is not monetary or material then it's sponsorship
     // so just return 1
     return 1;
    }
    
}
