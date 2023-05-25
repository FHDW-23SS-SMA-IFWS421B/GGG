package ampel.state;

import ampel.ContextManager;


public class Go extends BaseState{


    

    public Go(ContextManager myContextManager){
           super(myContextManager);
    }
    
    

    @Override
    public void onTimeoutStop() {
        this.myContextManager.changeState(new Prepare(myContextManager));
        
    }



    @Override
    public void update() {
        System.out.println("Idle acctivated");
        onTimeoutStop();
    }
    
}
