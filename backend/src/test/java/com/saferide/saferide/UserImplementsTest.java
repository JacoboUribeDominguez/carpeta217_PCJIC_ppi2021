package com.saferide.saferide;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.repositories.UserRepository;
import com.saferide.saferide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.junit.Assert.*;

/**
 * @author Alejandro Calvo
 */

public class UserImplementsTest {

    @InjectMocks


    @Autowired
    private UserRepository userRepository;

    public UserImplementsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of login method, of class UserImplements.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        UserModel user = null;
        UserImplements instance = new UserImplements();
        instance.login(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveUsers method, of class UserImplements.
     */
    @Test
    public void testSaveUsers() {
        System.out.println("saveUsers");
        UserModel userLog = null;
        UserImplements instance = new UserImplements();
        instance.saveUsers(userLog);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class UserImplements.
     */
    @Test
    public void testCheckUser() {
        System.out.println("checkUser");
        UserModel foundUser = null;
        UserModel user = null;
        UserImplements instance = new UserImplements();
        instance.checkUser(foundUser, user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
