package at.fhtw.slmexamproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = GradeController.class)
class GradeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testMarkOverMaximumError() throws Exception {
        mockMvc.perform(get("/api/mark?percentage=101"))
                .andExpect(status().is5xxServerError())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("Percentage must be in range 0-100"));
    }
    
    @Test
    void testMarkBelowMinimumError() throws Exception {
        mockMvc.perform(get("/api/mark?percentage=-1"))
                .andExpect(status().is5xxServerError())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("Percentage must be in range 0-100"));
    }
    
    @Test
    void testMarkGrades() throws Exception {
        // Verify edges of grade 5
        mockMvc.perform(get("/api/mark?percentage=0"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("5"));
        mockMvc.perform(get("/api/mark?percentage=49"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("5"));
        // Verify edges of grade 4
        mockMvc.perform(get("/api/mark?percentage=50"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("4"));
        mockMvc.perform(get("/api/mark?percentage=62"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("4"));
        // Verify edges of grade 3
        mockMvc.perform(get("/api/mark?percentage=63"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("3"));
        mockMvc.perform(get("/api/mark?percentage=74"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("3"));
        // Verify edges of grade 2
        mockMvc.perform(get("/api/mark?percentage=75"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("2"));
        mockMvc.perform(get("/api/mark?percentage=87"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("2"));
        // Verify edges of grade 1
        mockMvc.perform(get("/api/mark?percentage=88"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("1"));
        mockMvc.perform(get("/api/mark?percentage=100"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.getResponse().getContentAsString().contentEquals("1"));
    }
}