package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
      Car car = new Car("Tesla", 123);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car));
      car = new Car("Skoda", 321);
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car));
      car = new Car("Toyota", 222);
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car));
      car = new Car("Lada", 333);
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car));
      //adding user without car for test
      userService.add(new User("User5", "Lastname5", "user5@mail.ru"));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }
      //Поиск пользователя по машине
      User user = userService.getUserByModelSeriesCar("Tesla", 123);
      System.out.println(user);


      context.close();
   }
}
