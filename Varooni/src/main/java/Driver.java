/**
 * Created by islam on 10/25/15.
 */
public class Driver {

    public static void main(String[] args) {
        int p1Score = 0;
        int p2Score = 0;

        while (true) {
            System.out.println("P1:" + p1Score + " P2:" + p2Score);
            Trainer player1 = new Trainer(null, 0, "AI", 1000);
            Trainer player2 = new Trainer(null, 0, "AI-2", 1000);

            String player1Move = null;
            String player2Move = null;

            for (int i = 0; i < 10; i++) {
                if (player2Move != null) {
                    player1.updateBoard(player2Move);
                }
                player1Move = player1.makeMove();
                //System.out.println("P1:" + player1Move);
                player2.updateBoard(player1Move);
                player2Move = player2.makeMove();
                //System.out.println("P2:" + player2Move);
            }

            player1.updateBoard(player2Move);
            //Always score grid using 1, becuase to player 2 they are still the primary player
            int player2Score = Scorer.score(player2.getGrid(), 1);
            if(player2Score < 500001){
                p1Score++;
            }else{
                p2Score++;
            }
            player1.endGame(player2Score < 500001);
            player2.endGame(player2Score >= 500001);
        }
    }

}
