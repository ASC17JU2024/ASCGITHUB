package design_patterns.creational;

public class App {
        public static void main(String[] args) {
            User user = new User.UserBuilder("John", "Doe")
                    .age(30)
                    .phone("123-456-7890")
                    .address("123 Main St")
                    .build();

            System.out.println(user);
        }
}
