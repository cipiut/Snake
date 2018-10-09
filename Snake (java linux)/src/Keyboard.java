import jdk.nashorn.internal.scripts.JO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {
    private Cap h;
    public static boolean firstMove=true;
    public Keyboard(Cap h) {
        this.h = h;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_Q){
            Joc.merge=false;
        }
        if (Joc.gameState == Joc.State.Game) {
            if (h.getVelx() == 0 && key == KeyEvent.VK_LEFT) {
                h.setVelx(-30);
                h.setVely(0);
                firstMove=false;
            }
            if(!firstMove) {
                if (h.getVelx() == 0 && key == KeyEvent.VK_RIGHT) {
                    h.setVelx(30);
                    h.setVely(0);
                    firstMove=false;
                }
            }
            if (h.getVely() == 0 && key == KeyEvent.VK_UP) {
                h.setVelx(0);
                h.setVely(-30);
                firstMove=false;
            }
            if (h.getVely() == 0 && key == KeyEvent.VK_DOWN) {
                h.setVelx(0);
                h.setVely(30);
                firstMove=false;
            }
        }
        else if (Joc.gameState == Joc.State.Menu) {
            if (key == KeyEvent.VK_DOWN) {
                Joc.choice++;
            }
            if ( key == KeyEvent.VK_UP) {
                Joc.choice--;
            }
            if(Joc.choice>3)Joc.choice=1;
            if(Joc.choice<=0)Joc.choice=3;
            if (key == KeyEvent.VK_ENTER&& Joc.choice==1) {
                Joc.gameState= Joc.State.Game;
                Joc.choice=1;
            }
            if (key == KeyEvent.VK_ENTER&& Joc.choice==2) {
                Joc.gameState= Joc.State.Dificultate;
                Joc.choice=1;
            }
            if (key == KeyEvent.VK_ENTER&& Joc.choice==3) {
                Joc.merge=false;
                Joc.choice=1;
            }
        }
        else if (Joc.gameState == Joc.State.Dificultate) {
            if(key == KeyEvent.VK_ESCAPE)Joc.gameState= Joc.State.Menu;
            if (key == KeyEvent.VK_DOWN) {
                Joc.choice++;
            }
            if ( key == KeyEvent.VK_UP) {
                Joc.choice--;
            }
            if(Joc.choice>3)Joc.choice=1;
            if(Joc.choice<=0)Joc.choice=3;
            if (key == KeyEvent.VK_ENTER&& Joc.choice==1) {
                Joc.viteza=900;
                Joc.gameState= Joc.State.Game;
            }
            if (key == KeyEvent.VK_ENTER&& Joc.choice==2) {
                Joc.viteza=925;
                Joc.gameState= Joc.State.Game;
                Joc.choice=1;
            }
            if (key == KeyEvent.VK_ENTER&& Joc.choice==3) {
                Joc.viteza=950;
                Joc.gameState= Joc.State.Game;
                Joc.choice=1;
            }
        }
    }

}
