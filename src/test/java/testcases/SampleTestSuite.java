package testcases;

import org.testng.annotations.*;

public class SampleTestSuite {

    @BeforeSuite
    void beforeSuite(){
        System.out.println("before suite");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("before test");
    }
    @BeforeClass
    void beforeClass(){
        System.out.println("before class");
    }
    @BeforeGroups
    void beforeGroup(){
        System.out.println("before group");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("before method");
    }

    @Test
    void tc01(){
        System.out.println("the first test");
    }

    @Test
    void tc02(){
        System.out.println("the second test");
    }

    @Test
    void tc03(){
        System.out.println("the third test");
    }

    @Test
    void tc04(){
        System.out.println("the fourth test");
    }
    @Test
    void tc05(){
        System.out.println("the fifth test");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("after method");
    }

    @AfterClass
    void afterClass(){
        System.out.println("after class");
    }

    @AfterTest
    void afterTest(){
        System.out.println("after test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("after suite");
    }
}
