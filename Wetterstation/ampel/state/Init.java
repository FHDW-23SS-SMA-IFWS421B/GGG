package ampel.state;

import ampel.ContextManager;

public class Init extends BaseState {

    

    public Init(ContextManager myContextManager){
            super(myContextManager);
    }

    @Override
    public void update() {
        System.out.println("init aktivated");
        this.myContextManager.changeState(new Idle(myContextManager));
    }
    
}
