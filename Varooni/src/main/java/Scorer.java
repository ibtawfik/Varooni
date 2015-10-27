import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by islam on 10/25/15.
 */
public class Scorer {

    static int winPlayer1 = 0;
    static int winPlayer2 = 0;

    public static int score(int [][] board, int player){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        HashMap<Integer, List<Point>> pointsHeld = new HashMap<Integer, List<Point>>();
        pointsHeld.put(1,new LinkedList<Point>());
        pointsHeld.put(2,new LinkedList<Point>());

        winPlayer1 = 0;
        winPlayer2 = 0;

        //Discover all the points held
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j<1000; j++){
                if(board[i][j] == 1){
                    Point point = new Point();
                    point.x = i;
                    point.y = j;
                    pointsHeld.get(1).add(point);
                }
                if(board[i][j] == 2){
                    Point point = new Point();
                    point.x = i;
                    point.y = j;
                    pointsHeld.get(2).add(point);
                }
            }
        }

        //for each point calculate the pull for player 1 and player 2, incrment count won
//        for(int i = 0; i < 1000; i++){
//            for(int j = 0; j < 1000; j++){
//                double pull1 = pull(pointsHeld.get(1), i, j);
//                double pull2 = pull(pointsHeld.get(2),i,j);
//                if(pull1 > pull2){
//                    winPlayer1++;
//                }else {
//                    winPlayer2++;
//                }
//            }
//        }


        executorService.execute(new Looper(0, 500, 0, 500, pointsHeld));
        executorService.execute(new Looper(500,1000,0,500,pointsHeld));
        executorService.execute(new Looper(0,500,500,1000,pointsHeld));
        executorService.execute(new Looper(500,1000,500,1000,pointsHeld));
        executorService.shutdown();
        while(!executorService.isTerminated());


        if(player == 1){
            return winPlayer1;
        }else {
            return winPlayer2;
        }

    }

    private static double pull(List<Point> points, int x, int y){

        double sum = 0;

        for(Point point: points){
            double eDist = Math.sqrt(Math.pow((double)point.x - (double)x,2) + Math.pow((double)point.y - (double)y,2));
            sum = sum + (1/Math.pow(eDist,2));
        }
        return sum;
    }

    static class Looper implements Runnable{

        int fromI;
        int toI;
        int fromJ;
        int toJ;
        HashMap<Integer, List<Point>> pointsHeld;

        public Looper(int fromI, int toI, int fromJ, int toJ, HashMap<Integer, List<Point>> pointsHeld){
            this.fromI = fromI;
            this.fromJ = fromJ;
            this.toI = toI;
            this.toJ = toJ;
            this.pointsHeld = pointsHeld;
        }

        public void run() {
            for(int i = fromI; i < toI; i++){
                for(int j = fromJ; j < toJ; j++){
                    double pull1 = pull(pointsHeld.get(1), i, j);
                    double pull2 = pull(pointsHeld.get(2),i,j);
                    if(pull1 > pull2){
                        winPlayer1++;
                    }else {
                        winPlayer2++;
                    }
                }
            }
        }
    }
}
