import java.awt.*;

public class Coada extends Forma {
    public Coada(int pozx, int pozy) {
        super(pozx, pozy,ID.Coada);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0,125, 0));
        g.fillRect(pozx,pozy,29,29);
    }
}
