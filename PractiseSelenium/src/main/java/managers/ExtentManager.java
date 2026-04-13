package managers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import util.BaseUtils;

public class ExtentManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;

	public static void initReport() throws IOException {

		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh.mm.ss a"));

		spark = new ExtentSparkReporter("target/AutomationReport_" + time + ".html");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		
	//spark.config().setDocumentTitle(BaseUtils.getConfigValue("documentTitle"));
		spark.config().setDocumentTitle("documentTitle");
		//spark.config().setReportName(BaseUtils.getConfigValue("reportName"));
		spark.config().setReportName("reportName");
		spark.config().setTheme(Theme.STANDARD);

	}
	
	public static void flushReport() {
		extent.flush();
	}

}
