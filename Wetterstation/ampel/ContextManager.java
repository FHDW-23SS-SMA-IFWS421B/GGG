package ampel;

import ampel.state.Init;

public class ContextManager {
    
    IState myState = new Init(this);
    public boolean goNext = false;

    public void changeState(IState myNewState){
        this.myState = myNewState;
    }
   
    public void onButton() {
        myState.onButton();
    }

   
    public void onTimeoutStart() {
       myState.onTimeoutStart();
    
    }

    
    public void onTimeoutStop() {
        myState.onTimeoutStop();
    }

    
    public void onTimeoutEnd() {
        goNext=false;
      myState.onTimeoutEnd();
    }

    public void update() {
       myState.update();
    }

}
