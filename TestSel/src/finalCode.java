

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

public class finalCode {

                public static void main(String[] args) {
                                // TODO Auto-generated method stub
                                String urlToLoad = "http://www.geeksforgeeks.org";
                                startScreen(urlToLoad);
                                
                                
                }

                private static void startScreen(String urlToLoad) {
                                // TODO Auto-generated method stub
                                System.setProperty("webdriver.chrome.driver","chrome/chromedriver.exe");
                                int name = 0;
                                WebDriver driver = new ChromeDriver();
        driver.get(urlToLoad);
            String prevUrl="";    
                                do{
                                                try{
                                                                driver.getWindowHandles();
                                                                
                                                                if(!prevUrl.equals(driver.getCurrentUrl())){
                                                                                prevUrl=driver.getCurrentUrl();
                                                                                
                                                                                System.out.print("\n*** navigated to "+prevUrl);
                                                                                
                                                                       String str = driver.getPageSource();
                                                             // System.out.println("HTML SOurce 1 " + str);
                                                              
                                                              BufferedWriter bw = null;
                                                              FileWriter fw = null;

                                                              try {
                                                                     fw = new FileWriter("D:\\"+name+".html");
                                                                     bw = new BufferedWriter(fw);
                                                                     bw.write(str);
                                                                     File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                                                                     FileUtils.copyFile(screenshot, new File("D:\\"+name+".jpg"));

                                                                     //System.out.println("Done");
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
                                                                }
                                                                
                                                }
                                                catch( WebDriverException web){
                                                                System.out.print("Manually Closed");
                                                                break;
                                                }catch(Exception e ){
                                                                System.out.print("Manually Closed");
                                                                break;
                                                }
                                                
                                }while(true);
                                
                }

}
