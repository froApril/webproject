//package controller.test;
//
//import static org.junit.Assert.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.web.context.WebApplicationContext;
//
//public class LoginControllerTest {
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = webAppContextSetup(this.wac).build();
//    }
//
//    @org.junit.Test
//    public void home() {
//
//        MvcResult result = mockMvc.perform(get("/user/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("id", "1")
//                .param("name", "zhangsan")
//        ).andExpect(status().isOk()).andDo(print()).andReturn();
//        System.out.println("result:" + result.getResponse().getContentAsString());
//    }
//
//    @org.junit.Test
//    public void page() {
//    }
//
//    @org.junit.Test
//    public void logout() {
//    }
//
//    @org.junit.Test
//    public void login() {
//    }
//
//    @org.junit.Test
//    public void getTopic() {
//    }
//}