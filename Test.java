import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //System.out.print("please input your price：");
        double price = in.nextDouble();

        //System.out.print("请输入工作小时数：");
        //测试时中文会出现乱码，但不影响结果
        double hours = in.nextDouble();

        //System.out.print("请输入扣费率：");
        double withholdRate = in.nextDouble();

        //System.out.print("请输入每小时工资率：");
        double payRate = in.nextDouble();
        //目前做不到通过输入参数的数量自动选择合适和重载函数，只能是所有参数都输入，然后调用三次重载函数
        Pay pay = new Pay(price, withholdRate, payRate);
        double payment1 = pay.computePayment(hours, withholdRate, payRate);
        System.out.println("Payment1: " + payment1);

        double payment2 = pay.computePayment(hours, withholdRate);
        System.out.println("Payment2: " + payment2);

        double payment3 = pay.computePayment(hours);
        System.out.println("Payment3: " + payment3);
    }
}