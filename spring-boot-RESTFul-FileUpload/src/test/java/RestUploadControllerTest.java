/**
 * Created by Shyam on 5/24/18.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import com.example.anotatedconfiguration.SpringConfig;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RestUploadControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testFileUpload() throws Exception
    {
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile("file", "FileUploadTest.txt", "text/plain", "This is a Test".getBytes());

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/files")
                .file(mockMultipartFile))
                .andExpect(status().is(201));

    }
}