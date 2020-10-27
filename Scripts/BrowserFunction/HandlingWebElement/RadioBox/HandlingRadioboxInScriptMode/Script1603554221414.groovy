import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser("https://abodeqa.com/wp-content/uploads/2016/05/DemoSite.html");
WebUI.maximizeWindow();
WebUI.delay(3);
WebUI.click(findTestObject('Object Repository/AbodeqaWebUIElementObject/Radiobox/SexFeMaleRB'));
WebUI.delay(5);
WebUI.click(findTestObject('Object Repository/AbodeqaWebUIElementObject/Radiobox/SexMaleRB'));
WebUI.delay(3);
WebUI.verifyElementChecked(findTestObject('Object Repository/AbodeqaWebUIElementObject/Radiobox/SexMaleRB'), 3)
WebUI.closeBrowser();
