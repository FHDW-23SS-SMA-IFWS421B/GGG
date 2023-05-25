package WeatherStation;

public enum Events {
    STORM(1, "Sturm")
    HEATWAVE(2, "Hitzewelle")
    HEAVYRAIN(3,"Starkregen");

    private int id;
    private String name;
    private Events (final int id, final String name){
        this.id=id;
        this.name=name;
    }
    private in getID(){
        return id;
    }
    
}
