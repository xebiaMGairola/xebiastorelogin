package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.*;

import static org.junit.Assert.assertEquals;

import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.springframework.web.context.WebApplicationContext;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebAppConfiguration
public class MockIntegrationTest {

 @Autowired 
 private LoginController gtc;

 /*
  * Calling Mock Service bean registered in TestApplication with Mock DAO object created
  */
     private MockMvc mvc;

     @Autowired
    WebApplicationContext context;

  @Before
  public void setUp() {
   mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }


 @Test
 public void shouldLoginWithMockDAO() throws Exception {
  mvc.perform(MockMvcRequestBuilders.get("/admin?name=mohit&password=pwd"))
    .andExpect(status().isOk())
    .andExpect(content().string(equalTo("authenticated mock")));
    
    
 }
 


}