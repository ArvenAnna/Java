package anna.deliveryservice.service;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.listener.AddingPizzasEvent;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Anna
 * Testing version of delivery service with in mem implementation of repository
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/repositoryTestContext.xml", 
    "classpath:/appContext.xml"})
public class SimpleOrderServiceTest implements ApplicationContextAware{
    
    @Autowired
    private OrderService orderService;
    private static Logger log = Logger.getLogger(SimpleOrderServiceTest.class);
    private ApplicationContext spring;
    
    public SimpleOrderServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of placeNewOrder method, of class SimpleOrderService.
     */
    @Test
    public void testPlaceNewOrder() {
        System.out.println("placeNewOrder");
        Customer customer = (Customer)spring.getBean("newCustomer");
        Long[] pizzaID = {new Long(1)};
        Order result = orderService.placeNewOrder(customer, pizzaID);
        List<Pizza> addPizzas = new ArrayList<Pizza>();
        addPizzas.add(new Pizza());
        result.addMorePizzas(addPizzas);
        spring.publishEvent(new AddingPizzasEvent(new Object(),"pizzas were added"));
        log.info(result);
        assertNotNull(result);
    }

    /**
     * Test of createNewOrder method, of class SimpleOrderService.
     */
    @Test
    public void testCreateNewOrder() {
        System.out.println("createNewOrder");
        SimpleOrderService instance = null;
        Order expResult = null;
        Order result = instance.createNewOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrder method, of class SimpleOrderService.
     */
    @Test
    public void testSaveOrder() {
        System.out.println("saveOrder");
        Order order = new Order();
        order.setId(1L);
        order.setCustomer(new Customer("Petya"));
        Order result = orderService.saveOrder(order);
        assertNotNull(result);
    }

    /**
     * Test of addPizzasToOrder method, of class SimpleOrderService.
     */
    @Test
    public void testAddPizzasToOrder() {
        System.out.println("addPizzasToOrder");
        Order order = new Order();
        order.setId(1L);
        order.setCustomer(new Customer("Petya")); 
        order = orderService.saveOrder(order);
        Long[] pizzaID = {1L, 1L};
        Order result = orderService.addPizzasToOrder(order, pizzaID);        
        spring.publishEvent(new AddingPizzasEvent(new Object(),"pizzas were added"));
        log.info(result);
        assertNotNull(result);
    }

    /**
     * Test of payForOrder method, of class SimpleOrderService.
     */
    @Test
    public void testPayForOrder() {
        System.out.println("payForOrder");
        Order order = null;
        SimpleOrderService instance = null;
        orderService.payForOrder(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.spring = ac;
    }
    
}
