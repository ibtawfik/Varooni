import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;


public class JavaClient extends VoronoiClient{
    Random rand = new Random();
    int[][] grid;
    int randomPercentage = 5;
    DB db;
    HTreeMap<String,State> seenStates;
    String name;
    State currentState = new State();
    List<State> states = new LinkedList<State>();


    public JavaClient(String server, int port, String username, int n) {
        super(server, port, username);
        name = username;
        grid = new int[n][n];
        db = DBMaker.fileDB(new File(username)).cacheHashTableEnable().cacheSize(5000000).make();
        seenStates = db.hashMapCreate("States").makeOrGet();
    }

    // random strategy
    @Override
    public String process(String command) {
        if (command.equals("TEAM")) {
            return super.username;
        }

        if (command.matches("[A-Za-z0-9-_]+ \\d+ \\d+")) {
            updateBoard(command);
        }

        if (command.equals("MOVE")) {
            return makeMove();
        }

        if (command.equals("RESTART")) {
            states.clear();
            currentState = new State();
            grid = new int[1000][1000];
        }

        if (command.equals("END")) {
            System.exit(0);
        }

        return "";
    }

    public void updateBoard(String opponentPosition){
        StringTokenizer tk2 = new StringTokenizer(opponentPosition, " ");

        // Use this in your code if necessary, skipping here
        String player_name = tk2.nextToken();
        int px = Integer.parseInt(tk2.nextToken());
        int py = Integer.parseInt(tk2.nextToken());
        grid[px][py] = 2;

    }

    public String makeMove(){
        //Make a random move if within probability threshold
        if(rand.nextInt(100) <= randomPercentage){
            return fullRandomMove();
        }

        //Otherwise create all the possible upcoming states, select the one that had the best prior probability of sucess
        //TODO: if I have time remove all the magic numbers
        State bestState = null;
        int bestQuadrent = 0;

        for(int i = 0; i < 400; i++){
            State nextState = currentState.clone();
            nextState.updateState(1,i);
            //If we've seen this state before then check its win rate vs our current best, choose the winnegest path
            String key  = nextState.getKey();
            int size = seenStates.size();
            if(seenStates.containsKey(nextState.getKey())){
                nextState = seenStates.get(nextState.getKey());
                if(bestState == null){
                    bestState = nextState;
                    bestQuadrent = i;
                }else{
                    if(bestState.winRate() < nextState.winRate()){
                        bestState = nextState;
                        bestQuadrent = i;
                    }
                }
            }
        }

        if(bestState == null){
            return fullRandomMove();
        }else{
            states.add(currentState);
            currentState = bestState;
            return greedyMove(bestQuadrent);
        }

    }

    public String randomMove(int randomQuadrent){
        //convert quadrent to xy coordinates
        Range validRange = RangeTranslator.getRange(randomQuadrent);

        int myx = 0;
        int myy = 0;
        do {
            myx = rand.nextInt(50) + validRange.xMin;
            myy = rand.nextInt(50) + validRange.yMin;
        } while (grid[myx][myy] != 0);
        grid[myx][myy] = 1;
        return String.format("%d %d", myx, myy);
    }

    /**
     * Process for creating a random move and updating the board state.
     * @return
     */
    public String fullRandomMove(){
        int randomQuadrent  = rand.nextInt(400);
        String randomMove = randomMove(randomQuadrent);

        //Create a new state with the random move
        State nextState = currentState.clone();
        nextState.updateState(1,randomQuadrent);

        //Push the current state to the list of states, set current state to new state
        states.add(currentState);
        currentState = nextState;
        return  randomMove;
    }

    public int[][] getGrid(){
        return grid;
    }

