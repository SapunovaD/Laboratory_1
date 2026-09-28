// 1, 4, 5, 7, 9
import java.util.Scanner;

public class Main {

    public void menu() {
        System.out.println("\n            Меню задач");
        System.out.println("1. Модуль числа");
        System.out.println("4. Сравнение двух чисел");
        System.out.println("5. Максимальное из трех чисел");
        System.out.println("7. Сумма двух чисел");
        System.out.println("9. Какой день недели?");
        System.out.println("0.Выйти из программы\n");
        System.out.print("Введите номер задачи: ");
    }

    public boolean checkInt(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Нужно целое число");
            scanner.next();
            return false;
        }
        return true;
    }

    public int abs(int x) {
        if (x < 0)
            return -x;
        return x;
    }

    public String makeDecision(int x, int y) {
        if (x > y)
            return x + " > " + y;
        if (x < y)
            return x + " < " + y;
        return x + " == " + y;
    }

    public int max3(int x, int y, int z) {
        if (x > y)
            y = x;
        if (z > y)
            y = z;
        return y;
    }

    public int sum2(int x, int y) {
        if (x + y >= 10 && x + y <= 19)
            return 20;
        return x + y;
    }

    public String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {

            obj.menu();

            if (!obj.checkInt(scanner))
                continue;
            choice = scanner.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Введите целое число для получения его модуля: ");
                    if (!obj.checkInt(scanner))
                        break;
                    int num = scanner.nextInt();
                    System.out.println("Результат: " + obj.abs(num));
                    break;
                }

                case 4: {
                    System.out.println("Введите два целых числа для сравнения");
                    System.out.print("x = ");
                    if (!obj.checkInt(scanner))
                        break;
                    int x = scanner.nextInt();

                    System.out.print("y = ");
                    if (!obj.checkInt(scanner))
                        break;
                    int y = scanner.nextInt();

                    System.out.println("Результат: " + obj.makeDecision(x, y));
                    break;
                }

                case 5: {
                    System.out.println("Введите три целых числа для поиска максимального");
                    System.out.print("x = ");
                    if (!obj.checkInt(scanner))
                        break;
                    int x = scanner.nextInt();

                    System.out.print("y = ");
                    if (!obj.checkInt(scanner))
                        break;
                    int y = scanner.nextInt();

                    System.out.print("z = ");
                    if (!obj.checkInt(scanner))
                        break;
                    int z = scanner.nextInt();

                    System.out.println("Результат: " + obj.max3(x, y, z));
                    break;
                }

                case 7: {
                    System.out.println("Введите два целых числа для вычисления суммы.");
                    System.out.println("Если сумма от 10 до 19, то вывод: 20");
                    System.out.print("x = ");
                    if (!obj.checkInt(scanner))
                        break;
                    int x = scanner.nextInt();

                    System.out.print("y = ");
                    if (!obj.checkInt(scanner))
                        break;
                    int y = scanner.nextInt();

                    System.out.println("Результат: " + obj.sum2(x, y));
                    break;
                }

                case 9: {
                    System.out.print("Введите номер дня недели для вывода его названия: ");
                    if (!obj.checkInt(scanner))
                        break;
                    int today = scanner.nextInt();
                    System.out.println("Результат: " + obj.day(today));
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