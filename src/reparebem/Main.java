package reparebem;

public class Main {
    public static void main(String[] args) {
        OrdemDeServico os1 = new OrdemDeServico("maria", "123", "calça");
        OrdemDeServico os2 =  new OrdemDeServico("joan", "1234", "camisa");

        System.out.println(os1.toString());
        System.out.println(os2.toString());
    }
}
