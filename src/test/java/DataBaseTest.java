import dao.UserDAO;
import io.cucumber.plugin.event.Node;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class DataBaseTest {
    @Test
    public void dataBaseCheck() throws SQLException, ClassNotFoundException {
        User expectedUser = new User();
        expectedUser.setFirstName(RandomStringUtils.randomAlphabetic(5));
        expectedUser.setLastName(RandomStringUtils.randomAlphabetic(10));
        expectedUser.setEmail(RandomStringUtils.randomAlphanumeric(10)+"@test.com");

        UserDAO userDAO = new UserDAO();
        long id = userDAO.saveUser(expectedUser);

        User actualUser = userDAO.getUserById(id);
        System.out.println("ID: " + id + " - " + actualUser.getFirstName() + " " + actualUser.getLastName());

        List<User> users = userDAO.getUsers();
        for ( User u : users) {
            System.out.println("ID: " + u.getId() + " " + u.getFirstName());
        }
    }
}
