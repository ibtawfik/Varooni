import java.io.Serializable;

/**
 * Created by islam on 10/25/15.
 */
public class State  implements Serializable{
    //Splitting the total game area into 400 chunks, used to approximate area of the map we should play
    Pair quadrents[] = new Pair[400];

    //Number of games played with this state
    int played;

    //Number of games played with this state won
    int won;

    public String getKey(){
        //Count the number of stones played
        int total = 0;

        //Create a custom function likley to result in a unique key
        int hash = 0;

        for(int i = 0; i < quadrents.length; i++){
            Pair current = quadrents[i];
            if(current != null){
                total = total + current.myCount + current.opponentCount;
                hash = hash + ((current.myCount * 3 + current.opponentCount * 7) * (i + 1));
            }
        }
        return (total +":"+hash);
    }

    //Create a deep copy of the state object, all states will live for a single iteration of the game then be updated
    //with win or loss stats at the end
    public State clone(){
        State state = new State();
        Pair quadrentClone []= new Pair[400];

        for(int i = 0; i < quadrents.length; i++){
            if(quadrents[i] != null){
                quadrentClone[i] = quadrents[i].clone();
            }
        }

        state.quadrents = quadrentClone;
        state.played = played;
        state.won = won;
        return state;
    }

    /**
     * Player is 1 for me and 2 for the opposing player
     * @param player
     */
    public void updateState(int player, int quadrent){
        Pair updatePair = quadrents[quadrent];
        if(updatePair == null){
            updatePair = new Pair();
        }
        if(player == 1){
            updatePair.myCount = updatePair.myCount + 1;
        }else{
            updatePair.opponentCount = updatePair.opponentCount + 1;
        }
        quadrents[quadrent] = updatePair;
    }

    public double winRate(){
        return (double)won/(double)played;
    }

    public void endMatch(boolean hasWon){
        played++;
        if(hasWon){
            won++;
        }
    }
}
