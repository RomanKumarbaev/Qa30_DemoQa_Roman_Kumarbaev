package manager;

import org.openqa.selenium.*;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }


    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }




    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();

    }

    public void scroll(int x, int y){
        JavascriptExecutor js= (JavascriptExecutor)  wd;
        js.executeScript("window.scroll(window.scrollBy(" + x + "," + y + "))");

    }
}
