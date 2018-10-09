import java.awt.*;

public class Mar extends Forma {
    public static int nrMere;
    public Mar(int pozx, int pozy)
    {
        super(pozx, pozy,ID.Mar);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(200,0, 0));
        g.fillOval(pozx,pozy,30,30);
    }
}
