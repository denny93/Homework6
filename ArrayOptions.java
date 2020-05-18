package Main;

import java.util.Random;
import java.util.Scanner;

public class ArrayOptions {

    public static void main(String[] args) {
        System.out.println("1. Работа с числа");
        System.out.println("2. Работа с думи");
        System.out.println("3. Изход");

        System.out.print("Моля изберете опция от менюто. ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        switch (option) {
            case 1:
                workWithNumbers();
                break;
            case 2:
                workWithWords();
                break;
            case 3:
                Exit();
                break;

            default:
                break;
        }


    }

    public static void workWithNumbers() {
        System.out.print("Моля въведете колко числа ще използвате");
        Scanner scan = new Scanner(System.in);
        int lenght_of_array = scan.nextInt();

        int[] array = new int[lenght_of_array];


        System.out.print("Моля въведете стойностите!");
        for (int i = 0; i < lenght_of_array; i++) {

            scan = new Scanner(System.in);
            int number = scan.nextInt();
            if (number > 1 && number < 10000) {
                array[i] = number;
            } else {
                System.out.print("Моля въведете число по-голямо от 1 и по-малко от 10 000");
                i--;
            }

        }

        System.out.println("1. Извеждане само на простите числа от масива");
        System.out.println("2. Извеждане на най-често срещан елемент в масива");
        System.out.println("3. Извеждане на максимална редица от нарастващи елементи в масива");
        System.out.println("4. Извеждане на максимална редица от намаляваши елементи в масива");
        System.out.println("5.  Извеждане на максимална редица от еднакви елементи в масива");
        System.out.println("6. Извеждане на последователност от числа от масива,които имат сума равна на числор," +
                "генерирано на случаен принцип.");
        System.out.println("7. Връщане назад към основното меню.");

        scan = new Scanner(System.in);
        int user_choise = scan.nextInt();
        switch (user_choise) {
            case 1:
                prostiChisla();
                break;
            case 2:
                sreshtan();
                break;
            case 3:
                maxUpper(array);
                break;
            case 4:
                maxDown(array);
                break;
            case 5:
                maxDouble(array);
                break;
            case 6:
                posledovatelnost(array);
                break;
            case 7:
                refresh();
                break;
            default:
                break;
        }


    }

    private static void prostiChisla() {
    }

    private static void sreshtan() {

    }

    private static void maxUpper(int[] array) {

        int[] array_max = new int[10];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = array[i] + 1;
            if (i + 1 >= array.length) {
                break;
            }
            if (array[i + 1] == sum) {
                array_max[count] = array[i];
                count++;
            } else {
                if (i - 1 < 0) {
                    continue;
                }
                int sum2 = array[i] - 1;
                if (array[i - 1] == sum2) {
                    array_max[count] = array[i];
                    count++;
                }
            }

        }
        StringBuilder text = new StringBuilder("{");

