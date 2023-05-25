package ampel.state;

import ampel.ContextManager;
import ampel.IState;

public class BaseState implements IState{
    ContextManager myContextManager;

    public BaseState(ContextManager myContextManager){
            this.myContextManager = myContextManager;
    }
    
    @Override
    public void onButton() {

    }

    @Override
    public void onTimeoutStart() {
        
    }

    @Override
    public void onTimeoutStop() {
        
    }

    @Override
    public void onTimeoutEnd() {
        
    }

    @Override
    public void update() {
            
    }
    
}
