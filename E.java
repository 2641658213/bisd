class A{
    static int m=5;//�����static ����ȫ�ֱ��������е�m��Ҫһ��ֵ
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