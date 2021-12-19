package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper extends HelperBase{
    public ActionHelper(WebDriver wd) {
        super(wd);
    }

    public void droppebTests() {
        WebElement dragMe = wd.findElement( By.id("draggable"));
        WebElement dropHere = wd.findElement( By.id("droppable"));



        Actions actions = new Actions(wd);
        //actions.dragAndDrop(dragMe,dropHere).build().perform();

        int x = (dropHere.getRect().getX()-dragMe.getRect().getX())+15;
        int y = (dropHere.getRect().getY()-dragMe.getRect().getY())+25;

        actions.dragAndDropBy(dragMe,x,y).build().perform();
        pause(3000);




        String text = dropHere.getText();
        if( text.equals("Dropped!")){
            System.out.println("Pass:");
        }else {
            System.out.println("Falied");
        }
    }

    public void selectInterections() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[5]"));
        pause(500);
    }

    public void selectDroppable() {
        hideFooter();
        click(By.xpath("//span[text()='Droppable']"));
    }
}
