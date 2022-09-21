import java.util.Scanner;

public class HomeWork2 {

    static int triangular_number(int n, int tn) {
        for (int i = 0; i <= n; i++)
            tn += i;
        return tn;
    }

    static void print_triangular_number(int n, int tn) {
        System.out.println(String.format("Треугольное число Т%d=%d", n, tn));
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите число n для нахождения n-го треугольного числа: ");
        int n = iScanner.nextInt();
        iScanner.close();
        int tn = 0;
        tn = triangular_number(n, tn);
        print_triangular_number(n, tn);
    }

}
