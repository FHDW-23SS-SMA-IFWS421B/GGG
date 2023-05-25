package ampel;

public interface IState {
    void onButton();
    void onTimeoutStart();
    void onTimeoutStop();
    void onTimeoutEnd();
    void update();
}
