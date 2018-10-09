import java.awt.*;

public class Cap extends Forma {
    private Handler handler ;
    private GeneratorRandomMere m;
    public Cap(int pozx, int pozy,Handler handler) {
        super(pozx, pozy,ID.Cap);
        this.handler=handler;
        m = new GeneratorRandomMere(this.handler);

    }
    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0,70, 0));
        g.fillRect(pozx,pozy,29,29);
    }

    public void move() {
        this.setPozx(getPozx()+getVelx());
        this.setPozy(getPozy()+getVely());
        coliziune();
    }
    public void coliziune(){
        double r=Joc.timpBonus;
        if(Joc.timpBonus==0)r=0;
        else r=1/r;
        for(int i=1;i<handler.shape.size();i++) {
            if (handler.shape.get(i).getForma().getBounds().intersects(this.getForma()) &&handler.shape.get(i).getId()==ID.Bonus){
                Bonus bonus = (Bonus)handler.shape.get(i);
                handler.removeForma(bonus);
                handler.addForma(new Coada(handler.getUltimuX(), handler.getUltimuY()));
                if (Joc.viteza == 900) HUD.score += (12+(long)(r*10000));
                else if (Joc.viteza == 925) HUD.score += (24+(long)(r*15000));
                else HUD.score += (48+(long)(r*20000));
                mancat();
                Joc.timpBonus=0;
                return;
            }
            if (handler.shape.get(i).getForma().getBounds().intersects(this.getForma()) &&(handler.shape.get(i).getId()==ID.Mar)){
                handler.removeForma(handler.shape.get(i));
                handler.addForma(new Coada(handler.getUltimuX(), handler.getUltimuY()));
                if (Joc.viteza == 900) HUD.score += 12;
                else if (Joc.viteza == 925) HUD.score += 24;
                else HUD.score += 48;
                mancat();
                return;
            }
            if(this.getForma().intersects(handler.shape.get(i).getForma())&&handler.shape.get(i).getId()==ID.Coada){
                Joc.gameState= Joc.State.Menu;
                handler.emptyList();
                Joc.restart=true;
                return;
            }
        }
    }
    public void mancat(){
        for(int i=0;i<handler.shape.size();i++){
            if(handler.shape.get(i).getId()==ID.Mar)return;
        }
        handler.addForma(m.generateMar());
        Mar.nrMere++;
        if(Mar.nrMere%8==0){
            handler.addForma(m.generateBonus());
            Joc.timpBonus=0;
        }
    }
}
