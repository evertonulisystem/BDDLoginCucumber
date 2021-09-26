package steps;

import com.aventstack.extentreports.utils.FileUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class Login {
    public WebDriver driver;

    @Given("que acesso o conexaoQA")
    public void queAcessoOConexaoQA() {
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome-chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.get("https://conexaoqa.herokuapp.com/");
    }

    @And("clico no login")
    public void clicoNoLogin() {
        driver.findElement(By.cssSelector("section.landing div.dark-overlay div.landing-inner div.buttons > a.btn.btn-light:nth-child(2)")).click();
    }

    @When("coloco {string} e {string}")
    public void colocoE(String usuario, String senha) throws IOException {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("evertonuli@bol.com.br");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("Imb123");
        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();
    }

    @Then("sera exibido tela de dashboard")
    public void seraExibidoTelaDeDashboard() {
    }

    @And("o botao de criar perfil estara sendo exibido")
    public void oBotaoDeCriarPerfilEstaraSendoExibido() {
    driver.findElement(By.cssSelector("body:nth-child(2) div:nth-child(2) section.container > a.btn.btn-primary.my-1:nth-child(4)")).click();
    }

    @And("visualizo a tela de criacao do perfil")
    public void visualizoATelaDeCriacaoDoPerfil() throws IOException {

        imprimirEvidencia();
        //driver.quit();
        }

    public void imprimirEvidencia() throws IOException{
        File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printFinal, new File("target/evidencia.png"));
    }

}


