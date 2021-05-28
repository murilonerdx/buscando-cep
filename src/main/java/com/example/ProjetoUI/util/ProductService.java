package com.example.ProjetoUI.util;

import com.example.ProjetoUI.ApiAccess;
import com.example.ProjetoUI.entity.Cep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@ApplicationScoped
public class ProductService {

    List<Cep> ceps = new ArrayList<>();

    @PostConstruct
    public void init() {
        ceps.add(new Cep("01001-000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP", "11","","",""));
    }

    public List<Cep> getCeps() {
        return ceps;
    }

    public void setCeps(List<Cep> ceps) {
        this.ceps = ceps;
    }

    public List<Cep> getProducts() {
        return getCeps();
    }

}