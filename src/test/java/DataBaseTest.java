import dao.UserDAO;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DataBaseTest {
    @Test
    public void dataBaseCheck() throws SQLException, ClassNotFoundException {
        User expectedUser = new User();
        expectedUser.setFirstName(RandomStringUtils.randomAlphabetic(5));
        expectedUser.setLastName(RandomStringUtils.randomAlphabetic(10));
        expectedUser.setEmail(RandomStringUtils.randomAlphanumeric(10)+"@test.com");

        UserDAO userDAO = new UserDAO();
        userDAO.saveUser(expectedUser);
    }
}
