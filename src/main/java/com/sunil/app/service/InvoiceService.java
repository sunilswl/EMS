package com.sunil.app.service;

import java.util.List;
import com.sunil.app.model.Invoice;
import com.sunil.app.model.Invoicedetails;

public interface InvoiceService {
	void addInvoice(Invoice invoice);
	void updateInvoice(Invoice invoice);
	List<Invoice> getAllInvoice();
	Invoice getById(int id);
	
	void addInvo_details(Invoicedetails invoicedetails);
}
