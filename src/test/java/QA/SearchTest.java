package QA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        
               
        
        WebElement searchButton = driver.findElement(By.className("search"));
        
        
        searchButton.click();
        
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#cp-input-0")));
        
        
        searchInput.click();
        
        
        String searchTerm = "motor fuera de borda";
        searchInput.sendKeys(searchTerm);
        
        
        searchInput.sendKeys(Keys.ENTER);
        
        // Esperar a que se carguen los resultados 
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Verificar si la URL contiene al menos una de las palabras del término de búsqueda
        String currentUrl = driver.getCurrentUrl();
        String[] searchTerms = searchTerm.toLowerCase().split(" ");
        boolean found = false;
        for (String term : searchTerms) {
            if (currentUrl.contains(term.replace(" ", "%20"))) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "La búsqueda no arrojó los resultados esperados");
        System.out.println("La búsqueda se realizó con éxito");
    }
}
