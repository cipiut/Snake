import java.awt.*;

public abstract class Forma {
    public int pozx,pozy,velx,vely;
    public ID id;
    public Forma(int pozx, int pozy,ID id)
    {
        this.pozx=pozx;
        this.pozy=pozy;
        this.id=id;
    }

    public int getPozx() {
        return pozx;
    }

    public int getPozy() {
        return pozy;
    }

    public int getVelx() {
        return velx;
    }

    public int getVely() {
        return vely;
    }

    public void setPozx(int pozx) {
        this.pozx = pozx;
    }

    public void setPozy(int pozy) {
        this.pozy = pozy;
    }

    public void setVelx(int velx) {
        this.velx = velx;
    }

    public void setVely(int vely) {
        this.vely = vely;
    }

    public ID getId() {
        return id;
    }

    public abstract void render(Graphics g);
    public Rectangle getForma(){
        return new Rectangle(this.getPozx(),this.getPozy(),29,29);
    }
}
