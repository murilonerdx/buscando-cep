package com.example.ProjetoUI;

import com.example.ProjetoUI.entity.Cep;
import com.example.ProjetoUI.util.BasicView;
import com.example.ProjetoUI.util.MaskView;
import com.example.ProjetoUI.util.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Named
@RequestScoped
public class ApiAccess {

    @Inject
    private ProductService service;

    @Inject
    private MaskView maskView;

    private String cep;

    public ApiAccess(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ApiAccess() {
    }

    public void save(){
        try {
            URL url = new URL("https://viacep.com.br/ws/"+maskView.getCep()+"/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream()), StandardCharsets.UTF_8));
            Cep value = new ObjectMapper().readValue(response , Cep.class);
            service.getCeps().add(value);
            if (connection.getResponseCode() != 200){
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
