package test_entities;

import entities.Account;
import entities.Message;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class TestMessage {
    static Calendar date1;
    static Calendar date2;
    static Account acct1;
    static Account  acct2;
    static Account  acct3;
    static Account  acct4;
    static SimpleDateFormat sdf;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        acct1 = new Account("Name1","pw1", "first1", "last1");
        acct2 = new Account("Name2","pw2", "first2", "last2");
        acct3 = new Account("Name3","pw3", "first3", "last3");
        acct4 = new Account("Name4","pw4", "first4", "last4");
    }

    @Test(timeout = 50)
    public void test_Message() {
        Message.resetSid();
        Message m1 = new Message(acct1, acct2,  "content1") ;
        String exp1 = "[Message 0] (Name1) : content1 [ReplyTo] (None)";
        String act1 = m1.toString();
        assertEquals(exp1, act1);
    }

    @Test(timeout = 50)
    public void test_Message2() {
        Message.resetSid();
        Message reply = new Message(acct1, acct2,  "content2") ;
        Message m1 = new Message(acct2, acct1,  "content1", reply) ;
        String exp1 = "[Message 1] (Name2) : content1 [ReplyTo] (Name1) : content2";
        String act1 = m1.toString();
        assertEquals(exp1, act1);
    }

    @Test(timeout = 50)
    public void test_hashCode() {
        Message m1 = new Message(acct1, acct2,  "content1") ;
        Message m2 = new Message(acct1, acct2,  "content1") ;
        Message m3 = new Message(acct1, acct2,  "content2") ;
        String exp1 = "true";
        String exp2 = "false";
        String act1 = (m1.hashCode() == m2.hashCode()) + "";
        String act2 = (m1.hashCode() == m3.hashCode()) + "";
        assertEquals(exp1, act1);
        assertEquals(exp2, act2);
    }

    @Test(timeout = 50)
    public void test_equals() {
        Message m1 = new Message(acct1, acct2,  "content1") ;
        Message m2 = new Message(acct1, acct2,  "content1") ;
        Message m3 = new Message(acct1, acct2,  "content2") ;
        String exp1 = "true";
        String exp2 = "false";
        String act1 = m1.equals(m2) + "";
        String act2 = m1.equals(m3) + "";
        assertEquals(exp1, act1);
        assertEquals(exp2, act2);
    }

    @Test(timeout = 50)
    public void test_get_setSender() {
        Message m1 = new Message(acct1, acct2,  "content1") ;
        String exp1 = "true";
        String exp2 = "true";
        String act1 = m1.getSender().equals(acct1) + "";
        m1.setSender(acct2);
        String act2 = m1.getSender().equals(acct2) + "";
        assertEquals(exp1, act1);
        assertEquals(exp2, act2);
    }

    @Test(timeout = 50)
    public void test_get_setReceiver() {
        Message m1 = new Message(acct1, acct2,  "content1") ;
        String exp1 = "true";
        String exp2 = "true";
        String act1 = (m1.getReceiver() == acct2)+ "";
        m1.setReceiver(null);
        String act2 = (m1.getReceiver() == null) + "";
        assertEquals(exp1, act1);
        assertEquals(exp2, act2);
    }
    @Test(timeout = 50)
    public void test_getId() {
        Message.resetSid();
        Message m1 = new Message(acct1, acct2,  "content1") ;
        Message m2 = new Message(acct1, acct2,  "content1") ;
        String exp1 = "true";
        String exp2 = "true";
        String act1 = (m1.getId() == 0)+ "";
        String act2 = (m2.getId() == 1) + "";
        assertEquals(exp1, act1);
        assertEquals(exp2, act2);
    }
}
