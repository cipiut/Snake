import java.awt.*;
import java.awt.image.BufferStrategy;

public class Joc extends Canvas implements Runnable{
    public enum State{
        Game(),
        Dificultate(),
        Menu();
    }
    public static double timpBonus=0;
    private Meniu meniu;
    private Dificultate dificultate;
    static int choice=1;
    static State gameState;
    private Thread thread;
    public static boolean restart=false;
    public static boolean merge=true;
    private Handler handler;
    private HUD hud;
    private Dimension dimension = new Dimension(800,625);
    public static int viteza=900;//maxim 999
    private int nrBuffere=2;
    private void StartJoc(){
        HUD.score=0;
        restart=false;
        Keyboard.firstMove=true;
        Mar.nrMere= 0;
        timpBonus=0;
        GeneratorRandomMere m = new GeneratorRandomMere(handler);
        handler.addForma(new Coada(430,300));
        handler.addForma(new Coada(460,300));
        handler.addForma(m.generateMar());
    }
    public Joc(){
        meniu=new Meniu();
        dificultate= new Dificultate();
        gameState=State.Menu;
        this.handler = new Handler();
        this.hud= new HUD();
        new Window(this,dimension);
        handler.addForma(new Cap(400,300,handler));
        StartJoc();
        this.addKeyListener(new Keyboard((Cap)handler.shape.getFirst()));
    }
    public synchronized void start() {
        thread=new Thread(this);
        thread.start();
    }
    public void move(){
        if(gameState==State.Game) handler.move();
    }
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(nrBuffere);
            return;
        }
        Graphics g  = bs.getDrawGraphics();
        g.setColor(new Color(222,184,135));
        g.fillRect(0,0,800,600);
        if(gameState==State.Game){
            handler.render(g);
            hud.render(g);
        }
        else if(gameState==State.Menu){
            meniu.render(g);
        }
        else if(gameState==State.Dificultate){
            dificultate.render(g);
        }
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        this.requestFocus();
        while(merge){
            restart();
            move();
            render();
            if(handler.isBonus())timpBonus++;
            try {
                Thread.sleep(1000-viteza);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(timpBonus==50){
                timpBonus=0;
                handler.removeBonus();
            }
        }
        System.exit(1);
    }
    public void restart(){
        if(restart && gameState==State.Game) StartJoc();
    }

}