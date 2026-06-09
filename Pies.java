public class Pies {
    private static int generatorId = 1;

    private int id;
    private String imie;
    private String rasa;
    private int wiek;
    private int agresywnosc;

    private boolean zaszczepiony;
    private boolean odrobaczony;
    private boolean zaczipowany;

    public Pies(String imie, String rasa, int wiek, int agresywnosc) {
        this.id = generatorId++;
        this.imie = imie;
        this.rasa = rasa;
        this.wiek = wiek;
        this.agresywnosc = agresywnosc;

        this.zaszczepiony = false;
        this.odrobaczony = false;
        this.zaczipowany = false;
    }

    public void wyswietlInformacje() {
        String szczep = zaszczepiony ? "TAK" : "NIE";
        String odrob = odrobaczony ? "TAK" : "NIE";
        String czip = zaczipowany ? "TAK" : "NIE";

        System.out.println("ID: " + id + " | " + imie + " Rasa: " + rasa + ", Wiek: " + wiek + " lat, Agresywność: " + agresywnosc + ", Szczepienie: " + szczep + ", Odrobaczanie: " + odrob + ", Czip: " + czip);
    }

    public int getId() { return id; }
    public String getImie() { return imie; }
    public int getWiek() { return wiek; }
    public int getAgresywnosc() { return agresywnosc; }

    public boolean isZaszczepiony() { return zaszczepiony; }
    public boolean isOdrobaczony() { return odrobaczony; }
    public boolean isZaczipowany() { return zaczipowany; }

    public void wykonajSzczepienie() { this.zaszczepiony = true; }
    public void wykonajOdrobaczanie() { this.odrobaczony = true; }
    public void wykonajCzipowanie() { this.zaczipowany = true; }
}
