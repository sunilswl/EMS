package com.sunil.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.app.model.Invoice;
import com.sunil.app.model.Invoicedetails;
import com.sunil.app.repository.InvoicedetailsRepository;
import com.sunil.app.repository.InvoiceRepository;
import com.sunil.app.service.InvoiceService;
@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceRepository invoRepo;
	@Autowired
	private InvoicedetailsRepository invodetailsRepo;

	@Override
	public void addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		invoRepo.save(invoice);
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		invoRepo.save(invoice);
	}

	@Override
	public List<Invoice> getAllInvoice() {
		// TODO Auto-generated method stub
		return invoRepo.findAll();
	}

	@Override
	public Invoice getById(int id) {
		// TODO Auto-generated method stub
		return invoRepo.getById(id);
	}

	@Override
	public void addInvo_details(Invoicedetails invoicedetails) {
		// TODO Auto-generated method stub
		invodetailsRepo.save(invoicedetails);
	}

}
