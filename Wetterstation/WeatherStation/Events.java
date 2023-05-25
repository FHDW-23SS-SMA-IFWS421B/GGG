package WeatherStation;

public enum Events {
    NOCHOSE(0,"keine Wahl", 0),
    STORM(1, "Sturm", 1000),
    HEATWAVE(2, "Hitzewelle", 30),
    HEAVYRAIN(3,"Starkregen", 5);

    private int id;
    private String name;
    private int zahl;
    private Events (final int id, final String name, final int zahl){
        this.id=id;
        this.name=name;
        this.zahl=zahl;
    }
    public int getID(){
        return this.id;
    }
    private String getName(){
        return this.name;
    }

    public int getID(boolean wert){
        if (wert==false){
            return -1;
        }
        return this.id;

    }
    public int getMin()
    {
        return zahl;
    }
    
}