        for (int arrayMax : array_max) {
            if (arrayMax == 0) {
                break;
            } else {
                text.append(arrayMax).append(", ");
            }
        }
        text.append(" }");
        System.out.print("Number is " + text);
    }

    private static void maxDown(int[] array) {
        int[] array_max = new int[10];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = array[i] - 1;
            if (i + 1 >= array.length) {
                break;
            }
            if (array[i + 1] == sum) {
                array_max[count] = array[i];
                count++;
            } else {
                if (i - 1 < 0) {
                    continue;
                }
                int sum2 = array[i] - 1;
                if (array[i + 1] != sum2) {
                    array_max[count] = array[i];
                    count++;
                }
            }

        }
        StringBuilder text = new StringBuilder("{");
        for (int arrayMax : array_max) {
            if (arrayMax == 0) {
                break;
            } else {
                text.append(arrayMax).append(", ");
            }
        }
        text.append(" }");
        System.out.print("Number is " + text);
    }

    private static void maxDouble(int[] array) {
        int[] indexes = new int[array.length];

        int index = 1;
        for (int i = 0; i < array.length; i++) {

            if (i + 1 >= array.length) {
                if (array[i] == array[i - 1]) {
                    indexes[i] = index;
                }
                break;
            }
            if (i - 1 < 0) {
                indexes[i] = index;
            } else {
                if (array[i] == array[i - 1]) {
                    indexes[i] = index;
                } else {
                    indexes[i] = index + 1;
                    index++;
                }
            }
        }
        int[] number = new int[array.length];
        int[] sreshtaniq = new int[array.length];

        int count = 0;
        for (int value : indexes) {
            boolean isOK = false;
            for (int j = 0; j < number.length; j++) {
                if (number[j] == value) {
                    sreshtaniq[j] += 1;
                    isOK = true;
                }
            }
            if (!isOK) {
                number[count] = value;
                sreshtaniq[count] += 1;
                count++;
            }
        }
        boolean isEquals = true;
        for (int i = 1; i < sreshtaniq.length; i++) {
            if (sreshtaniq[i - 1] == sreshtaniq[i] && sreshtaniq[i] != 0) {
                isEquals = false;
                break;
            }
        }
        if (isEquals) {
            int counts = 0;
            for (int i = 1; i < sreshtaniq.length; i++) {
                if (sreshtaniq[i] == 0) {
                    continue;

                }
                int max = 1;
                if (sreshtaniq[i] > max) {
                    counts = i;
                }
            }
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < indexes.length; i++) {
                if (indexes[i] == number[counts]) {
                    text.append(array[i]).append(", ");
                }
            }
            System.out.println(text);
        }
    }

    private static void posledovatelnost(int[] array) {
        Random rand = new Random();
        int random = rand.nextInt(30);
        int start_index = 0;
        int end_index = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isOK = false;
            start_index = i;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum == random) {
                    end_index = j;
                    isOK = true;
                }
            }
            if (isOK) {
                break;
            }
        }

        if (end_index == 0) {
            System.out.print("Няма комбинация!");
            return;
        }
        StringBuilder text = new StringBuilder();
        for (int i = start_index; i < end_index; i++) {
            text.append(array[i]).append(", ");
        }
        System.out.print(text);
    }

    private static void refresh() {
        main(new String[10]);
    }


    public static void workWithWords() {
        System.out.print("Моля въведете колко думи ще използвате.");
        Scanner scan = new Scanner(System.in);
        int lenght_of_array = scan.nextInt();

        String[] array = new String[lenght_of_array];


        System.out.print("Моля въведете стойностите!");
        int i = 0;
        while (i < lenght_of_array) {
            i++;
        }

        System.out.println("1. Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата.");
        System.out.println("2. Изведете броя на повтарящите се символи за всяка една от думите в масива.");
        System.out.println("3.  Изведете броя на символите за всяка една от думите в масива.");
        System.out.println("4. Изведете броя на повтарящите се думи от масива.");
        System.out.println("5. Връщане назад към основното меню. ");

        scan = new Scanner(System.in);
        int user_choise = scan.nextInt();
        switch (user_choise) {
            case 1:
                back(array);
                break;
            case 2:
                count();
                break;
            case 3:
                countChar(array);
                break;
            case 4:
                repearWord(array);
                break;
            case 5:
                refresh();
                break;

            default:
                break;
        }

    }

    private static void repearWord(String[] array) {
        String[] repeat = new String[array.length];
        int[] sreshtaniq = new int[repeat.length];
        int count = 0;
        for (String s : array) {
            boolean isOK = false;
            for (int j = 0; j < repeat.length; j++) {
                if (repeat[j].toLowerCase().equals(s.toLowerCase())) {
                    sreshtaniq[j] += 1;
                    isOK = true;
                }
            }
            if (!isOK) {
                repeat[count] = s;
                sreshtaniq[count] += 1;
                count++;
            }
        }

        boolean isEquals = true;
        for (int i = 1; i < sreshtaniq.length; i++)
            if (sreshtaniq[i - 1] == sreshtaniq[i] && sreshtaniq[i] != 0) {
                isEquals = false;
                break;
            }
        if (isEquals) {
            for (int i = 0; i < repeat.length; i++)
                if (sreshtaniq[i] != 0) {
                    System.out.println(repeat[i] + " Брой " + sreshtaniq[i]);
                }
        }
    }

    private static void count() {
    }

    private static void back(String[] array) {
        String[] arrayText = new String[array.length];
        int end;
        for (int i = 0; i < array.length; i++) {
            end = array[i].length() - 1;
            String text = array[i];
            char[] singleText = new char[text.length()];
            for (int j = 0; j < text.length() / 2; j++) {
                singleText[i] = text.charAt(end);
                singleText[end] = text.charAt(i);
                end--;
            }
            for (int j = 0; j < singleText.length; j++) {
                arrayText[j] += singleText[i];
            }
        }

        for (String s : arrayText) {
            System.out.print(s + ",");
        }
    }

    private static void countChar(String[] array) {
        int[] countChar = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            countChar[i] = array[i].length();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " брой :" + countChar[i]);
        }
    }

    public static void Exit() {
    }
}

