package by.aliaxandrtsyhanok.devincubator;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.*;

public class UBLServiceTest {
    private UBLService servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private String requestQueryString;

    @Before
    public void setUp() {
        servlet = new UBLService();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void richestUser() throws  IOException {
        requestQueryString = "richest_user";
        request.setQueryString(requestQueryString);
        servlet.doGet(request, response);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void accountsSum() throws  IOException {
        requestQueryString="accounts_sum";
        request.setQueryString(requestQueryString);
        servlet.doGet(request, response);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void blankQuery() throws  IOException {
        servlet.doGet(request, response);
        assertEquals(404, response.getStatus());
    }

    @Test
    public void otherQuery() throws  IOException {
        requestQueryString="query";
        request.setQueryString(requestQueryString);

        servlet.doGet(request, response);

        assertEquals(404, response.getStatus());
        assertTrue(response.getErrorMessage().contentEquals("UBLService for \""+requestQueryString+"\" not found!"));

    }
}