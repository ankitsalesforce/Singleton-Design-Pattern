public with sharing class RegionalManagerUtility {
    private static RegionalManagerUtility utils{get;private set;} //as per singleton design patteren, we req. one private variable
    public map<string,string> regionMap {get;private set;} //you can access anything but cannot set anything
        
   // public RegionalManagerUtility(){
    Private RegionalManagerUtility(){ //make constructor private so no one can access this easily ,As per Singleton design pattern
        this.regionMap = new Map<string,string>();
        for(Regional_Manager__c region : [SELECT Id,Region__c,Manager__c FROM Regional_Manager__c LIMIT 50]){
            this.regionMap.Put(region.Region__c,region.Id);
        }
    }
    
    public static RegionalManagerUtility getInstance(){
        if(utils == null){
            utils = new RegionalManagerUtility();
        }
        system.debug('Utils >> ' +utils);
        return utils;
    }

}