package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {
    UserRepository userRepository;

    private User userSetup(String name, String password, boolean isAdmin){
        User user = new User(name, password, isAdmin);
        user.authenticate(name, password);
        return user;
    }

    @BeforeEach
    public void Setup() {
        userRepository = new UserRepository();

    }

    @Test
    public void testLogoutUsersWhenNoUsersInRepositoryThenNoChanges() {
        // Arrange


        // Act
        userRepository.logoutUsers();

        // Assert
        assertEquals(0, userRepository.data.size(), "Expected no changes when no users in repository");
    }

    @Test
    public void testLogoutUsersWhenOnlyAdminUsersInRepositoryThenNoChanges() {
        // Arrange
        User adminUser1 = userSetup("admin1", "admin1", true);
        User adminUser2 = userSetup("admin2", "admin2", true);
        userRepository.addUser(adminUser1);
        userRepository.addUser(adminUser2);

        // Act
        userRepository.logoutUsers();

        // Assert
        assertTrue(userRepository.findByName(adminUser1.getName()), "Expected admin user 1 to remain in repository");
        assertTrue(userRepository.findByName(adminUser1.getName()), "Expected admin user 2 to remain in repository");
        assertEquals(2, userRepository.data.size(), "Expected no changes when only admin users in repository");
    }

    @Test
    public void testLogoutUsersWhenNonAdminUsersInRepositoryThenRemoveNonAdminUsers() {
        // Arrange
        User adminUser = userSetup("admin", "password", true);
        User nonAdminUser1 = userSetup("user1", "password1", false);
        User nonAdminUser2 = userSetup("user2", "password2", false);
        userRepository.addUser(adminUser);
        userRepository.addUser(nonAdminUser1);
        userRepository.addUser(nonAdminUser2);

        // Act
        userRepository.logoutUsers();

        // Assert
        assertEquals(1, userRepository.data.size(), "Expected non-admin users to be removed from repository");
        assertTrue(userRepository.data.contains(adminUser), "Expected admin user to remain in repository");
    }
}
