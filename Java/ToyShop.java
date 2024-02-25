import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private Random random;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        random = new Random();
    }

    public void addToy(int id, String name, int count, double frequency) {
        Toy toy = new Toy(id, name, count, frequency);
        toys.add(toy);
    }

    public void changeFrequency(int id, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(newFrequency);
                break;
            }
        }
    }

    public boolean hasToys() {
        return toys.stream().anyMatch(Toy::hasCount);
    }

    public void playGame() {
        double totalFrequency = toys.stream().filter(Toy::hasCount).mapToDouble(Toy::getFrequency).sum();
        double randomValue = random.nextDouble() * totalFrequency;

        double sum = 0;
        for (Toy toy : toys) {
            if (toy.hasCount()) {
                sum += toy.getFrequency();
                if (randomValue <= sum) {
                    Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getFrequency());
                    prizeToys.add(prizeToy);
                    toy.countMinus();
                    break;
                }
            }
        }
    }

    public Toy getPrizeToy() {
        Toy prizeToy = prizeToys.remove(0);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write("Номер игрушки: " + prizeToy.getId() + ", Название игрушки: " + prizeToy.getName() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prizeToy;
    }

    public void displayRemainingToys() {
        System.out.println("Остатки игрушек:");
        for (Toy toy : toys) {
            System.out.println("Номер: " + toy.getId() + ", Название: " + toy.getName() + ", Количество: " + toy.getCount() + " шт.");
        }
    }
}
