import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicjalizacja bazy na nasze zwierzaki i skanera do czytania z klawiatury
        Schronisko schronisko = new Schronisko();
        Scanner scanner = new Scanner(System.in);

        // Wrzucamy kilka piesków na start, żeby od razu było co testować
        schronisko.dodajPsa(new Pies("Reksio", "Mieszaniec", 5, 2));
        schronisko.dodajPsa(new Pies("Killer", "Amstaff", 12, 8)); // Groźny chłop
        schronisko.dodajPsa(new Pies("Burek", "Kundel", 1, 1));

        // Zmienna trzymająca pętlę przy życiu
        boolean dziala = true;

        // Kręcimy się tutaj, dopóki użytkownik nie będzie chciał wyjść
        while (dziala) {
            // Wypluwamy na ekran nasze menu
            System.out.println("\nMENU SCHRONISKA");
            System.out.println("a - Wyświetl listę wszystkich psów");
            System.out.println("f - Dodanie psa");
            System.out.println("q - Zakończ program");
            System.out.print("Wybierz opcję: ");

            // Pobieramy opcję, ucinamy niepotrzebne spacje i dajemy na małe litery
            // (taki tam system obronny przed dziwnymi wpisami)
            String opcja = scanner.nextLine().trim().toLowerCase();

            switch (opcja) {
                case "a":
                    // Opcja A: Pokazujemy inwentarz
                    if (schronisko.czyPuste()) {
                        System.out.println("Schronisko jest puste. Brak podopiecznych do wyświetlenia.");
                    } else {
                        System.out.println("AKTUALNI PODOPIECZNI SCHRONISKA");
                        schronisko.wyswietlWszystkiePsy();
                    }
                    break;

                case "f":
                    // Opcja F: Dodajemy nowego pieseła
                    System.out.print("Podaj imię psa: ");
                    String imie = scanner.nextLine();

                    System.out.print("Podaj rasę: ");
                    String rasa = scanner.nextLine();

                    int wiek = 0;
                    // Nieskończona pętla na wiek - męczymy usera aż wpisze poprawnie
                    while (true) {
                        System.out.print("Podaj wiek (w latach, 1-20): ");
                        try {
                            wiek = Integer.parseInt(scanner.nextLine());
                            if (wiek >= 1 && wiek <= 20) {
                                break; // Jest git, można lecieć dalej
                            } else {
                                System.out.println("Błąd: Wiek musi być w przedziale od 1 do 20.");
                            }
                        } catch (NumberFormatException ex) {
                            // Łapiemy jak ktoś wpisze "pięć" zamiast "5"
                            System.out.println("Błąd: Wpisano tekst zamiast liczby! Spróbuj ponownie.");
                        }
                    }

                    int agresja = 0;
                    // Taka sama jazda z agresywnością
                    while (true) {
                        System.out.print("Podaj agresywność (1-9): ");
                        try {
                            agresja = Integer.parseInt(scanner.nextLine());
                            if (agresja >= 1 && agresja <= 9) {
                                break; // Wszystko gra, przerywamy pętlę
                            } else {
                                System.out.println("Błąd: Agresywność musi być w przedziale od 1 do 9.");
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Błąd: Wpisano tekst zamiast liczby! Spróbuj ponownie.");
                        }
                    }

                    // Składamy psa do kupy z zebranych danych i wrzucamy do schroniska
                    Pies nowyPies = new Pies(imie, rasa, wiek, agresja);
                    schronisko.dodajPsa(nowyPies);
                    System.out.println("Pies " + imie + " został pomyślnie dodany do schroniska!");
                    break;

                case "q":
                    // Opcja Q: Zwijamy interes
                    System.out.println("Zamykanie systemu...");
                    dziala = false; // To elegancko ubije nam główną pętlę
                    break;

                default:
                    // Jak ktoś wciśnie coś spoza menu
                    System.out.println("Nieznana opcja. Spróbuj ponownie.");
                    break;
            }
        }
        // Na koniec zamykamy skaner, żeby środowisko nie krzyczało o wyciekach pamięci
        scanner.close();
    }
}