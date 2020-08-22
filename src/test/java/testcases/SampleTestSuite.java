package testcases;

import org.testng.annotations.Test;

public class SampleTestSuite {

    @Test(groups = {"smoke","firefox"})
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

    @Test(groups = {"smoke","ie"})
    void tc04(){
        System.out.println("the fourth test");
    }
    @Test
    void tc05(){
        System.out.println("the fifth test");
    }
}
