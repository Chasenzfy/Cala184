package test;

import com.csipsimple.MyActivity2t;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyActivity2tTest {
    public MyActivity2t test;
    @Before
    public void setUp() throws Exception{
        test = new MyActivity2t();
    }

    @Test
    public void testc1() throws Exception{
        assertEquals("1/2",test.combine("1","2"));
    }
    @Test
    public void testc2() throws Exception{
        assertEquals("1231/6565",test.combine("1231","6565"));
    }
    @Test
    public void testc3() throws Exception{
        assertEquals("12/34",test.combine("1","234"));
    }
    @Test
    public void testc4() throws Exception{
        assertEquals("2/3/4/5/",test.writeList("2/3/","4/5"));
    }
    @Test
    public void testc5() throws Exception{
        assertEquals("2/3/4/5/6/7/",test.writeList("2/3/4/5/","6/7"));
    }
    @Test
    public void testc6() throws Exception{
        assertEquals("2/3/4/5/6/7",test.writeList("2/3/4/5/","6/7"));
    }

}