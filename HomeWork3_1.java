import java.util.Scanner;

public class HomeWork3_1 {

    static void print_arr(int[] rod1, int[] rod2, int[] rod3, int k) {
        for (int i = 0; i < k; i++) {
            System.out.printf("%d  %d  %d", rod1[i], rod2[i], rod3[i]);
            System.out.println();
        }
        System.out.println();
    }

    static void arr(int[] rod1, int[] rod2, int[] rod3, int k) {
        /*
         * Реализованно треугольное решение: нечетные кольца передвигаются слева на
         * право,
         * нечетные кольца передвигаются справо на лево
         */
        for (int i = 0; i < k; i++) {
            if (rod1[i] != 0) {// ищем верхнее кольцо
                if (rod1[i] % 2 != 0) {// если кольцо нечетное
                    if (rod2[k - 1] == 0) {/*
                                            * если соседний стержень пустой,
                                            * то переносим кольцо
                                            */
                        rod2[k - 1] = rod1[i];
                        rod1[i] = 0;
                        break;
                    }
                    for (int j = 0; j < k; j++) {/*
                                                  * если соседний стержень непустой,
                                                  * то проверяем можно ли перенести кольцо
                                                  */
                        if (rod2[j] > 0) {
                            if (rod1[i] < rod2[j]) {
                                rod2[j - 1] = rod1[i];
                                rod1[i] = 0;
                                break;
                            }
                            break;
                        }
                    }
                }
                if (rod1[i] % 2 == 0) {// если кольцо четное
                    if (rod3[k - 1] == 0) {/*
                                            * если соседний стержень пустой,
                                            * то переносим кольцо
                                            */
                        rod3[k - 1] = rod1[i];
                        rod1[i] = 0;
                        break;
                    }
                    for (int j = 0; j < k; j++) {/*
                                                  * если соседний стержень непустой,
                                                  * то проверяем можно ли перенести кольцо
                                                  */
                        if (rod3[j] > 0) {
                            if (rod1[i] < rod3[j]) {
                                rod3[j - 1] = rod1[i];
                                rod1[i] = 0;
                                break;
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    static int input() {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите количество колец=");
        int k = iScanner.nextInt();
        iScanner.close();
        return k;
    }

    public static void main(String[] args) {
        int k = input();
        int[] rod1 = new int[k];
        int[] rod2 = new int[k];
        int[] rod3 = new int[k];

        for (int i = 0; i < k; i++) {// формирование начала задачи
            rod1[i] = i + 1;
        }
        print_arr(rod1, rod2, rod3, k);// печать начала задачи

        rod1[0] = 0;
        rod2[k - 1] = 1;// первый ход
        print_arr(rod1, rod2, rod3, k);

        rod1[1] = 0;
        rod3[k - 1] = 2;// второй ход
        print_arr(rod1, rod2, rod3, k);

        while (rod3[0] != 1) {// когда на третьем стержне будет самое маленькое кольцо-задача решена
            for (int i = 0; i < k; i++) {/*
                                          * это для того, чтобы проверить следующие
                                          * кольца на стержне при снятом верхнем кольце
                                          */
                arr(rod2, rod3, rod1, k);/*
                                          * третий ход - работаем со стержнем,
                                          * куда переложили первое кольцо
                                          */
                /*
                 * последовательно работаем над
                 * следующими стержнями справа на лево
                 */
            }
            if (rod3[0] == 1)// проверка решени ли задача
                break;
            print_arr(rod1, rod2, rod3, k);
            for (int i = 0; i < k; i++) {/*
                                          * это для того, чтобы проверить
                                          * следующие кольца на стержне при снятом верхнем кольце
                                          */
                arr(rod1, rod2, rod3, k);/**
                                          * последовательно работаем над
                                          * следующими стержнями справа на лево
                                          */
            }
            if (rod3[0] == 1)// проверка решени ли задача
                break;
            print_arr(rod1, rod2, rod3, k);
            for (int i = 0; i < k; i++) {/*
                                          * это для того, чтобы проверить
                                          * следующие кольца на стержне при снятом верхнем кольце
                                          */
                arr(rod3, rod1, rod2, k);/**
                                          * последовательно работаем над
                                          * следующими стержнями справа на лево
                                          */
            }
            if (rod3[0] == 1)// проверка решени ли задача
                break;
            print_arr(rod1, rod2, rod3, k);
        }
        print_arr(rod1, rod2, rod3, k);// печать результата решения
    }
}