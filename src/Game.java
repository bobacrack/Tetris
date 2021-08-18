import java.awt.*;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 200;
    public static final int HEIGHT = 500;
    public static final String TITLE = "TETRIS";

    private Thread gameThread;
    private boolean running = false;

    public Game(){
        //todo handler, keyinput, HUD??
        ImageLoader loader = new ImageLoader();
        

    }

    public synchronized void start(){
        try{
            gameThread = new Thread(this);
            gameThread.start();
            running = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void stop(){
        try{
            gameThread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
