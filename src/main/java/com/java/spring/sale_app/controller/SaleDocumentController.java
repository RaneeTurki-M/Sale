package com.java.spring.sale_app.controller;

import com.java.spring.sale_app.model.SaleDocument;
import com.java.spring.sale_app.repositories.SaleDocumentRepository;
import com.java.spring.sale_app.service.SaleDocumentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/saledocument")

public class SaleDocumentController {

    private SaleDocumentService saleDocumentService;

    @Autowired
    public SaleDocumentController(SaleDocumentService saleDocumentService) {
        this.saleDocumentService = saleDocumentService;
    }




    @GetMapping("/all")
    public List<SaleDocument> findAll() {
        return saleDocumentService.findAll();
    }


    @GetMapping("/{id}")
    public SaleDocument getSaleDocumentById(@PathVariable("id") String id) {
        return saleDocumentService.findOne(id);
    }

  /*  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateSaleDocumentById(@PathVariable("id") ObjectId  id,  @RequestBody SaleDocument saleDocument) {
        saleDocument.setId(id.toString());
        repository.save(saleDocument);
    }*/



    @PutMapping
    public SaleDocument updateSaleDocument(@RequestBody SaleDocument saleDocument) {

        saleDocumentService.save(saleDocument);

        return saleDocument;
    }
   /* @RequestMapping(value = "/", method = RequestMethod.POST)
    public SaleDocument addNewSaleDocument( @RequestBody SaleDocument saleDocument) {
        saleDocument.setId(ObjectId.get().toString());
        repository.save(saleDocument);
        return saleDocument;
    }*/

    @PostMapping
    public SaleDocument addSaleDocument(@RequestBody SaleDocument saleDocument) {

        saleDocumentService.save(saleDocument);

        return saleDocument;
    }


    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSaleDocumentByID(@PathVariable("id") String id) {
        repository.delete(repository.findOne(id.toString()));
    }*/

    @DeleteMapping
    public String deleteBook(@PathVariable String id) {

        SaleDocument saleDocument = saleDocumentService.findOne(id);

        // throw exception if null

        if (saleDocument == null) {
            throw new RuntimeException("Sale Document not found - " + id);
        }

        saleDocumentService.delete(id);

        return "Deleted sale document - " + id;
    }
}

