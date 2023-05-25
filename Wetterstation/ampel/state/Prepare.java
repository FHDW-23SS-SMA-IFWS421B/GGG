package ampel.state;

import ampel.ContextManager;
import ampel.IState;

public class Prepare extends BaseState {
    	
  

    public Prepare(ContextManager myContextManager){
          super(myContextManager);
    }


    @Override
    public void onTimeoutStart() {
        this.myContextManager.changeState(new Go(myContextManager));
       
    }

    @Override
    public void onTimeoutEnd() {
        this.myContextManager.changeState(new Idle(myContextManager));
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        System.out.println("Preapere activated");
        if(myContextManager.goNext){
            myContextManager.goNext = false;
            onTimeoutEnd();
           
        }
        else {
            myContextManager.goNext = true;
            onTimeoutStart();
        }
        
    }
    
}
