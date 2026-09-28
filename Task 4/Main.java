
// 1, 2, 4, 7, 10
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public void menu() {
        System.out.println("\n            Меню задач");
        System.out.println("1. Поиск первого вхождения значения");
        System.out.println("2. Поиск последнего вхождения значения");
        System.out.println("4. Добавление элемента в массив");
        System.out.println("7. Обратный массив");
        System.out.println("10. ПОложительный массив");
        System.out.println("0.Выйти из программы\n");
        System.out.print("Введите номер задачи: ");
    }

    public int checkInt(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: нужно ввести целое число");
                scanner.next();
                continue;
            }
            int x = scanner.nextInt();
            return x;
        }
    }

    public int checkIntPositive(Scanner scanner) {
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

    public int[] readArray(Scanner scanner) {
        System.out.print("Введите количество элементов массива: ");
        int size = checkIntPositive(scanner);

        int[] array = new int[size];
        System.out.println("Вводите элементы массива");

        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array[i] = checkInt(scanner);
        }

        System.out.println("Получившийся массив: " + Arrays.toString(array));
        return array;
    }

    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public int[] add(int[] arr, int x, int pos) {
        int[] newArray = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            newArray[i] = arr[i];
        }

        newArray[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            newArray[i + 1] = arr[i];
        }

        return newArray;
    }

    public int[] reverseBack(int[] arr) {
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[arr.length - i - 1];
        }
        return newArray;
    }

    public int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                count++;
        }

        int[] newArray = new int[count];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                newArray[j] = arr[i];
                j++;
            }
        }
        return newArray;
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

                case 1: {
                    int[] array = obj.readArray(scanner);

                    System.out.print("Введите целое число для поиска его первого вхождения: ");
                    int x = obj.checkInt(scanner);
                    System.out.println("Результат: " + obj.findFirst(array, x));
                    break;
                }

                case 2: {
                    int[] array = obj.readArray(scanner);

                    System.out.print("Введите целое число для поиска его последнего вхождения: ");
                    int x = obj.checkInt(scanner);
                    System.out.println("Результат: " + obj.findLast(array, x));
                    break;
                }

                case 4: {
                    int[] array = obj.readArray(scanner);

                    System.out.print("Введите целое число, которое нужно вставить в массив: ");
                    int x = obj.checkInt(scanner);

                    int pos;
                    while (true) {
                        System.out.print("Введите позицию (0.." + array.length + "): ");
                        pos = obj.checkIntPositive(scanner);
                        if (pos > array.length) {
                            System.out.println("Ошибка: позиция вне диапазона");
                            continue;
                        }
                        break;
                    }

                    System.out.println("Итоговый массив: " + Arrays.toString(obj.add(array, x, pos)));
                    break;
                }

                case 7: {
                    int[] array = obj.readArray(scanner);
                    System.out.println("Обратный массив: " + Arrays.toString(obj.reverseBack(array)));
                    break;
                }

                case 10: {
                    int[] array = obj.readArray(scanner);
                    System.out.println("Положительный массив: " + Arrays.toString(obj.deleteNegative(array)));
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