package Homework6;
import java.text.Format;
import java.util.*;

public class Laptop {
    String brand, color, operationSystem;
    int ram, hdd, serialNum;
    double price;

    public Laptop(String b, String c, String os, int r, int h, double p, int sn) {
        this.brand = b;
        this.color = c;
        this.operationSystem = os;
        this.ram = r;
        this.hdd = h;
        this.price = p;
        this.serialNum = sn;
    }

    public Laptop() {
        Random random = new Random();
        this.brand = brands.get(random.nextInt(0, brands.size()));
        this.color = colors.get(random.nextInt(0, colors.size()));
        this.operationSystem = operationSystems.get(random.nextInt(0, operationSystems.size()));
        this.ram = rams.get(random.nextInt(0, rams.size()));
        this.hdd = hdds.get(random.nextInt(0, hdds.size()));
        this.price = random.nextInt(7, 10)*1.00/10 * random.nextInt(60000, 250000);
        this.serialNum = random.nextInt(1_000_000, 2_000_000);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Laptop){
            Laptop laptop = (Laptop) obj;
            return brand.equals(laptop.brand) && color.equals(laptop.color) && operationSystem.equals(laptop.operationSystem)
                    && ram == laptop.ram && hdd == laptop.hdd && price == laptop.price && serialNum == laptop.serialNum;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 2*brands.hashCode()+3*color.hashCode()+4*operationSystem.hashCode()+5*ram+6*hdd+(int)(price*100)+serialNum;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s\t Price: %.2f\nOS: %s, RAM: %d, HDD: %d, Color: %s\ns/n: %d", brand, price, operationSystem, ram, hdd, color, serialNum);
    }

    public static Set<Laptop> sortRAM(Set<Laptop> list) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> uniqValues = new HashSet<>();
        Set<Laptop> result = new HashSet<>();
        System.out.println("введите критерий поиска по ОЗУ (например: <8 или >2 или =4)");
        for (Laptop laptop : list) {
            uniqValues.add(laptop.ram);
        }
        System.out.println("возможные варианты: " + uniqValues.toString());
        System.out.println(">>> ");
        String userString = scanner.next();
        int tmp = Integer.parseInt(userString.substring(1));
        switch (userString.charAt(0)) {
            case (char) '<':
                for (Laptop laptop : list) {
                    if (laptop.ram < tmp) {
                        result.add(laptop);
                    }
                }
                break;
            case (char) '>':
                for (Laptop laptop : list) {
                    if (laptop.ram > tmp) {
                        result.add(laptop);
                    }
                }
                break;
            case (char) '=':
                for (Laptop laptop : list) {
                    if (laptop.ram == tmp) {
                        result.add(laptop);
                    }
                }
                break;
        }
        return result;
    }

    public static Set<Laptop> sortHDD(Set<Laptop> list) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> uniqValues = new HashSet<>();
        Set<Laptop> result = new HashSet<>();
        System.out.println("введите критерий поиска по объему HDD (например: <1024 или >256 или =512");
        for (Laptop laptop : list) {
            uniqValues.add(laptop.hdd);
        }
        System.out.println("возможные варианты: " + uniqValues.toString());
        System.out.println(">>> ");
        String userString = scanner.next();
        int tmp = Integer.parseInt(userString.substring(1));
        switch (userString.charAt(0)) {
            case (char) '<':
                for (Laptop laptop : list) {
                    if (laptop.hdd < tmp) {
                        result.add(laptop);
                    }
                }
                break;
            case (char) '>':
                for (Laptop laptop : list) {
                    if (laptop.hdd > tmp) {
                        result.add(laptop);
                    }
                }
                break;
            case (char) '=':
                for (Laptop laptop : list) {
                    if (laptop.hdd == tmp) {
                        result.add(laptop);
                    }
                }
                break;
        }
        return result;
    }

    public static Set<Laptop> sortOS(Set<Laptop> list) {
        Scanner scanner = new Scanner(System.in);
        Set<String> uniqValues = new HashSet<>();
        Set<Laptop> result = new HashSet<>();
        System.out.println("введите операционную систему: ");
        for (Laptop laptop : list) {
            uniqValues.add(laptop.operationSystem);
        }
        System.out.println("возможные варианты: " + uniqValues.toString());
        System.out.println(">>> ");
        String userString = scanner.next();
        for (Laptop laptop : list) {
            if (laptop.operationSystem.equals(userString)) {
                result.add(laptop);
            }
        }
        return result;
    }

    public static Set<Laptop> sortColor(Set<Laptop> list) {
        Scanner scanner = new Scanner(System.in);
        Set<String> uniqValues = new HashSet<>();
        Set<Laptop> result = new HashSet<>();
        System.out.println("введите цвет: ");
        for (Laptop laptop : list) {
            uniqValues.add(laptop.color);
        }
        System.out.println("возможные варианты: " + uniqValues.toString());
        System.out.println(">>> ");
        String userString = scanner.next();
        for (Laptop laptop : list) {
            if (laptop.color.equals(userString)) {
                result.add(laptop);
            }
        }
        return result;
    }

    ArrayList<String> brands = new ArrayList<>(Arrays.asList("Lenovo", "HP", "Huawei", "Acer", "ASUS", "MSI"));
    ArrayList<String> colors = new ArrayList<>(Arrays.asList("Black", "Grey", "Dark blue", "Red","White"));
    ArrayList<String> operationSystems = new ArrayList<>(Arrays.asList("Windows", "Linux", "no operation system"));
    ArrayList<Integer> rams = new ArrayList<>(Arrays.asList(4, 8, 16, 32, 64));
    ArrayList<Integer> hdds = new ArrayList<>(Arrays.asList(512, 1024, 2048, 4096));
}