import java.util.Random;

/**
 * Created by catalin on 30.11.2017.
 */
public class GeneratorRandomMere {
    Handler handler;
    public GeneratorRandomMere(Handler handler){
        this.handler=handler;
    }
    Random random= new Random();
    public Mar generateMar(){
        int x,y;
        while(true){
            int k=0;
            x=10+random.nextInt(730);
            y=10+random.nextInt(550);
            Mar mar = new Mar(x,y);
            for(int i=0;i<handler.shape.size();i++){
                if(!mar.getForma().intersects(handler.shape.get(i).getForma()))k++;
            }
            if(k==handler.shape.size())break;
        }
        return new Mar(x,y);
    }
    public Bonus generateBonus(){
        int x,y;
        while(true){
            int k=0;
            x=10+random.nextInt(730);
            y=10+random.nextInt(550);
            Bonus bonus = new Bonus(x,y);
            for(int i=0;i<handler.shape.size();i++){
                if(!bonus.getForma().intersects(handler.shape.get(i).getForma()))k++;
            }
            if(k==handler.shape.size())break;
        }
        return new Bonus(x,y);
    }
}
