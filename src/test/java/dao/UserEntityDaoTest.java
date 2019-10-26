package dao;
import dao.impl.UserEntityDaoImpl;
import entities.UserEntity;
import junit.framework.TestCase;

import java.util.List;
//BingKun Miao
public class UserEntityDaoTest extends TestCase {
    private UserEntityDao userDao;
    private UserEntity user1 = new UserEntity();
    private UserEntity user2 = new UserEntity();

    protected void setUp() {
        userDao = new UserEntityDaoImpl();
        user1.setId(36);
        user1.setNickname("KIKO");
        user1.setPassword("2");
        user1.setiSstaff(1);
        user1.setPhotoPro("UMR");
        user1.setPerDes("I'm an empty person");
        user1.setEmail("yixu5881@uni.sydney.edu.au");
        user1.setContactIno("yixu5881@uni.sydney.edu.au");
        user1.setUsername("2");
        user1.setGender("Secret");

        user2.setId(1);
        user2.setNickname("Jimmy");
        user2.setPassword("123");
        user2.setiSstaff(1);
        user2.setPhotoPro("UMR");
        user2.setPerDes("description");
        user2.setEmail("1234@uni.sydney.edu.au");
        user2.setContactIno("1234@uni.sydney.edu.au");
        user2.setUsername("12345");
        user2.setGender("Male");
    }

    public void testGetUserByName() {
        assertNull(userDao.getUserByName("aha"));
        assertEquals(user1, userDao.getUserByName("2"));
    }

    public void testGetUserById() {
        assertNull(userDao.getUserById(1));
        assertEquals(user1, userDao.getUserById(36));
    }

    public void testGetUserByNick() {
        assertNull(userDao.getEntityByNickname("Jimmy"));
        assertEquals(user1, userDao.getEntityByNickname("KIKO"));
    }

    public void testIsUsernameExist() {
        assertTrue(userDao.isUsernameExist("2"));
        assertFalse(userDao.isUsernameExist("aha"));
    }

    public void testIsNicknameExist() {
        assertTrue(userDao.isNicknameExist("KIKO"));
        assertFalse(userDao.isNicknameExist("Jimmy"));
    }

    public void testAddUser() {
        assertTrue(userDao.addUser(user2));
        assertFalse(userDao.addUser(user1));
    }

    public void testIsStaff() {
        assertTrue(userDao.isStaff("2"));
        assertFalse(userDao.isStaff("44"));
    }

    public void testSetNewNickName() {
        assertTrue(userDao.setNewnickname("3", "Jimmy"));
        assertFalse(userDao.setNewnickname("12345", "Jimmy"));
        assertFalse(userDao.setNewnickname("2", "Jimmy"));
    }

    public void testSetNewPassword() {
        assertTrue(userDao.setNewpassword("2", "5555"));
        assertFalse(userDao.setNewpassword("12345", "55555"));
    }

    public void testSetGender() {
        assertTrue(userDao.setGender("2", "Male"));
        assertFalse(userDao.setGender("12345", "Male"));
    }

    public void testSetDes() {
        assertTrue(userDao.setDes("2", "description"));
        assertFalse(userDao.setDes("12345", "description"));
    }

    public void testSetContactInfo() {
        assertTrue(userDao.setContactInfo("2", "info"));
        assertFalse(userDao.setContactInfo("12345", "info"));
    }

    public void testSetNewPhoto() {
        assertTrue(userDao.setNewphoto("2", "UMR"));
        assertFalse(userDao.setNewphoto("12345", "UMR"));
        assertFalse(userDao.setNewphoto("2", "AAA"));
    }
    public void testDeleteUser() {
        assertTrue(userDao.deleteUser("2"));
        assertFalse(userDao.deleteUser("tttttt"));
    }

    public void testIsUserCanLogin() {
        assertTrue(userDao.isUsercanlogin("2", "2"));
        assertFalse(userDao.isUsercanlogin("2", "222"));
        assertFalse(userDao.isUsercanlogin("12345", "2"));
    }

    public void testGetNicknameByUsername() {
        assertEquals("KIKO", userDao.getNicknameByUsername("2"));
    }

    public void testGetEntityByNickname() {
        assertNull(userDao.getEntityByNickname("Jimmy"));
        assertEquals(user1, userDao.getEntityByNickname("KIKO"));
    }

    public void testGetAllUsers() {
        List<UserEntity> userList = userDao.getAllUsers();
        assertEquals(6, userList.size());
        assertEquals(user1, userList.get(0));
    }
}
