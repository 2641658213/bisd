public class Pay {
    private double price;//价格
    private double withhold_rate;//扣缴率
    private double pay_rate;//工资率
    private double payment;//应得工资

    public Pay(double price, double withhold_rate, double pay_rate) {
        this.price = price;
        this.withhold_rate = withhold_rate;
        this.pay_rate = pay_rate;
    }

    public Pay(double price, double pay_rate) {
        this.price = price;
        this.withhold_rate = 0.15;
        this.pay_rate = pay_rate;
    }

    public Pay(double price) {
        this.price = price;
        this.withhold_rate = 0.15;
        this.pay_rate = 0.0465;
    }
//接收不同的参数的重载
    public double computePayment(double hours, double withhold_rate, double pay_rate) {
        this.payment = hours * price * (1 - withhold_rate) * (1 - pay_rate);
        return this.payment;
    }

    public double computePayment(double hours, double pay_rate) {
        this.payment = hours * price * (1 - 0.15) * (1 - pay_rate);
        return this.payment;
    }

    public double computePayment(double hours) {
        this.payment = hours * price * (1 - 0.15) * (1 - 0.0465);
        return this.payment;
    }
}


