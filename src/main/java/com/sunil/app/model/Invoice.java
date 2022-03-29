package com.sunil.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="invoice_tbl")
public class Invoice {
	@Id
	@GeneratedValue
	private int id;
	private float total;
	private int client_id;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date invoicedate;
	private String billno;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bill_no")
	private List<Invoicedetails> invoicedetails=new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public Date getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public List<Invoicedetails> getInvoicedetails() {
		return invoicedetails;
	}
	public void setInvoicedetails(List<Invoicedetails> invoicedetails) {
		this.invoicedetails = invoicedetails;
	}	
}
