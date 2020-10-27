package mySqlConnection

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import groovy.sql.Sql
import java.sql.*


public class ExecutingFirstQueryInMySql {

	@Keyword
	public connection(String URL, String user, String password, String driverClassName){
		def sqlConnection = Sql.newInstance(URL, user, password, driverClassName)
		sqlConnection.eachRow("Show tables") { row ->
			println row[0]
		}
	}

	@Keyword
	public createTable(String URL, String user, String password, String driverClassName){
		def sqlConnection = Sql.newInstance(URL, user, password, driverClassName)
		def createSQLQuery = """Create Table personalDetails(
firstname varchar(50), Lastname varchar(70))"""
		sqlConnection.execute(createSQLQuery)
		sqlConnection.eachRow("Describe personalData") { row ->
			println " Column " + row[0] + " Types of Column " + row[1]
		}
	}
	@Keyword
	public insertData(String URL, String user, String password, String driverClassName){
		def sqlConnection = Sql.newInstance(URL, user, password, driverClassName)
		def createSQLQuery1 = """Create Table personalDetails2(
firstname varchar(50), Lastname varchar(70))"""
		sqlConnection.execute(createSQLQuery1)
		sqlConnection.execute("Insert into personalDetails2(firstname, Lastname) values('Pijush', 'Shukla')")
		sqlConnection.eachRow("Select * from personalDetails2") { row -> println " Firstname  = ${row[0]}, Lastname  = ${row[1]}" }
	}

	//Groovy clouser - it is set of statement that is more like a method which return and
	@Keyword
	public deleteData(String URL, String user, String password, String driverClassName){
		def sqlConnection = Sql.newInstance(URL, user, password, driverClassName)
		sqlConnection.eachRow("Select count(*) from personalDetails2") { row -> println " Number of row before deleting the data  = ${row[0]}" }
		sqlConnection.execute("Delete from personalDetails1 where Lastname='Shukla' ")
		sqlConnection.eachRow("Select count(*) from personalDetails2") { row -> println " Number of row after deleting the data  = ${row[0]}" }
		sqlConnection.execute("Drop table personalDetails1	")
		sqlConnection.eachRow("show Tables"){ row->
			println row[0]
		}

	}
}
