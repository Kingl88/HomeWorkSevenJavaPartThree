import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomeworkSevenTest {

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Метод beforeSuit");
    }

    @Test(priority = 5)
    public void methodTest5() {
        System.out.println("Метод Test5 с приоритетом 5");
    }

    @Test(priority = 1)
    public void methodTest1() {
        System.out.println("Метод Tes1 с приоритетом 1");
    }

    @Test(priority = 10)
    public void methodTest10() {
        System.out.println("Метод Test10 с приоритетом 10");
    }

    @Test(priority = 8)
    public void methodTest8() {
        System.out.println("Метод Test8 с приоритетом 8");
    }

    @Test(priority = 4)
    public void methodTest4() {
        System.out.println("Метод Test4 с приоритетом 4");
    }

    @Test(priority = 3)
    public void methodTest3() {
        System.out.println("Метод Test3 с приоритетом 3");
    }

    @Test(priority = 5)
    public void methodTest0() {
        System.out.println("Метод Test0 с приоритетом 5");
    }

    @Test(priority = 5)
    public void methodTest2() {
        System.out.println("Метод Test2 с приоритетом 5");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("Метод afterSuit");
    }

//    @AfterSuite
//    public void afterSuit1() {
//        System.out.println("Метод afterSuit");
//    }
}
