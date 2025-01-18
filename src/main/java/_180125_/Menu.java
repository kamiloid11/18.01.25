package _180125_;

public class Menu {
    public Role role;

    public void printMenu() {
        if (role == Role.ADMIN) {
            System.out.println("1. File");
            System.out.println("2. Create new user");
            System.out.println("3. exit");
        } else {
            System.out.println("1. File");
            System.out.println("2. Get play list");
            System.out.println("3. exit");
        }
    }
}