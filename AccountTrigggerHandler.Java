public class AccountTriggerHandler {
    
   //Singelton design pattern
    public static void onbeforeUpdate(map<id,Account> existingRecords,list<Account> accList){
        //RegionalManagerUtility utils = new RegionalManagerUtility();
        RegionalManagerUtility utils = RegionalManagerUtility.getInstance(); //As we are calling public method/Singleton Design pattern
      
        for(Account acc : accList ){
            Account oldAcc  = existingRecords.get(acc.Id);
            if(acc.Region__c != oldAcc.Region__c){
                system.debug('acc.Region__c != oldAcc.Region__c');
                 acc.RegionManager__c = utils.regionMap.get(acc.Region__c);
            }
        }
    }
    
     public static void onbeforeInsert(){
        //RegionalManagerUtility utils = new RegionalManagerUtility(); 
        RegionalManagerUtility utils = RegionalManagerUtility.getInstance();
         
        for(Account acc : (list<Account>) Trigger.New ){
            acc.RegionManager__c = utils.regionMap.get(acc.Region__c);
        }
    }
}