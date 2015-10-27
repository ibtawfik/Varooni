/**
 * Created by islam on 10/25/15.
 */

import java.io.Serializable;

/**
 * Keep track of the number of stones played in a single quadrenet.
 */
public class Pair implements Serializable {
    int myCount;
    int opponentCount;

    public Pair clone(){
        Pair pair = new Pair();
        pair.myCount = myCount;
        pair.opponentCount = opponentCount;
        return pair;
    }
}
