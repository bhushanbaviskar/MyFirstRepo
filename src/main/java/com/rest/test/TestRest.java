/*package com.rest.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

import com.rest.entities.User;


public class TestRest {
    public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/JerseyPOC/rest/user/").build());
        User user = new User();
        user.setName("User_1");
        user.setPassword("Pwd_1");
        ClientResponse response = webResource.path("add").type(MediaType.APPLICATION_JSON).post(ClientResponse.class, user);
        System.out.println("Response " + response.getEntity(String.class));
    }
}*/