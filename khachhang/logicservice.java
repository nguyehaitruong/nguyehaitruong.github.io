
import java.util.Scanner;


public  class logicservice {
    private service[] sv=new service[100];

    public service[] getSv() {
        return sv;
    }
    public void serv(){
        int demsv;
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập số lượng bài viết");
        int numberservice=sc.nextInt();
        for (int i=0;i<numberservice;i++){
            System.out.println("thông tin bài viết "+i);
            service sv =new service();
            System.out.println("nhập tên");
            sv.setNameservice(new Scanner(System.in).nextLine());
            System.out.println("nhập đơn giá");
            sv.setRates(Integer.parseInt(new Scanner(System.in).nextLine()));
            System.out.println("thôgn tin bài"+i);
            System.out.println(sv.getId());
            System.out.println(sv.getNameservice());
            System.out.println(sv.getRates());}
        int dai1= sv.length;
        for (int j=0;j< dai1;j++){
            if (sv[j]==null)
                demsv=j;

        }

    }
}
