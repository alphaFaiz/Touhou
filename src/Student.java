import java.util.Date;

public class Student {
    //attributes
    String name;
    Date birthday;
    String code;

    //method
    //1.constructor = hàm tạo
    public  Student(){
        this.name = "ABC";
        this.birthday = new Date();
        this.code = "set124";
    }
    //2.other methods
    public  void print(){
        System.out.println(this.name);
        System.out.println(this.birthday);
        System.out.println(this.code);
    }
}
