/**
 * Własna klasa wyjątku, która dziedziczy po wbudowanej klasie Exception w Javie.
 * Służy do sygnalizowania sytuacji, w której próbujemy znaleźć psa (np. po ID), 
 * ale nie ma go na liście w schronisku.
 */
public class NieznalezionoPsaException extends Exception {
    
    /**
     * Konstruktor klasy wyjątku, który pozwala przekazać własną wiadomość.
     * * @param message Szczegółowy komunikat błędu (np. "Nie ma psa o numerze ID: 5").
     */
    public NieznalezionoPsaException(String message) {
        // Słowo kluczowe 'super' wywołuje konstruktor klasy nadrzędnej (w tym przypadku klasy Exception).
        // Przekazujemy jej nasz komunikat, dzięki czemu będzie można go później łatwo 
        // odczytać (np. wywołując metodę e.getMessage() podczas łapania wyjątku).
        super(message);
    }
}
