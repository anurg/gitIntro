/*Created by Anurag Bhatt.!!! */

package com.dsgroup.first;


import java.text.NumberFormat;

public class Po {

	private String company;
	private String poType;
	private String poSeries;
	private String poNo;
	private String supplierName;
	private String poTotal;
	
	public Po(String company, String poType, String poSeries, String poNo,
			String supplierName, String poTotal) {
		super();
		this.company = company;
		this.poType = poType;
		this.poSeries = poSeries;
		this.poNo = poNo;
		this.supplierName = supplierName;
		this.poTotal = poTotal;
	}
	public String getCompany() {
		return company;
	}
	public String getPoType() {
		return poType;
	}

	public String getPoSeries() {
		return poSeries;
	}

	public String getPoNo() {
		return poNo;
	}

	public String getSupplierName() {
		return supplierName;
	}
	public String getPoTotal() {
		return poTotal;
	}
	public String getFormattedPoTotal() {
		NumberFormat number=NumberFormat.getNumberInstance();
		return number.format(poTotal);
	}
	public String toString() {
		return company;
	}
	
}
