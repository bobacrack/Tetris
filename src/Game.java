import org.w3c.dom.html.HTMLDOMImplementation;

import java.awt.*;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 200;
    public static final int HEIGHT = 500;
    public static final String TITLE = "TETRIS";

    private Thread gameThread;
    private boolean running = false;

    private Handler handler;
    public Game(){
        //todo handler, keyinput, HUD??

        handler = new Handler();

        ImageLoader loader = new ImageLoader();

        new Window(WIDTH, HEIGHT, TITLE, this);
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
