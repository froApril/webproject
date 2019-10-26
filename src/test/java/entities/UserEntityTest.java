package entities;
import junit.framework.TestCase;
//BingKun Miao
public class UserEntityTest extends TestCase {
    private UserEntity user;

    @Override
    protected void setUp() throws Exception {
        user = new UserEntity();
    }

    public void testSetAndGetId() {
        int id = 1;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    public void testSetAndGetUserName() {
        String username = "1234";
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }

    public void testSetAndGetPassword() {
        String password = "abc";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    public void testSetAndGetNickName() {
        String nickname = "Jimmy";
        user.setNickname(nickname);
        assertEquals(nickname, user.getNickname());
    }

    public void testSetAndGetEmail() {
        String email = "1234@uni.sydney.edu.au";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    public void testSetAndGetGender() {
        String gender = "Male";
        user.setGender(gender);
        assertEquals(gender, user.getGender());
    }

    public void testSetAndGetiSstaff() {
        Integer iSstaff = 1;
        user.setiSstaff(iSstaff);
        assertEquals(iSstaff, user.getiSstaff());
    }

    public void testSetAndGetPerDes() {
        String perDes = "description";
        user.setPerDes(perDes);
        assertEquals(perDes, user.getPerDes());
    }

    public void testSetAndGetPhotoPro() {
        String photoPro = "UMR";
        user.setPhotoPro(photoPro);
        assertEquals(photoPro, user.getPhotoPro());
    }

    public void testSetAndGetContactIno() {
        String contactIno = "abc@gmail.com";
        user.setContactIno(contactIno);
        assertEquals(contactIno, user.getContactIno());
    }

    public void testEquals() {
        UserEntity testUser = new UserEntity();
        user.setId(1);
        user.setNickname("Jimmy");
        user.setPassword("123");
        user.setiSstaff(1);
        user.setPhotoPro("UMR");
        user.setPerDes("description");
        user.setEmail("1234@uni.sydney.edu.au");
        user.setContactIno("1234@uni.sydney.edu.au");
        user.setUsername("123");
        user.setGender("Male");

        testUser.setId(1);
        testUser.setNickname("Jimmy");
        testUser.setPassword("123");
        testUser.setiSstaff(1);
        testUser.setPhotoPro("UMR");
        testUser.setPerDes("description");
        testUser.setEmail("1234@uni.sydney.edu.au");
        testUser.setContactIno("1234@uni.sydney.edu.au");
        testUser.setUsername("123");
        testUser.setGender("Male");

        assertTrue(user.equals(testUser));
        testUser.setId(2);
        assertFalse(user.equals(testUser));
    }
}
