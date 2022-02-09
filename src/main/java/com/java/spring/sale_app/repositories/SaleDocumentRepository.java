package com.java.spring.sale_app.repositories;

import com.java.spring.sale_app.model.SaleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SaleDocumentRepository extends MongoRepository<SaleDocument,String> {

}
