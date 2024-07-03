import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,List<User>> userMap = new HashMap<Integer,List<User>>();

        for (int i = 0; i < 5; i++) {
            System.out.println(" Введите имя пользователя " + (i+1));
            String name = sc.nextLine();

            System.out.println("Введите возраст пользователя " + (i+1));
            int age = sc.nextInt();
            sc.nextLine();

            User user = new User(name, age);

            if (userMap.containsKey(age)) {
                userMap.get(age).add(user);
            }
            else{
                List<User> users = userMap.get(age);
                if (users == null) {
                    users = new ArrayList<>();
                }
                users.add(user);
                userMap.put(age, users);
            }
        }

        System.out.println("Введите требуемый возраст");
        int searchAge = sc.nextInt();
        sc.nextLine();
        if (userMap.containsKey(searchAge)) {
            List<User> users = userMap.get(searchAge);
            users.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
            System.out.println("Пользователь с возрастом " + searchAge);
            for (User user : users) {
                System.out.println(user);
            }
        }
        else{
            System.out.println("Пользователь с возрастом '" + searchAge + "' не найден");
        }

        sc.close();
    }
}