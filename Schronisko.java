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
     * Metoda wyszukująca psa w schronisku na podstawie jego unikalnego identyfikatora.
     * @param id Identyfikator szukanego psa.
     * @return Zwraca znaleziony obiekt typu Pies lub null, jeśli pies o danym ID nie istnieje.
     */
    public Pies znajdzPsaPoId(int id) {
        // Przeszukiwanie listy psów w celu znalezienia dopasowania
        for (Pies pies : listaPsow) {
            if (pies.getId() == id) {
                return pies; // Zwrócenie psa, gdy identyfikatory się zgadzają
            }
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
}
