public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public ID getID(){
        return id;
    }

    public int getVelX(){
        return velX;
    }

    public void setVelX(int velX){
        this.velX = velX;
    }

    public int getVelY(){
        return velY;
    }

    public void setVelY(int velY){
        this.velY = velY;
    }
    
}
