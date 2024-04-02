class A{
    static int m=5;//如果有static 就是全局变量，所有的m都要一个值
    void addA(int x){
        m=m+x;
    }
}
public class E{
    public static void main(String[] args) {
        A a1=new A();
        A a2=new A();
        a2.addA(4);
        System.out.println(a1.m);
        System.out.println(a2.m);
    }
}