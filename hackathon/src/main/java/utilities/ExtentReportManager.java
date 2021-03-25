package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

import baseClasses.BaseClass;

public class ExtentReportManager extends BaseClass {

	public static ExtentReports report;

	public static ExtentReports getReportInstance() {

		if (report == null) {
			String reportName = DateUtils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./screemshot/" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("User", System.getProperty("user.name"));
			report.setSystemInfo("OS", System.getProperty("os.name"));
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "1.0.0");
			report.setSystemInfo("Browser", "Chrome/Mozila");

			htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
			htmlReporter.config().setReportName("ZigWheels");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			//htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

		}

		return report;
	}

}