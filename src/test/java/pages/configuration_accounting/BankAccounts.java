package pages.configuration_accounting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class BankAccounts {
    public BankAccounts(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//span[@class='oe_menu_text'][contains(text(),'Bank Accounts')])[3]")
    public WebElement bankAccountLink;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createBtn;

    
    @FindBy(name = "name")
    public WebElement bankNameField;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement bankAccount;

    @FindBy(name = "bank_acc_number")
    public WebElement bankAccountNum;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[2]")
    public WebElement bankName;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement newSaveButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement createABankAccntBtn;

    @FindBy(xpath = "(//li[@class='active'])[3]")
    public WebElement pageName;

    public WebElement  savedBankAcctnOnPage() {
        return Driver.getDriver().findElement(By.xpath("//td[@class='o_data_cell o_required_modifier'][contains(text(),'"+ ConfigurationReader.getProperty("bankaccountname")+"')]"));
    }

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[3]")
    public WebElement actionButton;

    @FindBy(xpath ="//a[contains(text(),'Delete')]" )
    public WebElement deleteBtn;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary'][.='Ok']")
    public WebElement okButtonAfterDelete;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//tr//td[3]")
    public List<WebElement> journalNames;

    @FindBy(xpath = "//h4[contains(text(),'Odoo Server Error')]")
    public WebElement odooServerErrorMsg;

    public boolean isDisplayed(String name){
        boolean check=false;

        for(WebElement list : journalNames){
            if(list.getText().contains(name)){
                check=true;
            }
        }
        return check;
    }

}
