import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter x: ");
        double x = in.nextDouble();
        System.out.println("Enter y: ");
        double y = in.nextDouble();
        System.out.println("Enter command: ");
        String s = in.next();

        if (s.equals("Save"))
        {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt")))
            {
                Calc c = new Calc(x, y);
                oos.writeObject(c);
                System.out.println("Object saved");
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        else if (s.equals("Upload"))
        {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt")))
            {
                Calc c = (Calc)ois.readObject();
                System.out.println("x = " + c.x + ", y = " + c.y);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        else {
            System.out.println("Unknown command");
        }
    }
}