import java.awt.*;

/**
 * Created by catalin on 03.12.2017.
 */
public class HUD {
    public static long score = 0;

    public void render(Graphics g) {
        g.setFont(new Font("arial", 1, 20));
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 30);
        if (Joc.timpBonus!=0) {
            g.setFont(new Font("arial", 1, 20));
            g.setColor(Color.WHITE);
            g.drawString("Timp Bonus:", 10, 50);

            g.setColor(Color.blue);
            g.fillRect(10,60, 50-(int)Joc.timpBonus, 20);
            g.setColor(Color.WHITE);
            g.drawRect(10,60,50-(int)Joc.timpBonus, 20);

        }

    }
}
