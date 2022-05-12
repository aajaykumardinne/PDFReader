import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PdfReaderTest {
	
	
	@Test
	public void readPDFTest() throws IOException {
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  // Launch Chrome  
		driver.get("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		URL url = new URL(currentUrl);
		InputStream is = url.openStream();
		
		BufferedInputStream fileparse = new BufferedInputStream(is);
		PDDocument document = null;
		
		document = PDDocument.load(fileparse);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		
		
		Assert.assertTrue(pdfContent.contains("Company Name"));
		
		
		
	}

}
