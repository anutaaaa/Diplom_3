package User;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomHelper {

    public static User getRandomUserWithAllParams(){
        return new User(RandomHelper.getRandomName(), RandomHelper.getRandomEmail(),RandomHelper.getRandomPassword());
    }

    public static String getRandomName(){
        Faker faker = new Faker();
        return faker.address().firstName();
    }

    public static String getRandomEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword(){
        Faker faker = new Faker();
        return faker.internet().password(8,16,true,true,true);
    }

    public static String getRandomShortPassword() {
        return RandomStringUtils.randomAlphabetic(5);
    }
}