    public String greedyMove(int quadrent){
        //Check 9 spots within the quadrent
        int bestScore = 0;
        int bestX = 0;
        int bestY = 0;
        Range range = RangeTranslator.getRange(quadrent);
        int xMin = range.xMin;
        int xCenter = range.xMin + (range.xMax - range.xMin);
        int xMax = range.xMax;
        int yMin = range.yMin;
        int yCenter = range.yMin + (range.yMax - range.yMin);
        int yMax = range.yMax;

        //Test all combinations of x and y to know where int eh qudrent to place our stone
        int currentX = 0;
        int currentY = 0;
        int score = 0;

        //TODO this repition is ugly can probably be condesed
        //TOP LEFT
        if(grid[xMin][yMin] == 0){

            currentX = xMin;
            currentY = yMin;
            score = score(currentX,currentY);
        }else {
            Point next = migrateTopLeft(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //TOP CENTER
        if(grid[xCenter][yMin] == 0){

            currentX = xCenter;
            currentY = yMin;
            score = score(currentX,currentY);
        }else {
            Point next = migrateTopCenter(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //TOP RIGHT
        if(grid[xMax][yMin] == 0){

            currentX = xMax;
            currentY = yMin;
            score = score(currentX,currentY);
        }else {
            Point next = migrateTopRight(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //CENTER LEFT
        if(grid[xMin][yCenter] == 0){

            currentX = xMin;
            currentY = yCenter;
            score = score(currentX,currentY);
        }else {
            Point next = migrateCenterLeft(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //CENTER CENTER
        if(grid[xCenter][yCenter] == 0){

            currentX = xCenter;
            currentY = yCenter;
            score = score(currentX,currentY);
        }else {
            Point next = migrateCenterCenter(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //CENTER RIGHT
        if(grid[xMax][yCenter] == 0){

            currentX = xMax;
            currentY = yCenter;
            score = score(currentX,currentY);
        }else {
            Point next = migrateCenterRight(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //BOTTOM LEFT
        if(grid[xMin][yMax] == 0){

            currentX = xMin;
            currentY = yMax;
            score = score(currentX,currentY);
        }else {
            Point next = migrateBottomLeft(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //BOTTOM CENTER
        if(grid[xCenter][yMax] == 0){

            currentX = xCenter;
            currentY = yMax;
            score = score(currentX,currentY);
        }else {
            Point next = migrateBottomCenter(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //BOTTOM RIGHT
        if(grid[xMax][yMax] == 0){

            currentX = xMax;
            currentY = yMax;
            score = score(currentX,currentY);
        }else {
            Point next = migrateBottomRight(range);
            currentX = next.x;
            currentY = next.y;
            score = score(next.x,next.y);
        }

        if(score > bestScore){
            bestScore = score;
            bestX = currentX;
            bestY = currentY;
        }

        //Update the grid with that move and return it
        grid[bestX][bestY] = 1;

        return String.format("%d %d", bestX, bestY);

    }

    private int score(int x, int y){
        //Clone was a shallow copy so just reset the state of the grid after computing the score
        grid[x][y] = 1;
        int score = Scorer.score(grid,1);
        grid[x][y] = 0;
        return score;
    }

    private Point migrateTopLeft(Range range){
        //Just move horizontially across the top towards the center of the range
        int xOffset = 1;
        int x = range.xMin;
        int y = range.yMin;
        while (grid[x][y] != 0){
            x = x + xOffset;
        }

        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }

    private Point migrateCenterLeft(Range range){
        //Just move horizontially across the top towards the center of the range
        int xOffset = 1;
        int x = range.xMin;
        int y = range.yMin + (range.yMax - range.yMin);
        while (grid[x][y] != 0){
            x = x + xOffset;
        }

        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }
    private Point migrateCenterRight(Range range){
        //Just move horizontially towards the center of the range
        int xOffset = -1;
        int x = range.xMax;
        int y = range.yMin + (range.yMax - range.yMin);
        while (grid[x][y] != 0){
            x = x + xOffset;
        }

        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }


    private Point migrateCenterCenter(Range range){
        //Randomly select points around the center
        int x = range.xMin + (range.xMax - range.xMin);
        int y = range.yMin + (range.yMax - range.yMin);
        int returnX = x;
        int returnY = y;
        while (grid[returnX][returnY] != 0){
            int xOffset = rand.nextInt(20);
            if(xOffset > 10){
                xOffset = (xOffset % 10) * -1;
            }
            int yOffset = rand.nextInt(20);
            if(yOffset > 10){
                yOffset = (yOffset % 10) * -1;
            }
            returnX = x + xOffset;
            returnY = y + yOffset;
        }

        Point point = new Point();
        point.x = returnX;
        point.y = returnY;
        return point;
    }

    private Point migrateTopCenter(Range range){
        //Just move y down towards the center
        //Just move horizontially across the top towards the center of the range
        int yOffset = 1;
        int x = range.xMin + (range.xMax - range.xMin);
        int y = range.yMin;
        while (grid[x][y] != 0){
            y = y + yOffset;
        }

        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }

    private Point migrateTopRight(Range range){
        //Move x across the top towards the center
        int xOffset = -1;
        int x = range.xMax;
        int y = range.yMin;
        while (grid[x][y] != 0){
            x = x + xOffset;
        }

        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }

    private Point migrateBottomLeft(Range range){
        //Move x towards the center
        int xOffset = 1;
        int x = range.xMin;
        int y = range.yMax;
        while (grid[x][y] != 0){
            x = x + xOffset;
        }

        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }

    private Point migrateBottomCenter(Range range){
        //Just move y up towards the center
        int yOffset = -1;
        int x = range.xMin + (range.xMax - range.xMin);
        int y = range.yMax;
        while (grid[x][y] != 0){
            y = y + yOffset;
        }

        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }

    private Point migrateBottomRight(Range range){
        //Move x across the top towards the center
        int xOffset = -1;
        int x = range.xMax;
        int y = range.yMax;
        while (grid[x][y] != 0){
            x = x + xOffset;
        }
        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }

    public void endGame(boolean hasWon){
        //Back propigate the results
        states.add(currentState);
        for(State state: states){

            if(this.seenStates.containsKey(state.getKey())){
                State savedState = this.seenStates.get(state.getKey());
                state.played =  savedState.played + 1;

                if(hasWon){
                    state.won = savedState.won + 1;
                }else {
                    state.won = savedState.won;
                }
            }else{
                state.endMatch(hasWon);
            }

            System.out.println(state.winRate());
            this.seenStates.put(state.getKey(),state);
        }
        //save the db
        db.commit();
        //compress the db
//        db.compact();
        //close the db
        db.close();
    }

    public static void main(String[] args) {
        int port;
        String name = "";
        if (args.length < 1) {
            System.out.println("Need atleast the name.");
            System.exit(0);
        } else {
            name = args[0];
        }
        if (args.length == 2) {
            port = Integer.parseInt(args[1]);
        } else {
            port = 1337;
        }
        System.out.format("My name is %s\n", name);
        JavaClient client = new JavaClient("localhost", port, name, 1000);
        client.start();
    }
}
