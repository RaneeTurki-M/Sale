package com.java.spring.sale_app.service;

import com.java.spring.sale_app.model.SaleDocument;
import com.java.spring.sale_app.repositories.SaleDocumentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SaleDocumentService {

    private final SaleDocumentRepository saleDocumentRepository;

    @Autowired
    public SaleDocumentService(SaleDocumentRepository saleDocumentRepository) {
        this.saleDocumentRepository = saleDocumentRepository;
    }


    public SaleDocument addSaleDocument(SaleDocument saleDocument)  {
        saleDocument.setId((ObjectId.get().toString() ));
        return saleDocumentRepository.save(saleDocument);
    }

    public List<SaleDocument> findAll() {
        return (List<SaleDocument>) saleDocumentRepository.findAll();
    }


    public SaleDocument findOne(String id) {
        Optional<SaleDocument> saleDocument = saleDocumentRepository.findById(id);
        if (saleDocument.isPresent())
            return saleDocument.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sale Document Not Found");
    }

    public void save(SaleDocument saleDocument) {
        saleDocumentRepository.save(saleDocument);
    }



    public void delete(String id ) {
        if (saleDocumentRepository.findById(id).get()==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sale Document Not Found");
        saleDocumentRepository.deleteById(id);
    }

}
