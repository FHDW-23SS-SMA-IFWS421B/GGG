package ampel.state;

import ampel.ContextManager;

public class Idle extends BaseState {

    
    public Idle(ContextManager myContextManager){
           super(myContextManager);
    }
    
    @Override
    public void onButton() {
        this.myContextManager.changeState(new Prepare(myContextManager));

    }

    @Override
    public void update() {
        System.out.println("Idle acctivated");


    
    }
    
}
