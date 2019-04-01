import java.util.ArrayList;
import java.util.List;

public class Greet {

    private List<String>name = new ArrayList<String>();
    private List<String> user = new ArrayList<String>();
    private int count;

    public Greet(){

    }


    public int getName(List enterName, int times) {
        user = enterName;
        count = times;
         if(name.size() == 0 ){
             name.add("Hellow " + user);
             System.out.println(name);
              return count;
         }
             return count;
    }
}
