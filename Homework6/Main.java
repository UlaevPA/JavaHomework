package Homework6;

import java.util.*;

import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добрый день, давайте сгенерируем наши ноутбуки");
        System.out.println("для этого необходимо ввести количество ноутбуков в наличии");
        System.out.println(">>> ");
        Scanner scanner = new Scanner(System.in);
        int quantityLaptops = scanner.nextInt();
        ArrayList<Laptop> laptops = generateLaptops(quantityLaptops);
        System.out.println("Вывести список ноутбуков (Y/N)?");
        System.out.println(">>> ");
        char choise = scanner.next().charAt(0);
        switch (choise) {
            case 'Y':
            case 'y':
                printLaptops(laptops);
                break;
            case 'N':
            case 'n':
                break;
            default:
                System.out.println("Необходимо ввести Y или N");
        }
        System.out.println("предлагаем Вам отфильтровать ноутбуки исходя из параметров");
        System.out.println("для настройки фильтра введите через Enter код необходимого фильтра, после чего введите S");
        System.out.println("1 - ОЗУ\n2 - Объем жесткого диска\n3 - Операционная система\n4 - цвет");

        Set<Laptop> listChoise = filterLaptops(laptops);
        printLaptopsSet(listChoise);
    }

    static Set<Laptop> filterLaptops(ArrayList<Laptop> lapList) {
        Set<Laptop> sortedList = new HashSet<>(lapList);
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        Set<Integer> choiseMap = new HashSet<>();
        boolean flag = true;
        while (flag) {
            char userData = scanner.next().charAt(0);
            if (userData == 's' || userData == 'S') {
                flag = false;
            } else {
                int num = Integer.parseInt(String.valueOf(userData));
                choiseMap.add(num);
                count++;
                if (count == 4) {
                    flag = false;
                }
            }
        }
        for (int i = 0; i < choiseMap.size(); i++) {
            switch ((int) choiseMap.toArray()[i]) {
                case 1:
                    sortedList = Laptop.sortRAM(sortedList);
                    break;
                case 2:
                    sortedList = Laptop.sortHDD(sortedList);
                    break;
                case 3:
                    sortedList = Laptop.sortOS(sortedList);
                    break;
                case 4:
                    sortedList = Laptop.sortColor(sortedList);
                    break;
            }
        }
        return sortedList;
    }

    static ArrayList<Laptop> generateLaptops(int n) {
        ArrayList<Laptop> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new Laptop());
        }
        return result;
    }

    static void printLaptops(ArrayList<Laptop> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("-------------------------------");
            System.out.println(list.toArray()[i].toString());
            System.out.println("-------------------------------");
        }
    }

    static void printLaptopsSet(Set<Laptop> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("-------------------------------");
            System.out.println(list.toArray()[i].toString());
            System.out.println("-------------------------------");
        }
    }


}