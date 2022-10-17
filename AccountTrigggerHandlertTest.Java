@isTest
public with sharing class AccountTriggerHandlerTest {

    @testSetup
    public static void regionalManagerData(){
        Regional_Manager__c RM = new Regional_Manager__c();
        RM.Manager__c = UserInfo.getUserId();
        RM.Region__c = 'US';
        
        Regional_Manager__c RM1 = new Regional_Manager__c();
        RM1.Manager__c = UserInfo.getUserId();
        RM1.Region__c = 'Canada';
        
        Regional_Manager__c RM2 = new Regional_Manager__c();
        RM2.Manager__c = UserInfo.getUserId();
        RM2.Region__c = 'EMEA';
        
    }
    
    @isTest
    private static void insertAccountTest(){
        Account acc = New Account();
        acc.Name = 'Singleton Test';
        acc.Region__c = 'US';
        acc.Rating = 'Hot';
        acc.Description = 'Test Account';
        acc.Website = 'www.test.com';
        insert acc;
        System.assertEquals(acc.Name, 'Singleton Test','Account Not Created');
    }
    
    @IsTest
    private static void updateAccountTest(){
        Account acc = New Account();
        acc.Name = 'Singleton Test';
        acc.Region__c = 'Canada';
        acc.Rating = 'Hot';
        acc.Description = 'Test Account';
        acc.Website = 'www.test.com';
        insert acc;
        acc.Name = 'Singleton Test Updated';
        update acc;
        System.assertEquals(acc.Name, 'Singleton Test Updated','Account Not Updated');
    }
}