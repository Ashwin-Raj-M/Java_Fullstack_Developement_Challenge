package Java_refference.oops_exercises.Question_7;

public class Account{
    int accno;
    String name;
    float bal;

    public Account(int accno, String name, float bal) {
        this.accno = accno;
        this.name = name;
        this.bal = bal;
    }
    public int getAccno() {
        return accno;
    }
    public void setAccno(int accno) {
        this.accno = accno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getBal() {
        return bal;
    }
    public void setBal(float bal) {
        this.bal = bal;
    }
    public void deposite(float amount){
        bal += amount;
    }
    public void withdraw(float amount){
        bal -= amount;
    }
    public String details(){
        return "Ac. Holder Name: " + name + "\nAccount No.: " + accno + "\nAccount Balance: " + bal;
    }
}
