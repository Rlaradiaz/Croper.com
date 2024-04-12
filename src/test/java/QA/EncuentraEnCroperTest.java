package QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class EncuentraEnCroperTest extends BaseTest {

    @Test
    public void testCarouselItems() {
        
        
          
        List<WebElement> carouselItems = driver.findElements(By.className("cp-carousel-container"));

      
        for (int i = 0; i < carouselItems.size(); i++) {
            List<WebElement> updatedCarouselItems = driver.findElements(By.cssSelector("body > cp-root > cp-layout > main > div > cp-home > cp-carousel.home-featureds > section > div > cp-carousel-slide > a")); 
            WebElement item = updatedCarouselItems.get(i);
            item.click();
    
            
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            
            String currentUrl = driver.getCurrentUrl();
            printUrlContains(currentUrl, "Insumo");
            printUrlContains(currentUrl, "Producto");
            printUrlContains(currentUrl, "stores");
            printUrlContains(currentUrl, "login");
            printUrlContains(currentUrl, "credit");
            printUrlContains(currentUrl, "offers");
    
            
            driver.navigate().back();
        }
    }

    private void printUrlContains(String url, String keyword) {
        if (url.contains(keyword)) {
            System.out.println("La URL contiene '" + keyword + "'");
        }
    }  
}      