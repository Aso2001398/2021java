import java.util.Random;

public class Ship {
    Random ran = new Random(); //ランダム関数の生成
    private String text = "生きている"; //初期の生存テキスト

    private boolean alive = true; 
    public boolean getAlive(){
        return this.alive;
    }
    
    public String getText() {
        return text;
    }

    private int x_axis; //x座標

    public int getX_axis() {
        return x_axis;
    }  
    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }


    private int y_axis; //y座標

    public int getY_axis() {
        return y_axis;
    }
    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }

    private int hp = 3;

    public String impact_check(int x, int y) {
        String txt; //各反応に対して返すテキスト
        if(x == this.x_axis && y == this.y_axis && alive){
            txt = "命中";
            this.hp--;
            Game.board[x][y] = Game.Ship_not_in; //当たった座標の存在を消す
            if(this.hp == 0){ //hpが0になった場合、生死テキストを変更し、impact_checkを呼ばないようaliveを変更する
                this.text = "死んでいる";
                this.alive = false;
            }else{
                shuffles(); //当てられた際に座標を変更し、表を更新する
            }
            
            
        }else if(x == this.x_axis+1 && y == this.y_axis || x == this.x_axis-1 && y == this.y_axis || x == this.x_axis && y == this.y_axis+1 || x == this.x_axis && y == this.y_axis-1 ){
            txt = "波高し";
        }else{
            txt = "はずれ";
        }
        return txt;
    }

    public void shuffles(){ ////当てられた際に座標を変更し、表を更新する
        this.x_axis = ran.nextInt(5);
        this.y_axis = ran.nextInt(5);
        while(Game.board[x_axis][y_axis] == 1){
            this.x_axis = ran.nextInt(5);
            this.y_axis = ran.nextInt(5);
        }
        Game.board[x_axis][y_axis] = 1;
    }
}
