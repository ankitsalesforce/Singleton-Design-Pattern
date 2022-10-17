trigger AccountTrigger on Account (before insert,before delete,before Update) {

   /* if(trigger.isAfter && (trigger.isUpdate || trigger.isInsert)){
        AccountTriggerHandler.handleAfterInsertUpdate(trigger.new);
    }
    
    if(trigger.isBefore && trigger.isDelete){
        AccountTriggerHandler.handlerBeforeDelete(trigger.old,trigger.oldMap);
    }*/
    
    /*if(trigger.isAfter && trigger.isDelete){
        AccountTriggerHandler.handleAfterDeletion(trigger.oldMap);
     }*/
    
    //ref Singleton Design Pattern 
    if(Trigger.isInsert){
        AccountTriggerHandler.onbeforeInsert();
    }
    if(Trigger.isUpdate && Trigger.isBefore){
      AccountTriggerHandler.onbeforeUpdate(Trigger.oldMap,Trigger.New);
    }
}