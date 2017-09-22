import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 */
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt(); // width of the board
        int h = in.nextInt(); // height of the board
        int playerCount = in.nextInt(); // number of players (2 or 3)
        int myId = in.nextInt(); // id of my player (0 = 1st player, 1 = 2nd player, ...)
        boolean twoPlayerGame = playerCount == 2;
        Target[] targets = twoPlayerGame ? new Target[]{Target.RIGHT, Target.LEFT} :
                new Target[]{Target.RIGHT, Target.LEFT, Target.DOWN};
        // game loop
        while (true) {
            List<Gamer> otherGamers = new ArrayList<>(playerCount - 1);
            Gamer me = null;
            for (int i = 0; i < playerCount; i++) {
                int x = in.nextInt(); // x-coordinate of the player
                int y = in.nextInt(); // y-coordinate of the player
                int wallsLeft = in.nextInt(); // number of walls available for the player
                if (x < 0)
                    continue;
                if (myId == i) {
                    me = new Gamer(targets[i], new Point(x, y), wallsLeft, i);
                } else {
                    otherGamers.add(new Gamer(targets[i], new Point(x, y), wallsLeft, i));
                }
            }
            Field field = new Field(w, h);
            int wallCount = in.nextInt(); // number of walls on the board
            for (int i = 0; i < wallCount; i++) {
                int wallX = in.nextInt(); // x-coordinate of the wall
                int wallY = in.nextInt(); // y-coordinate of the wall
                String wallOrientation = in.next(); // wall orientation ('H' or 'V')
                if ("H".equals(wallOrientation)) {
                    field.addHorizontalWall(wallX, wallY);
                } else {
                    field.addVerticalWall(wallX, wallY);
                }
            }

            GameState state = new GameState(field, otherGamers, me);
            for (Gamer gamer : state.getAllGamers()) {
                int[][] distances = new int[h][w];
                PathCalculator.fillShortestPaths(distances, gamer.getLocation(), field);
                int minPath = gamer.getTarget().getMinPath(distances);

                gamer.setDistances(distances);
                gamer.setShortestPathLength(minPath);
                Stack<Point> path = new Stack<>();
                PathCalculator.fillPath(path, distances, gamer.getLocation(), gamer.getTarget().getMinPathEndPoint(distances), field);
                Move nextMove = new Move(path.pop(), gamer.getLocation());
                gamer.setNextMove(nextMove);
            }
            //int[][] bridges = PathCalculator.scc(field);
            // System.out.println(bridges.length);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            // System.err.print(map(gameField, walls));
            System.out.println(new DecisionMaker(state).getCommand()); // action: LEFT, RIGHT, UP, DOWN or "putX putY putOrientation" to place a wall
        }
    }

    private static class Move {
        private final Point from;
        private final Point to;

        public Move(Point from, Point to) {
            this.from = from;
            this.to = to;
        }

        public boolean isHorizontal() {
            return to.y == from.y;
        }
    }

    private static enum Target {
        RIGHT(false, "RIGHT"), LEFT(false, "LEFT"), DOWN(true, "DOWN");

        public static final Point NO_PATH = new Point(-1, -1);

        private final boolean vertical;
        private final String defaultCommand;

        private Target(boolean vertical, String defaultCommand) {
            this.vertical = vertical;
            this.defaultCommand = defaultCommand;
        }

        public boolean isVerticalDirection() {
            return vertical;
        }

        public int getMinPath(int[][] distances) {
            int minLength = Integer.MAX_VALUE;
            if (isVerticalDirection()) {
                int rowIndex = distances.length - 1;
                for (int i = 0; i < distances.length; i++) {
                    int pathLength = distances[rowIndex][i];
                    if (pathLength < minLength) {
                        minLength = pathLength;
                    }
                }
            } else {
                int columnIndex = LEFT.equals(this) ? 0 : distances[0].length - 1;
                for (int i = 0; i < distances[0].length; i++) {
                    int pathLength = distances[i][columnIndex];
                    if (pathLength < minLength) {
                        minLength = pathLength;
                    }
                }
            }
            return minLength;
        }

        public Point getMinPathEndPoint(int[][] distances) {
            int minLength = Integer.MAX_VALUE;
            int index = 0;
            if (isVerticalDirection()) {
                int rowIndex = distances.length - 1;
                for (int i = 0; i < distances.length; i++) {
                    int pathLength = distances[rowIndex][i];
                    if (pathLength < minLength) {
                        index = i;
                        minLength = pathLength;
                    }
                }
                return minLength == Integer.MAX_VALUE ? NO_PATH : new Point(index, rowIndex);
            } else {
                int columnIndex = LEFT.equals(this) ? 0 : distances[0].length - 1;
                for (int i = 0; i < distances[0].length; i++) {
                    int pathLength = distances[i][columnIndex];
                    if (pathLength < minLength) {
                        index = i;
                        minLength = pathLength;
                    }
                }
                return minLength == Integer.MAX_VALUE ? NO_PATH : new Point(columnIndex, index);
            }
        }

        public String getDefaultCommand() {
            return defaultCommand;
        }
    }


    public static class Field {
        private final int width;
        private final int height;
        private final int[][] hWalls;
        private final int[][] vWalls;

        public Field(int width, int height) {
            this.width = width;
            this.height = height;
            hWalls = new int[height][width];
            vWalls = new int[height][width];
        }

        public Field(Field copy) {
            this(copy.width, copy.height);
            for (int i = 0; i < copy.height; i++) {
                System.arraycopy(copy.gethWalls()[i], 0, hWalls[i], 0, copy.width);
                System.arraycopy(copy.getvWalls()[i], 0, vWalls[i], 0, copy.width);
            }
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int[][] gethWalls() {
            return hWalls;
        }

        public int[][] getvWalls() {
            return vWalls;
        }

        public void addHorizontalWall(int wallX, int wallY) {
            hWalls[wallY - 1][wallX] = 1;
            hWalls[wallY - 1][wallX + 1] = 2;
        }

        public void addVerticalWall(int wallX, int wallY) {
            vWalls[wallY][wallX - 1] = 1;
            vWalls[wallY + 1][wallX - 1] = 2;
        }
    }

    private static class GameState {
        private final Field field;
        private final List<Gamer> otherGamers;
        private final Gamer me;
        private final List<Gamer> allGamers;

        private GameState(Field field, List<Gamer> otherGamers, Gamer me) {
            this.field = field;
            this.otherGamers = otherGamers;
            this.me = me;
            allGamers = new ArrayList<>(otherGamers);
            allGamers.add(me);
        }

        public List<Gamer> getOtherGamers() {
            return otherGamers;
        }

        public Gamer getMe() {
            return me;
        }

        public Field getField() {
            return field;
        }

        public List<Gamer> getAllGamers() {
            return allGamers;
        }

        public boolean isTwoGamersMode() {
            return otherGamers.size() == 1;
        }
    }

    private static class Gamer {
        private final Target target;
        private final Point location;
        private final int wallsNumber;
        private final int step;

        private int[][] distances;
        private int shortestPathLength;
        private Move nextMove;

        private Gamer(Target target, Point location, int wallsNumber, int step) {
            this.target = target;
            this.location = location;
            this.wallsNumber = wallsNumber;
            this.step = step;
        }

        public Target getTarget() {
            return target;
        }

        public Point getLocation() {
            return location;
        }

        public int getWallsNumber() {
            return wallsNumber;
        }

        public int getStep() {
            return step;
        }

        public int[][] getDistances() {
            return distances;
        }

        public void setDistances(int[][] distances) {
            this.distances = distances;
        }

        public int getShortestPathLength() {
            return shortestPathLength;
        }

        public void setShortestPathLength(int shortestPathLength) {
            this.shortestPathLength = shortestPathLength;
        }

        public Move getNextMove() {
            return nextMove;
        }

        public void setNextMove(Move nextMove) {
            this.nextMove = nextMove;
        }
    }

    private static class Wall {
        private final Point begin;
        private final boolean isHorizontal;
        private double profit;

        private Wall(Point begin, boolean isHorizontal) {
            this.begin = begin;
            this.isHorizontal = isHorizontal;
        }

        public Point getBegin() {
            return begin;
        }

        public boolean isHorizontal() {
            return isHorizontal;
        }

        public double getProfit() {
            return profit;
        }

        public void setProfit(double profit) {
            this.profit = profit;
        }

        public boolean isNotIsolated(Field gameField) {
            int[][] horWalls = gameField.gethWalls();
            int[][] vertWalls = gameField.getvWalls();
            if (isHorizontal()) {
                if (begin.x == 0 || begin.y + 1 == gameField.width - 1)
                    return true;
                
                /*if((begin.x > 0 && horWalls[begin.y][begin.x - 1] != 0)
                   || (begin.x + 2 < gameField.width && horWalls[begin.y][begin.x + 2] != 0) )
                {
                    return true;
                }                
                if((begin.x > 0 && vertWalls[begin.y][begin.x - 1] != 0 )
                        || vertWalls[begin.y][begin.x] != 0
                        || (begin.x + 1 < gameField.width && vertWalls[begin.y][begin.x + 1] != 0) )
                {
                    return true;
                }*/
            } else {
                if (begin.y == 0 || begin.y + 1 == gameField.height - 1)
                    return true;

                /*if((begin.y > 0 && vertWalls[begin.y - 1][begin.x] != 0)
                        || (begin.y + 2 < gameField.height && vertWalls[begin.y + 2][begin.x] != 0) )
                {
                    return true;
                }
                if((begin.y > 0 && horWalls[begin.y - 1][begin.x] != 0 )
                        || horWalls[begin.y][begin.x] != 0
                        || (begin.x + 1 < gameField.width && horWalls[begin.y][begin.x + 1] != 0) )
                {
                    return true;
                }*/
            }
            return false;
        }
    }

    private static class PathCalculator {

        public static int[][] scc(Field field) {
            int n = field.getHeight();
            int m = field.getWidth();
            int[][] lowlink = new int[n][m];

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    lowlink[y][x] = findNeighbours(new Point(x, y), field).size();

                }
            }
            return lowlink;
        }

        public static void fillShortestPaths(int[][] distances, Point from, Field field) {
            for (int[] distance : distances) {
                Arrays.fill(distance, Integer.MAX_VALUE);
            }
            LinkedList<Point> pointQueue = new LinkedList<>();
            pointQueue.add(from);
            try {
                distances[from.y][from.x] = 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("RIGHT " + "Illegal: " + from.y + " " + from.x);
                throw e;
            }
            while (!pointQueue.isEmpty()) {
                Point nextPoint = pointQueue.poll();
                List<Point> neighbours = findNeighbours(nextPoint, field);
                for (Point neighbour : neighbours) {
                    int distanceThrough = distances[nextPoint.y][nextPoint.x] + 1;
                    if (distanceThrough < distances[neighbour.y][neighbour.x]) {
                        pointQueue.remove(neighbour);
                        distances[neighbour.y][neighbour.x] = distanceThrough;
                        pointQueue.add(neighbour);
                    }
                }
            }
        }

        public static void fillPath(Stack<Point> shortestPath, int[][] distances, final Point target, Point currentPoint, Field field) {
            for (Point point : PathCalculator.findNeighbours(currentPoint, field)) {
                if (point.equals(target)) {
                    shortestPath.push(point);
                    return;
                }
                if (distances[currentPoint.y][currentPoint.x] - distances[point.y][point.x] == 1) {
                    shortestPath.push(point);
                    fillPath(shortestPath, distances, target, point, field);
                    break;
                }
            }
        }

        public static List<Point> findNeighbours(Point point, Field field) {
            int x = point.x;
            int y = point.y;
            List<Point> result = new ArrayList<>(4);
            if (x > 0 && canMove(x, y, x - 1, y, field))
                result.add(new Point(x - 1, y));
            if (x < field.getWidth() - 1 && canMove(x, y, x + 1, y, field))
                result.add(new Point(x + 1, y));
            if (y > 0 && canMove(x, y - 1, x, y, field))
                result.add(new Point(x, y - 1));
            if (y < field.getHeight() - 1 && canMove(x, y + 1, x, y, field))
                result.add(new Point(x, y + 1));
            return result;
        }

        public static boolean canMove(int xFrom, int yFrom, int xTo, int yTo, Field field) {
            assert Math.abs(xFrom - xTo) < 2;
            assert Math.abs(yFrom - yTo) < 2;
            if (xFrom == xTo) {
                return yTo > yFrom ? field.gethWalls()[yFrom][xTo] == 0 : field.gethWalls()[yTo][xTo] == 0;
            }
            return xTo > xFrom ? field.getvWalls()[yFrom][xFrom] == 0 : field.getvWalls()[yFrom][xTo] == 0;
        }

        public static boolean canMove(Point from, Point to, Field field) {
            return canMove(from.x, from.y, to.x, to.y, field);
        }
    }


    public static class WallBuilder {
        public static boolean canMakeHorizontalWall(Point point, Field field) {
            if (point.y < 1 || point.y > field.getHeight() - 1)
                return false;
            if (point.x < 0 || point.x + 1 > field.getWidth() - 1)
                return false;
            boolean noHorizontalAtPlace = field.gethWalls()[point.y - 1][point.x] == 0 && field.gethWalls()[point.y - 1][point.x + 1] == 0;
            boolean noVerticalAtPlace = field.getvWalls()[point.y - 1][point.x] != 1;
            return noHorizontalAtPlace && noVerticalAtPlace;
        }

        public static boolean canMakeVerticalWall(Point point, Field field) {
            if (point.y < 0 || point.y + 1 > field.getHeight() - 1)
                return false;
            if (point.x < 1 || point.x > field.getWidth() - 1)
                return false;
            boolean noVerticalAtPlace = field.getvWalls()[point.y][point.x - 1] == 0 && field.getvWalls()[point.y + 1][point.x - 1] == 0;
            boolean noHorizontalAtPlace = field.gethWalls()[point.y][point.x - 1] != 1;
            return noHorizontalAtPlace && noVerticalAtPlace;
        }
    }


    private static class DecisionMaker {
        private final GameState state;

        private DecisionMaker(GameState state) {
            this.state = state;        }


        public String getCommand() {
            if (oneStepWin(state.getMe()))
                return state.me.getTarget().getDefaultCommand();
            String command = null;
            if (canMakeWall() && shouldMakeWall()) {
                Wall wall = findBestWall();
                if (wall != null && wall.getProfit() > 1)
                    command = makeWallCommand(wall.getBegin(), wall.isHorizontal());
            }
            if (command == null)
                command = makeMoveCommand();
            return command;
        }

        private boolean shouldMakeWall() {
            for (Gamer otherGamer : state.getOtherGamers()) {
                if (oneStepWin(otherGamer))
                    return true;
                if (state.isTwoGamersMode()) {
                    int myWalls = state.getMe().getWallsNumber();
                    if (otherGamer.getWallsNumber() < state.getMe().getWallsNumber())
                        return true;
                    if ((otherGamer.getShortestPathLength() < state.getMe().getShortestPathLength())
                            || (otherGamer.getShortestPathLength() <= 3 && state.getMe().getStep() == 0 && myWalls == 10)
                            || (otherGamer.getShortestPathLength() <= 5 && state.getMe().getStep() > 0 && myWalls == 10))
                        return true;
                }
            }
            return false;
        }

        private Wall findBestWall() {
            Map<Gamer, Integer> paths = new HashMap<>();
            Field gameField = state.getField();
            for (Gamer gamer : state.getAllGamers()) {
                paths.put(gamer, gamer.getShortestPathLength());
            }
            Wall bestWall = null;
            int profit = 0;
            for (int i = 0; i < gameField.getHeight(); i++) {
                for (int j = 0; j < gameField.getWidth(); j++) {
                    Point point = new Point(j, i);
                    if (WallBuilder.canMakeVerticalWall(point, gameField)) {
                        Wall wall = new Wall(point, false);
                        int localProfit = calcProfitWithWall(gameField, paths, wall);
                        if (localProfit > profit) {
                            profit = localProfit;
                            bestWall = wall;
                            wall.setProfit(localProfit);
                        }
                    }
                    if (WallBuilder.canMakeHorizontalWall(point, gameField)) {
                        Wall wall = new Wall(point, true);
                        int localProfit = calcProfitWithWall(gameField, paths, wall);
                        if (localProfit > profit) {
                            profit = localProfit;
                            bestWall = wall;
                            wall.setProfit(localProfit);
                        }
                    }
                }
            }
            return bestWall;
        }

        private int calcProfitWithWall(Field gameField, Map<Gamer, Integer> paths, Wall wall) {
            Field copyField = new Field(gameField);
            if (wall.isHorizontal()) {
                copyField.addHorizontalWall(wall.getBegin().x, wall.getBegin().y);
            } else {
                copyField.addVerticalWall(wall.getBegin().x, wall.getBegin().y);
            }
            Map<Gamer, Integer> newPaths = new HashMap<>();
            Gamer me = state.getMe();
            for (Gamer gamer : paths.keySet()) {
                int[][] distances = new int[copyField.getHeight()][copyField.getHeight()];
                Point gamerLocation = gamer.getLocation();
                Target target = gamer.getTarget();
                PathCalculator.fillShortestPaths(distances, gamerLocation, copyField);
                int minPath = target.getMinPath(distances);
                // no path
                if (minPath == Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;

                int delta = (minPath - paths.get(gamer)) * 10;

                if (gamer != me && delta > 0) {
                    if (oneStepWin(gamer) && minPath > 1)
                        delta += 300;
                    // increase weight of walls turning back
                    if (gamer.getNextMove().isHorizontal() ^ !wall.isHorizontal())
                        delta += 3;
                    if(canMakeTrap(wall, gamer, copyField, distances))
                        delta+= 4;
                    if(state.isTwoGamersMode() && me.getStep() == 0 && (me.location.x == gamer.location.x))
                        delta+=2;
                    //put close to gamer
                    int koeff = wall.isHorizontal() ? Math.abs(wall.getBegin().y - gamer.location.y) : Math.abs(wall.getBegin().x - gamer.location.x);
                    delta += (koeff == 0 ||koeff == 1) ? 3 : 9 / (koeff*2);
                    if(!state.isTwoGamersMode()) {
                        Gamer gamerWithLongestPath = state.getOtherGamers().get(0).getShortestPathLength() > state.getOtherGamers().get(1).getShortestPathLength() ?
                                state.getOtherGamers().get(0) : state.getOtherGamers().get(1);
                        if(gamer == gamerWithLongestPath)
                            delta += 10;
                    }
                }
                newPaths.put(gamer, delta);
            }
            if (newPaths.get(me) > 0)
                return Integer.MIN_VALUE;
            int profit = 0;
            for (Integer delta : newPaths.values()) {
                profit = Math.max(profit, delta);
            }
            return profit;
        }

        private boolean canMakeTrap(Wall wall, Gamer gamer, Field copyField, int[][] distances) {
            if(!gamer.getTarget().isVerticalDirection() && !wall.isHorizontal()) {
                int gamerY = gamer.location.y;
                int wallY = wall.getBegin().y;
                int wallX = wall.getBegin().x;
                switch(gamerY) {
                    case 0:
                    case 1:
                        return wallY == 0;
                    case 2:
                        return wallY == 2;
                    case 7:
                    case 8:
                        return wallY == 7;
                    case 6:
                        return wallY == 5;

                }
            }
            return false;
        }

        private boolean oneStepWin(Gamer gamer) {
            return gamer.getShortestPathLength() == 1;
        }

        private String makeMoveCommand() {
            Stack<Point> path = findShortestPath(state.getMe(), state.getField());
            assert !path.isEmpty();
            path.pop();
            Point pop = path.pop();
            Point location = state.getMe().getLocation();
            return moveCommand(location.x, location.y, pop.x, pop.y);
        }

        private static String moveCommand(int xFrom, int yFrom,
                                          int xTo, int yTo) {
            if (xFrom == xTo)
                return yFrom < yTo ? "DOWN" : "UP";
            return xFrom < xTo ? "RIGHT" : "LEFT";
        }

        private Stack<Point> findShortestPath(Gamer gamer, Field field) {
            Stack<Point> shortestPath = new Stack<>();
            Target target = gamer.getTarget();
            Point minPathEndPoint = target.getMinPathEndPoint(gamer.getDistances());
            if (!Target.NO_PATH.equals(minPathEndPoint)) {
                PathCalculator.fillPath(shortestPath, gamer.getDistances(), gamer.getLocation(), minPathEndPoint, field);
            }
            return shortestPath;
        }


        private String makeWallCommand(Point point, boolean isHorizontal) {
            return String.format("%d %d %c", point.x, point.y, isHorizontal ? 'H' : 'V');
        }

        private boolean canMakeWall() {
            return state.getMe().getWallsNumber() > 0;
        }
    }

}

// todo: defence
// todo: prevent aisles
// todo: analyse history

