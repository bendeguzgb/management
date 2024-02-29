package hu.bendeguz.management.controller;

import hu.bendeguz.management.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContactController.class)
public class ContactControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @BeforeEach
    void init() {
        when(contactService.saveContact(any())).thenReturn(null);
    }

    @Test
    void testCreateContact_InvalidEmail() throws Exception {
        performCreateContact("invalid_email", "1234567890")
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreateContact_InvalidPhoneNumber() throws Exception {
        performCreateContact("valid@example.com", "invalid-phone")
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreateContact_ValidContact() throws Exception {
        performCreateContact("valid@example.com", "1234567890")
                .andExpect(status().isCreated());
    }

    private ResultActions performCreateContact(String email, String phoneNumber) throws Exception {
        String body = String.format("{\"email\": \"%s\",\"phoneNumber\": \"%s\"}", email, phoneNumber);

        return mockMvc.perform(post("/contact")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));
    }
}
