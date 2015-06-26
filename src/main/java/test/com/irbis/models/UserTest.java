package test.com.irbis.models; 

import com.irbis.models.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/** 
* User Tester. 
* 
* @author <Authors name> 
* @since <pre>θών 26, 2015</pre> 
* @version 1.0 
*/ 
public class UserTest {
    User usertest = new User();


@Before
public void before() throws Exception {
    User usertest = new User();
    usertest.setName("Test1");
    usertest.setPassword("Test1");
    usertest.setIduser(12);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getIduser() 
* 
*/ 
@Test
public void testGetIduser() throws Exception { 
usertest.getIduser();
} 

/** 
* 
* Method: setIduser(int iduser) 
* 
*/ 
@Test
public void testSetIduser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
//TODO: Test goes here...

    assertTrue(usertest.getName(),true);
} 

/** 
* 
* Method: getPassword() 
* 
*/ 
@Test
public void testGetPassword() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setPassword(String password) 
* 
*/ 
@Test
public void testSetPassword() throws Exception { 
//TODO: Test goes here... 
} 


} 
