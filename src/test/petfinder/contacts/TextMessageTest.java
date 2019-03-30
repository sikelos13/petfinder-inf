package petfinder.contacts;


import static org.junit.Assert.*;



import org.junit.Test;

import petfinder.util.BasicEqualTester;

//import gr.aueb.mscis.fuels.util.BasicEqualTester;

public class TextMessageTest {

    @Test
    public void testEqualsObject() {
        TextMessage text1 = new TextMessage();
        TextMessage text2 = new TextMessage();
        
        assertFalse(text1.equals(null));
        assertEquals(text1, text2);
              
        text1.setFrom("Stefanos");
        assertFalse(text1.equals(text2));
        text2.setFrom("Stefanos");
        assertEquals(text1, text2);
        
        text1.setSubject("Aueb");
        text2.setSubject("Aueb");
        assertFalse(text1.equals(text2));
    }
    @Test
    public void testEqualsAndHashCode() {
        BasicEqualTester<TextMessage> equalsTester = new BasicEqualTester<TextMessage>();
        TextMessage text = new TextMessage();
        equalsTester.setObjectUnderTest(text);
        
        equalsTester.otherObjectIsNull();
        
        equalsTester.otherObjectIsOfDifferentType(new Object());
        
        TextMessage text2 = new TextMessage() ;
        equalsTester.bothObjectsHaveNoState(text2);
        
        text.setFrom("Spuros");
        equalsTester.otherObjectsHasNoState(text2);
        
        equalsTester.sameReferences(text);
        
        text2.setFrom("Spuros");
        equalsTester.bothObjectsHaveSameState(text2);
        
        text2.setSubject("Test");
        equalsTester.objectsHaveDifferentState(text2);
        
        text2.setSubject("NewTest");
        equalsTester.objectsHaveDifferentState(text2);
        
        text2.setSubject("Test");
        equalsTester.bothObjectsHaveSameState(text2);
        
        text.setSubject("TextTest");
        equalsTester.objectsHaveDifferentState(text2);
        
        text2.setSubject("Subject");
        equalsTester.objectsHaveDifferentState(text2);
        
        text2.setSubject("Test");
        equalsTester.bothObjectsHaveSameState(text2);
        
        
        
    }


}
