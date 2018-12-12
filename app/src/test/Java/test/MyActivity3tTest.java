package test;

import com.csipsimple.Member;
import com.csipsimple.MyActivity3t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyActivity3tTest {
    public MyActivity3t test;
    public static ArrayList<Member> templist = new ArrayList<Member>();
    @Before
    public void setUp(){
        test = new MyActivity3t();

        Member member1 = new Member("1","1111");
        Member member2 = new Member("2","2222");
        Member member3 = new Member("3","3333");
        templist.add(member1);
        templist.add(member2);
        templist.add(member3);
    }

    @Test
    public void testinitArray1() {
        test.memberArrayList.clear();
        test.initArray("1/1111/2/2222/3/3333");
        assertEquals(templist.get(0).getName(),test.memberArrayList.get(0).getName());
        assertEquals(templist.get(1).getName(),test.memberArrayList.get(1).getName());
        assertEquals(templist.get(2).getName(),test.memberArrayList.get(2).getName());
        assertEquals(templist.get(0).getNumber(),test.memberArrayList.get(0).getNumber());
        assertEquals(templist.get(1).getNumber(),test.memberArrayList.get(1).getNumber());
        assertEquals(templist.get(2).getNumber(),test.memberArrayList.get(2).getNumber());
        assertEquals(3,test.listnumber);
    }

    @Test
    public void testinitArray2() {
        test.memberArrayList.clear();
        test.initArray("1/1111/2/2222/3/3333/");
        assertEquals(templist.get(0).getName(),test.memberArrayList.get(0).getName());
        assertEquals(templist.get(1).getName(),test.memberArrayList.get(1).getName());
        assertEquals(templist.get(2).getName(),test.memberArrayList.get(2).getName());
        assertEquals(templist.get(0).getNumber(),test.memberArrayList.get(0).getNumber());
        assertEquals(templist.get(1).getNumber(),test.memberArrayList.get(1).getNumber());
        assertEquals(templist.get(2).getNumber(),test.memberArrayList.get(2).getNumber());
        assertEquals(3,test.listnumber);
    }

    @Test
    public void testinitArray3() {
        test.memberArrayList.clear();
        test.initArray("1/1111/2/2222/3/4444/");
        assertEquals(templist.get(0).getName(),test.memberArrayList.get(0).getName());
        assertEquals(templist.get(1).getName(),test.memberArrayList.get(1).getName());
        assertEquals(templist.get(2).getName(),test.memberArrayList.get(2).getName());
        assertEquals(templist.get(0).getNumber(),test.memberArrayList.get(0).getNumber());
        assertEquals(templist.get(1).getNumber(),test.memberArrayList.get(1).getNumber());
        assertEquals(templist.get(2).getNumber(),test.memberArrayList.get(2).getNumber());
        assertEquals(3,test.listnumber);
    }

}