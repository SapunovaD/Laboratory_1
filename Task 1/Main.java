import java.util.Scanner;

public class Main {

    public void menu() {
        System.out.println("\n            Меню задач");
        System.out.println("3. Из символа (1, 2, 3, 4, 5, 6, 7, 8, 9) в цифру");
        System.out.println("4. Положительное число или нет (0 - положительное)");
        System.out.println("6. Заглавная буква или нет (от A до Z)");
        System.out.println("8. Делит ли одно из чисел другое нацело");
        System.out.println("10. Сумма цифр двух чисел из разряда единиц. Последовательное сложение пяти чисел");
        System.out.println("0.Выйти из программы\n");
        System.out.print("Введите номер задачи: ");
    }

    public int charToNum(char x) {
        return x - '0';
    }

    public boolean isPositive(int x) {
        return x >= 0;
    }

    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public boolean isDivisor(int a, int b) {
        if (a == 0 || b == 0)
            return false;
        return a % b == 0 || b % a == 0;
    }

    public int lastNumSum(int a, int b) {
        return (a % 10) + (b % 10);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {

            obj.menu();

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка, нужно ввести целое число");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 3:
                    System.out.print("Введите цифру (0-9): ");
                    String symbol = scanner.next();
                    if (symbol.length() != 1 || symbol.charAt(0) < '0' || symbol.charAt(0) > '9') {
                        System.out.println("Неправильный ввод");
                    } else {
                        char num = symbol.charAt(0);
                        System.out.println("Результат: " + obj.charToNum(num));
                    }
                    break;

                case 4:
                    System.out.print("Введите целое число: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка, нужно ввести целое число");
                        scanner.next();
                    } else {
                        int number = scanner.nextInt();
                        System.out.println("Результат: " + obj.isPositive(number));
                    }
                    break;

                case 6:
                    System.out.print("Введите букву: ");
                    String letter = scanner.next();
                    if (letter.length() != 1 || !((letter.charAt(0) >= 'A' && letter.charAt(0) <= 'Z')
                            || (letter.charAt(0) >= 'a' && letter.charAt(0) <= 'z'))) {
                        System.out.println("Неправильный ввод: нужна одна английская буква");
                    } else {
                        char letterChar = letter.charAt(0);
                        System.out.println("Результат: " + obj.isUpperCase(letterChar));
                    }
                    break;

                case 8:
                    System.out.println("Введите два целых числа ");
                    System.out.print("a = ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка, нужно ввести целое число");
                        scanner.next();
                        break;
                    }

                    int a = scanner.nextInt();
                    System.out.print("b = ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка, нужно ввести целое число");
                        scanner.next();
                        break;
                    }

                    int b = scanner.nextInt();
                    System.out.println("Результат: " + obj.isDivisor(a, b));
                    break;

                case 10:
                    System.out.println("Нужно ввести пять целых чисел");
                    System.out.print("Введите 1 число: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка, нужно было ввести целое число");
                        scanner.next();
                        break;
                    }

                    int x = scanner.nextInt();

                    for (int i = 2; i < 6; i++) {
                        System.out.print("Введите " + i + " число: ");

                        while (!scanner.hasNextInt()) {
                            System.out.print("Ошибка, введи целое число: ");
                            scanner.next();
                        }

                        int y = scanner.nextInt();
                        System.out.print(x + " + " + y + " это ");
                        x = obj.lastNumSum(x, y);
                        System.out.println(x);

                    }

                    System.out.println("Итого: " + x);
                    break;

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