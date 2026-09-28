// 2, 3, 6, 8, 9
import java.util.Scanner;

public class Main {

    public void menu() {
        System.out.println("\n            Меню задач");
        System.out.println("2. Числа от x до 0");
        System.out.println("3. Чётные числа от 0 до x");
        System.out.println("6. Состоит ли число из одинаковых цифр");
        System.out.println("8. Левый треугольник");
        System.out.println("9. Правый треугольник");
        System.out.println("0.Выйти из программы\n");
        System.out.print("Введите номер задачи: ");
    }

    public int checkInt(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: нужно ввести натуральное число");
                scanner.next();
                continue;
            }
            int x = scanner.nextInt();
            if (x < 0) {
                System.out.println("Ошибка: нужно ввести натуральное число");
                continue;
            }
            return x;
        }
    }

    public String reverseListNums(int x) {
        String string = "";
        for (int i = x; i >= 0; i--) {
            string = string + i + " ";
        }
        return "Результат: " + string;
    }

    public String chet(int x) {
        if (!(x % 2 == 0)) {
            x = x - 1;
        }
        String string = "";
        for (int i = 0; i <= x; i = i + 2) {
            string = string + i + " ";
        }
        return "Результат: " + string;
    }

    public boolean equalNum(int x) {
        int n = x % 10;
        while (x > 0) {
            if (x % 10 != n)
                return false;
            x = x / 10;
        }
        return true;
    }

    public void leftTriangle(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {

            obj.menu();

            if (!scanner.hasNextInt()) {
                System.out.println("Неверный ввод");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 2: {
                    System.out.print("Введите натуральное число: ");
                    int x = obj.checkInt(scanner);
                    System.out.println(obj.reverseListNums(x));
                    break;
                }

                case 3: {
                    System.out.print("Введите натуральное число: ");
                    int x = obj.checkInt(scanner);
                    System.out.println(obj.chet(x));
                    break;
                }

                case 6: {
                    System.out.print("Введите целое число: ");
                    int x;
                    while (true) {
                        if (!scanner.hasNextInt()) {
                            System.out.println("Ошибка: нужно ввести целое число");
                            scanner.next();
                            continue;
                        }
                        x = scanner.nextInt();
                        if (x < 0)
                            x = -x;
                        break;
                    }
                    System.out.println("Результат: " + obj.equalNum(x));
                    break;
                }

                case 8: {
                    System.out.print("Введите натуральное число для построения левого треугольника: ");
                    int x = obj.checkInt(scanner);
                    System.out.println("Результат:");
                    obj.leftTriangle(x);
                    break;
                }

                case 9: {
                    System.out.print("Введите натуральное число для построения правого треугольника: ");
                    int x = obj.checkInt(scanner);
                    System.out.println("Результат:");
                    obj.rightTriangle(x);
                    break;
                }

                case 0:
                    System.out.println("Спасибо за пользование ^^");
                    break;

                default:
                    System.out.println("Ошибочка: такой задачи нет");
                    break;
            }
        }

        scanner.close();
    }
}