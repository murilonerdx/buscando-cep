package com.example.ProjetoUI.util;

import com.example.ProjetoUI.entity.Cep;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Cep> ceps = new ArrayList<>();

    @Inject
    private ProductService service;

    @PostConstruct
    public void init() {
        ceps = service.getProducts();
    }

    public List<Cep> getCeps() {
        return ceps;
    }

    public void setCeps(List<Cep> ceps) {
        this.ceps = ceps;
    }

    public void setService(ProductService service) {
        this.service = service;
    }
}
