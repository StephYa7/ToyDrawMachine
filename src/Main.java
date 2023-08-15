import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Toy> toys = new ArrayList<Toy>();
    public static List<Toy> winningToysWaiting = new ArrayList<Toy>();

    public static void main(String[] args) {
        Toy a = new Toy(01, "aa", 12, 1);
        Toy b = new Toy(02, "bb", 3, 5);
        Toy c = new Toy(03, "cc", 31, 3.5);
        Toy d = new Toy(04, "dd", 2, 10);

        toys.add(a);
        toys.add(b);
        toys.add(c);
        toys.add(d);
        chooseWinningToy();


    }


    public static Toy chooseWinningToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += (toy.getWinWeight() * toy.getCount());
        }
        System.out.println(totalWeight);


        return null;
    }


}