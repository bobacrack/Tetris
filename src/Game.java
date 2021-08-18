import java.awt.*;
import java.awt.image.BufferStrategy;
import java.time.chrono.HijrahEra;

public class Game extends Canvas implements Runnable {

    private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    /*public static final int WIDTH = gd.getDisplayMode().getWidth() / 3;
    public static final int HEIGHT = gd.getDisplayMode().getHeight() / 2;*/
    public static final int WIDTH = 650;
    public static final int HEIGHT = 850;
    public static final String TITLE = "TETRIS";

    private Thread gameThread;
    private boolean running = false;

    private Handler handler;

    public Game() {
        //todo handler, keyinput, HUD??

        handler = new Handler();

        ImageLoader loader = new ImageLoader();

        new Window(WIDTH, HEIGHT, TITLE, this);
    }

    public synchronized void start() {
        try {
            gameThread = new Thread(this);
            gameThread.start();
            running = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void stop() {
        try {
            gameThread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        this.requestFocus();
        long lastTime = System.nanoTime();
        double ticks = 60;
        double ns = 1000000000 / ticks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }


    public void tick() {
        handler.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }

}