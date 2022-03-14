package com.utah.bookretail;

import com.utah.bookretail.bean.UserBean4Create;
import com.utah.bookretail.bean.UserOrder4Create;
import com.utah.bookretail.common.Result;
import com.utah.bookretail.controller.OrderController;
import com.utah.bookretail.controller.UserController;
import com.utah.bookretail.entity.UserOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
class BookretailApplicationTests {

    @Autowired
    private UserController userController;
    @Autowired
    private OrderController orderController;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    public void createUserTest() throws Exception {
        UserBean4Create userBean4Create = new UserBean4Create();
        userBean4Create.setName("王五");
        userBean4Create.setMemberTypeId(3);
        userController.createUser(userBean4Create);

    }

    @Test
    public void submitOrderTest() {
        UserOrder4Create userOrder4Create = new UserOrder4Create();
        userOrder4Create.setUserId(1L);
        userOrder4Create.setOrderAmount(new BigDecimal(158));
        orderController.submitOrder(userOrder4Create);
    }

    @Test
    public void listByUserIdTest() {
        Result<List<UserOrder>> result = orderController.listByUserId(1L);
        log.info("{}", result);
    }

}
