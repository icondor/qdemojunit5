import static org.junit.jupiter.api.Assertions.*;


class DBTest {
    @org.junit.jupiter.api.Test
    void getTaskList() {
       assertTrue(new DB().getTaskList(2));
    }

}