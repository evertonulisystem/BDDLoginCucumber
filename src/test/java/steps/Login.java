package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    private WebDriver driver;

    @Given("que acesso o conexaoQA")
    public void queAcessoOConexaoQA() {
        System.setProperty("webdriver.chrome.driver","drivers/Chrome-chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.get("https://conexaoqa.herokuapp.com/");
    }

    @And("clico no login")
    public void clicoNoLogin() {

        //driver.findElement(By.className("a.btn.btn-light")).click();
driver.findElement(By.cssSelector("section.landing div.dark-overlay div.landing-inner div.buttons > a.btn.btn-light:nth-child(2)")).click();

    }

    @When("coloco {string} e {string}")
    public void colocoE(String usuario, String senha) {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("evertonuli@bol.com.br");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("Imb123");
        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();
    }

    @Then("sera exibido tela de dashboard")
    public void seraExibidoTelaDeDashboard() {
        //driver.quit();
    }
}
