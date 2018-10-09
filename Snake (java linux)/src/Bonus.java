import java.awt.*;

/**
 * Created by catalin on 03.12.2017.
 */
public class Bonus extends Forma{
    public Bonus(int pozx, int pozy)
    {
        super(pozx, pozy,ID.Bonus);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(pozx,pozy,30,30);
    }
}
