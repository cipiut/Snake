import java.awt.*;

/**
 * Created by catalin on 03.12.2017.
 */
public class Meniu {

    public void render(Graphics g){
        g.setColor(new Color(100,123,123));
        g.fillRect(0,0,800,630);

        g.setColor(Color.BLACK);
        g.setFont(new Font("arial",1,72));
        g.drawString("Menu",300,100);


        if(Joc.choice==2||Joc.choice==3){
            g.setColor(Color.BLACK);
        }
        else if(Joc.choice==1){
            g.setColor(Color.YELLOW);
        }
        g.setFont(new Font("arial",1,50));
        g.drawString("Play",300,200);

        if(Joc.choice==1||Joc.choice==3){
            g.setColor(Color.BLACK);
        }
        else if(Joc.choice==2){
            g.setColor(Color.YELLOW);
        }
        g.setFont(new Font("arial",1,50));
        g.drawString("Dificultate",300,300);


        if(Joc.choice==1||Joc.choice==2){
            g.setColor(Color.BLACK);
        }
        else if(Joc.choice==3){
            g.setColor(Color.YELLOW);
        }
        g.setFont(new Font("arial",1,50));
        g.drawString("Quit",300,400);
    }


}
