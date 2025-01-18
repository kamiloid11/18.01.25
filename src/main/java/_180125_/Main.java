package _180125_;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = {
                new User("Admin123", "Admin!@#", Role.ADMIN),
                new User("User123", "User123", Role.USER)
        };

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            //Login
            System.out.println("Enter login: ");
            String login = scanner.nextLine();
            int UserID = -1;
            try {
                if (login.length() < 20) throw new WrongLoginException("login < 20");
                if (checkLogin(login) == false) throw new WrongLoginException("Неверный формат логина");
                UserID = findLogin(users, login);
                if (UserID == -1) throw new WrongLoginException();

            } catch (WrongLoginException e) {
                System.out.println(e.getMessage());
                continue;
            }
            //Password
            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            try {
                if (password.length() < 8) {
                    throw new WrongPasswordException("Password < 8");
                }
                if (checkPassword(password) == false) throw new WrongLoginException("Неверный формат пароля");
                if (users[UserID].password.equals(password) == false) {
                    throw new WrongPasswordException();
                }
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
                continue;
            }
            Menu menu = new Menu();
            menu.role = users[UserID].role;
            menu.printMenu();
            int command = scanner.nextInt();
            scanner.nextLine();
            if (command == 3) flag = false;
        }
    }

    public static boolean checkLogin(String login) {
        char[] chars = {'@', '.', '_', '-'};
        for (char literal : login.toCharArray()) {
            for (int i = 0; i < chars.length; ++i) {
                if (literal == chars[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkPassword(String password) {
        char[] chars = {'{', '}', '[', ']', '(', ')', ',', '.', ';', '&', '?', '!', '_', '-', '+', '}', ';'};
        for (char literal : password.toCharArray()) {
            for (int i = 0; i < chars.length; ++i) {
                if (literal == chars[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findLogin(User[] users, String login) {
        for (int i = 0; i < users.length; ++i) {
            if (users[i].login.equals(login)) {
                return i;
            }
        }
        return -1;
    }
}