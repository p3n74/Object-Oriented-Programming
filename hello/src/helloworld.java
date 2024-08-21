import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {

        GetData Userinput = new GetData();
        ProccessData myAdder = new ProccessData();


        System.out.println("Your new number is: " + myAdder.sum(Userinput.askUser(), Userinput.askUser()));
    }
}

class GetData{
    public int askUser(){
        System.out.print("Enter an integer value: ");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();


        return val;
    }
}

class ProccessData{
    public int sum(int a, int b){
        return (a + b);
    }
}