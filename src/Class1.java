import java.util.Scanner;

public class Class1 {

    public static void main(String[] arr)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        try
        {
            Operation oper = new Operation(s);
            System.out.println(oper.calculate());
        }
        catch (Exception ex)
        {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }

}
