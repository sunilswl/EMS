package com.sunil.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.app.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
