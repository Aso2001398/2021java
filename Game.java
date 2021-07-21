import java.util.*;

public class Game {
    public final static int array_vertical = 5; //盤面の縦の長さ
    public final static int array_horizon = 5; //盤面の横の長さ
    public final static int Ship_in = 1; //船がいる場合の数値
    public final static int Ship_not_in = 0; //船がいない場合の数値
    public final static int ships = 3; //船の数
    public final static List<Integer> board2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));//完全ランダム用のリスト
    public static int x; public static int y; //入力された数値の格納変数

    public static int[][] board = new int[array_vertical][array_horizon]; //盤面

    public static void new_game() {
        Scanner sc = new Scanner(System.in);

        board_settings(); //盤面の生成
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        Ship ship3 = new Ship();
        axis_set(board2, ship1, ship2, ship3); //各インスタンスの初期位置
        set_board(ship1, ship2, ship3); //上の初期位置を表に代入する

        System.out.println("***********************");
        System.out.println("       戦艦ゲーム       ");
        System.out.println("***********************");
        
        for(int num=1; ship1.getAlive() || ship2.getAlive() || ship3.getAlive() ; num++){
            System.out.println("*********[ターン"+num+"]********");
            System.out.println("船1:" + ship1.getText()); //インスタンスに含まれている生死テキストを呼び出し表示
            System.out.println("船2:" + ship2.getText());
            System.out.println("船3:" + ship3.getText());
            System.out.println("爆弾のx座標を入力してください(1-5) *9を入力すると終了します*");
            x = sc.nextInt() - 1;
            if(x==8){
                break;
            }
            
            System.out.println("爆弾のy座標を入力してください(1-5)");
            y = sc.nextInt() - 1;

            if(ship1.getAlive()){ //生きている場合、座標のチェックと処理をする
                System.out.println("船1:"+ ship1.impact_check(x,y));
            }
            
            if(ship2.getAlive()){
                System.out.println("船2:"+ ship2.impact_check(x,y));
            }

            if(ship3.getAlive()){
                System.out.println("船3:"+ ship3.impact_check(x,y));
            }
            

            
        }
    }
    
    public static void board_settings() { //盤面の初期化
        for(int i=0;i<array_vertical;i++){
            for(int n=0;n<array_horizon;n++){
                board[i][n] = Ship_not_in;
            }
        }
    }

    public static void axis_set(List<Integer> board2, Ship ship1, Ship ship2, Ship ship3){ //各インスタンスの初期位置
        Collections.shuffle(board2);
        ship1.setX_axis(board2.get(0));
        ship2.setX_axis(board2.get(1));
        ship3.setX_axis(board2.get(2));
        Collections.shuffle(board2);
        ship1.setY_axis(board2.get(0));
        ship2.setY_axis(board2.get(1));
        ship3.setY_axis(board2.get(2));
    }

    public static void set_board(Ship ship1, Ship ship2, Ship ship3){ //上の初期位置を盤面に代入する
        for(int i=0; i<ships; i++){
            board[ship1.getX_axis()][ship1.getY_axis()] = 1;
            board[ship2.getX_axis()][ship2.getY_axis()] = 1;
            board[ship3.getX_axis()][ship3.getY_axis()] = 1;
        }
    }

    

    

    
}
