package com.runescape.revised.report;

public class ReportSystem {

	private Report report;
	
	public ReportSystem(Report report) {
		this.setReport(report);
	}
	
	public void setReport(Report report) {
		this.report = report;
	}
	
	public Report getReport() {
		return this.report;
	}
}
