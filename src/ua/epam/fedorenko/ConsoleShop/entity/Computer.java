package ua.epam.fedorenko.ConsoleShop.entity;


public class Computer extends Gadget {
    private String processor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Computer computer = (Computer) o;

        if (ramSize != computer.ramSize) return false;
        if (diskSize != computer.diskSize) return false;
        return processor.equals(computer.processor);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + processor.hashCode();
        result = 31 * result + ramSize;
        result = 31 * result + diskSize;
        return result;
    }

    private int ramSize;
    private int diskSize;

    public Computer(double price, double width, double height, String processor, int ramSize, int diskSize) {
        super(price, width, height);
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
    }

    public Computer() {
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    @Override
    public String toString() {
        return super.toString()+ " Computer{" + "processor='" + processor + '\'' + ", ramSize=" + ramSize + ", diskSize=" + diskSize + '}';
    }
}
