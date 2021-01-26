package ttst;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserIntegrationTest {

    public static ArrayList<User> users = new ArrayList<User>();

    @Before
    public void setup() {

        users.add(new User("test", "test"));
        users.add(new User("test", "test"));
        users.add(new User("test", "test"));

    }

    @Test
    public void getTestUser() {
        for (int i = 0; i < User.getUsers().size(); i++) {
            User user = User.getUser(i);
            assertEquals("test", user.getUsername());
            assertEquals("test", user.getPassword());
        }

        assertEquals(null, User.getUser(22));
    }
}
