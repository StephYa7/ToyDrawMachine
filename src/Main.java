import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static List<Toy> toys = new ArrayList<>();
    public static Queue<Toy> winningToysWaiting = new ArrayDeque<>();

    public static File file = new File("src/listOfGivenToys.txt");

    public static void main(String[] args) {
        Toy a = new Toy(01, "aa", 5, 1);
        Toy b = new Toy(02, "bb", 5, 5);
        Toy c = new Toy(03, "cc", 5, 3.5);
        Toy d = new Toy(04, "dd", 5, 7);
        Toy e = new Toy(04, "ee", 5, 6);
        Toy f = new Toy(04, "ff", 5, 1.2);
        toys.add(a);
        toys.add(b);
        toys.add(c);
        toys.add(d);
        toys.add(e);
        toys.add(f);

        chooseWinningToy();
        chooseWinningToy();
        chooseWinningToy();
        getPrizeFromQueue();
        getPrizeFromQueue();
        getPrizeFromQueue();
        getPrizeFromQueue();
        System.out.println(toys);
        System.out.println(winningToysWaiting);

    }


    public static void chooseWinningToy() {
        if (toys.size() == 0) {
            System.out.println("Toys not found!");
            return;
        }
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += (toy.getWinWeight() * toy.getCount());
        }
        double winNumber = (Math.random() * totalWeight);
        for (Toy toy : toys) {
            winNumber -= (toy.getWinWeight() * toy.getCount());
            if (winNumber < 0) {
                winningToysWaiting.add(toy);
                toy.setCount(toy.getCount() - 1);
                if (toy.getCount() < 1) toys.remove(toy);
                return;
            }
        }
    }

    public static void getPrizeFromQueue() {
        LocalDateTime ldt = LocalDateTime.now();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            if (winningToysWaiting.size() > 0) {
                Toy buf = winningToysWaiting.poll();
                writer.write(String.format("Игрушка %s была выдана %s\r", buf.getName(), ldt));
            } else System.out.println("No toys waiting to be given out!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printChance() {
        int countToys = 0;
        int totalWeight = 0;
        int totalChance = 0;
    }
}