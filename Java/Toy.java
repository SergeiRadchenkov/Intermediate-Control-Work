public class Toy {
    private int id;
    private String name;
    private int count;
    private double frequency;
    
    public Toy(int id, String name, int count, double frequency) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void countMinus() {
        count--;
    }

    public boolean hasCount() {
        return count > 0;
    }
}