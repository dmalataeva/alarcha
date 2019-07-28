import controllers.OrderController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import repositories.OrderRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Alarcha.class)
@WebMvcTest(OrderController.class)
//@AutoConfigureMockMvc
public class OrderControllerUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderController orderController;

    @Autowired
    private MockMvc mockMvc;

    /*@Before
    public void setUp() {
        OrderEntity order = new OrderEntity(1,"placed",Timestamp.from(Instant.now()),10.0,1,1);
        entityManager.persist(order);
        entityManager.flush();

        Mockito.when(orderRepository.findById(order.getOrderId()))
                .thenReturn(Optional.of(order));

    }*/

    @Test
    public void orderControllerInjection() throws Exception {
        assertThat(orderController).isNotNull();
    }

    @Test
    public void getOrderById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/order")
                .content("1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));

    }

    /*@Test
    public void saveOrder() {
        // mock order
        OrderEntity order = new OrderEntity(1,"placed",Timestamp.from(Instant.now()),10.0,1,1);
        entityManager.persist(order);
        entityManager.flush();
    }

    @Test
    public void getByOrderId() {
        // given
        OrderEntity order = new OrderEntity(1,"placed",Timestamp.from(Instant.now()),10.0,1,1);
        entityManager.persist(order);
        entityManager.flush();

        // when
        OrderEntity found = orderRepository.findById(order.getOrderId()).orElse(new OrderEntity());

        // then
        assertThat(found.getOrderId())
                .isEqualTo(order.getOrderId());
    }*/
}
