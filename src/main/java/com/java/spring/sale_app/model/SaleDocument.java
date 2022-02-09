package com.java.spring.sale_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Sale_Document")

public class SaleDocument implements Serializable {
    @Id
    private String id;
    private String libraryName;
    private String bookName;
    private Double bookPrice;
    private int unitsSold;

    public SaleDocument( ) {

    }

    public SaleDocument( String libraryName, String bookName, Double bookPrice, int unitsSold) {
        this.libraryName = libraryName;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.unitsSold = unitsSold;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }
}
