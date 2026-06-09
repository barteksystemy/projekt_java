import java.util.ArrayList;

/**
 * Klasa reprezentująca schronisko dla psów.
 * Zarządza listą obiektów typu Pies, umożliwiając ich dodawanie, 
 * wyświetlanie oraz wyszukiwanie.
 */
public class Schronisko {
    
    // Lista przechowująca obiekty typu Pies znajdujące się w schronisku
    private ArrayList<Pies> listaPsow;

    /**
     * Konstruktor domyślny.
     * Inicjalizuje nową, pustą listę psów w momencie tworzenia obiektu Schronisko.
     */
    public Schronisko() {
        this.listaPsow = new ArrayList<>();
    }

    /**
     * Metoda dodająca nowego psa do schroniska.
     * @param pies Obiekt typu Pies, który ma zostać dodany do listy.
     */
    public void dodajPsa(Pies pies) {
        listaPsow.add(pies);
    }

    /**
     * Metoda sprawdzająca, czy w schronisku znajdują się jakieś psy.
     * @return true, jeśli schronisko jest puste, false w przeciwnym razie.
     */
    public boolean czyPuste() {
        return listaPsow.isEmpty();
    }

    /**
     * Metoda wyświetlająca informacje o wszystkich psach w schronisku.
     * Jeśli lista jest pusta, wyświetla odpowiedni komunikat.
     */
    public void wyswietlWszystkiePsy() {
        // Sprawdzenie, czy lista nie jest pusta, aby uniknąć zbędnego przetwarzania
        if (listaPsow.isEmpty()) {
            System.out.println("Schronisko jest aktualnie puste.");
            return;
        }

        System.out.println(); // Pusta linia dla lepszej czytelności w konsoli

        // Pętla typu foreach iterująca po wszystkich psach w liście
        for (Pies pies : listaPsow) {
            pies.wyswietlInformacje(); // Wywołanie metody wyświetlającej dane konkretnego psa
        }
    }

  
/**
 * Szuka psa na liście na podstawie jego identyfikatora (ID).
 * Deklaracja 'throws NieznalezionoPsaException' oznacza, że ta metoda 
 * może wyrzucić ten konkretny błąd, jeśli poszukiwania się nie powiodą.
 */
public Pies znajdzPsaPoId(int id) throws NieznalezionoPsaException {
    // Przeszukiwanie listy psów w celu znalezienia dopasowania
    for (Pies pies : listaPsow) {
        if (pies.getId() == id) {
            return pies; // Zwrócenie psa, gdy identyfikatory się zgadzają
        }
    }
    
    // Jeśli pętla przejdzie przez całą listę i nie znajdzie dopasowania,
    // program dotrze do tego miejsca. Zamiast zwracać null, rzucamy własny wyjątek.
    throw new NieznalezionoPsaException("Nie ma psa o numerze ID: " + id);
}
        
        // Jeśli pętla się zakończy i nie znajdzie psa, zwracany jest null
        return null;
    }

    /**
     * Getter umożliwiający innym klasom (np. warstwie logiki czy interfejsowi) 
     * dostęp do pełnej listy psów znajdujących się w schronisku.
     * @return Zwraca listę (ArrayList) wszystkich obiektów typu Pies.
     */
    public ArrayList<Pies> getListaPsow() {
        return listaPsow;
    }
    /**
 * Metoda symulująca proces poszukiwania domu dla konkretnego psa.
 * Szansa na adopcję zależy od jego wieku, agresji oraz odbytych zabiegów weterynaryjnych.
 */
public void szukajDomu(Pies pies) {
    // Normalizacja wieku (zakłada maksymalny wiek psa w okolicach 20 lat). 
    // Im starszy pies, tym wyższa wartość (waga).
    double wagaWieku = (pies.getWiek() - 1) / 19.0;

    // Normalizacja poziomu agresji. Im bardziej agresywny pies, tym wyższa wartość.
    double wagaAgresji = (pies.getAgresywnosc() - 1) / 8.0;

    // Sprawdzanie i zliczanie brakujących zabiegów (im ich więcej, tym trudniej o adopcję)
    int brakujaceZabiegi = 0;
    if (!pies.isZaszczepiony()) brakujaceZabiegi++; // Brak szczepienia
    if (!pies.isOdrobaczony()) brakujaceZabiegi++;  // Brak odrobaczenia
    if (!pies.isZaczipowany()) brakujaceZabiegi++;  // Brak czipa

    // Wyliczenie "kary", która obniży szansę na adopcję. 
    // Wiek i agresja mają największy wpływ (mnożnik 2.0), a brakujące zabiegi mniejszy (0.5).
    double kara = (wagaWieku * 2.0) + (wagaAgresji * 2.0) + (brakujaceZabiegi * 0.5);

    // Obliczenie ostatecznej szansy. Baza to 75% (0.75), a kara wykładniczo tę szansę zmniejsza.
    double szansa = 0.75 * Math.pow(0.5, kara);

    // Losowanie ułamka z zakresu od 0.0 do 1.0 (włącznie z 0, bez 1)
    double wylosowano = Math.random();

    // Wypisanie aktualnego postępu oraz szansy na adopcję w procentach
    System.out.println("Trwa proces adopcyjny... (Szansa na dom: " + Math.round(szansa * 100) + "%)");

    // Jeśli wylosowana liczba mieści się w wyliczonej szansie (np. szansa to 0.4, a wylosowano 0.3)
    if (wylosowano <= szansa) {
        System.out.println("SUKCES! Pies " + pies.getImie() + " został adoptowany!");
        listaPsow.remove(pies); // Skoro znalazł dom, usuwamy go z listy psów czekających na adopcję
    } else {
        // Jeśli wylosowana liczba okazała się wyższa niż wyliczona szansa, adopcja się nie powiodła
        System.out.println("Niestety, tym razem pies " + pies.getImie() + " nie znalazł domu. Warto zadbać o jego zabiegi!");
    }

}

