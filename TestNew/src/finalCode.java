

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                                finalCode f = new finalCode();
                                f.startScreen(urlToLoad);
                                
                                
                }

                private void startScreen(String urlToLoad) {
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
                                                                                
//                                                                       String str = driver.getPageSource();
                                                             // System.out.println("HTML SOurce 1 " + str);
                                                              
                                                              BufferedWriter bw = null;
                                                              FileWriter fw = null;

                                                              try {
                                                                    /* fw = new FileWriter("D:\\new ff\\"+name+".html");
                                                                     bw = new BufferedWriter(fw);
                                                                     bw.write(str);*/
                                                                     System.out
																			.println("--------------testing from here--------");
                                                                     File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                                                                     FileUtils.copyFile(screenshot, new File("D:\\new ff\\"+name+".jpg"));
                                                                     this.insertImage("D:\\new ff\\"+name+".jpg");
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
                public void insertImage(String img)
                {
                        int len;
                        String query;                 
                        try
                        {
                                File file = new File(img);
                                FileInputStream fis = new FileInputStream(file);
                                len = (int)file.length();
                                query = ("insert into imagetable VALUES(?,?,?)");
                                System.out.println("-------------------file.getName-----------"+file.getName());
                        		PreparedStatement pstmt =  this.runQuery(query);
                                pstmt.setString(1,"Rahul");
                                // Method used to insert a stream of bytes
                                pstmt.setBinaryStream(2, fis, len); 
                                pstmt.setInt(3, len);
                                pstmt.executeUpdate();
         
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                        }
                }
                
                public void insertHtml(String htmlfile) {

                    int len;
                    String query;                 
                    try
                    {
                            File file = new File(htmlfile);
                            FileInputStream fis = new FileInputStream(file);
                            len = (int)file.length();
                            query = ("insert into html_page VALUES(?,?,?)");
                            System.out.println("-------------------file.getName-----------"+file.getName());
                    		PreparedStatement pstmt =  this.runQuery(query);
                            pstmt.setString(1,"Rahulp");
                            // Method used to insert a stream of bytes
                            pstmt.setBinaryStream(2, fis, len); 
                            pstmt.setInt(3, len);
                            pstmt.executeUpdate();

                    }
                    catch (Exception e)
                    {
                            e.printStackTrace();
                    }
        			
        		}
                public PreparedStatement runQuery(String queryStatement) {
            		PreparedStatement preparedState=null;
            		try {
            			Class.forName("com.mysql.jdbc.Driver");
            			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.109:3306/rapidnsr", "root","password");
            			preparedState = con.prepareStatement(queryStatement);
            		} catch (ClassNotFoundException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		} catch (SQLException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            		return preparedState;

            	}

}
