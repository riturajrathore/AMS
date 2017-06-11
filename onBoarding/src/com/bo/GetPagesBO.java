package com.bo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beans.GetPagesBean;
import com.dao.SavePageDao;

public class GetPagesBO {

	
	public void startScreen(String urlToLoad, GetPagesBean pageBean) {
		// TODO Auto-generated method stub
		int name = 0;
		 System.setProperty("webdriver.chrome.driver",
		 "D:/office work/garagefest/Selenium/chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.get(urlToLoad);
		String prevUrl = "";
		String imageName = "";
		SavePageDao pageDao = new SavePageDao();
		do {
			imageName = pageBean.getSiteName()+"_"+pageBean.getContainerType()+"_"+ (name+"");
			try {
				driver.getWindowHandles();

				if (!prevUrl.equals(driver.getCurrentUrl())) {
					prevUrl = driver.getCurrentUrl();
					System.out.print("\n*** navigated to " + prevUrl);
					pageDao.insertUrl(prevUrl,pageBean);											//insert URL
					String str = driver.getPageSource();
					// System.out.println("HTML SOurce 1 " + str);

					BufferedWriter bw = null;
					FileWriter fw = null;

					try {
						fw = new FileWriter("D:\\office work\\garagefest\\data\\"
								+ imageName + ".html");
						bw = new BufferedWriter(fw);
						bw.write(str);
						File screenshot = ((TakesScreenshot) driver)
								.getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(screenshot, new File("D:\\office work\\garagefest\\data\\"+imageName+ ".jpg"));
						System.out.println("----------here----------------before DB");
						pageDao.insertImage("D://office work//garagefest//data//"+imageName+".jpg",pageBean);				//insert image
						pageDao.insertHtml("D://office work//garagefest//data//"+imageName+".html",pageBean);				//insert html
						// System.out.println("Done");
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (bw != null)
								bw.close();
							if (fw != null)
								fw.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}

					name++;
					imageName =  pageBean.getSiteName()+"_"+pageBean.getContainerType()+"_"+ (name+"");
				}

			} catch (WebDriverException web) {
				System.out.print("Manually Closed");
				break;
			} catch (Exception e) {
				System.out.print("Manually Closed");
				break;
			}

		} while (true);

	}

	private int getSiteName() {
		// TODO Auto-generated method stub
		return 0;
	}

}
