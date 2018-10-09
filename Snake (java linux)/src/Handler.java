import java.awt.*;
import java.util.LinkedList;

public class Handler {
    int a1,b1;
    LinkedList<Forma> shape=new LinkedList<Forma>();

    public void addForma(Forma f)
    {
        shape.add(f);
    }

    public void removeForma(Forma f)
    {
        shape.remove(f);
    }

    public void render(Graphics g) {
        for(int i=0;i<shape.size();i++)
        {
            shape.get(i).render(g);
        }
    }
    
    public void emptyList(){
        Cap p = (Cap)shape.getFirst();
        shape.clear();
        p.setPozx(400);
        p.setVelx(0);
        p.setVely(0);
        p.setPozy(300);
        shape.add(p);
    }

    public void removeBonus(){
        for(int i=0;i<shape.size();i++){
            if(shape.get(i).getId()== ID.Bonus){
                removeForma(shape.get(i));
            }
        }
    }

    public boolean isBonus(){
        for(int i=0;i<shape.size();i++){
            if(shape.get(i).getId()== ID.Bonus){
                return true;
            }
        }
        return false;
    }

    public int getUltimuX(){
        return a1;
    }
    public int getUltimuY(){
        return b1;
    }

    public void move() {
        Cap p = (Cap) shape.get(0);
        if (p.getVelx()!=0||p.getVely()!=0) {
            int a = shape.get(0).getPozx(), b = shape.get(0).getPozy();
            p.move();
            if(p.getPozx()>770)p.setPozx(0);
            if(p.getPozx()<0)p.setPozx(770);
            if(p.getPozy()<0)p.setPozy(570);
            if(p.getPozy()>570)p.setPozy(0);
            for (int i = 1; i < shape.size(); i++) {
                if (shape.get(i).getId() == ID.Coada) {
                    a1 = shape.get(i).getPozx();
                    b1 = shape.get(i).getPozy();
                    shape.get(i).setPozx(a);
                    shape.get(i).setPozy(b);
                    a = a1;
                    b = b1;
                }
            }
        }
    }
}
