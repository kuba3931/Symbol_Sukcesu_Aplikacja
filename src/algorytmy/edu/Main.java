package algorytmy.edu;

import java.util.*;

public class Main {

    static HashMap<String, String> database = new HashMap<>();

    public static void main(String[] args) {

        database.put("unlogged", " ");
        database.put("Jakub", "Kuba3931");
        database.put("Ewelina", "Ruby2002");


        welcome();
        menu("unlogged",false);


    }

    public static void welcome() {

        System.out.println("  _  __                         _              _");
        System.out.println(" | |/ /                        | |            (_)");
        System.out.println(" | ' / ___  _ __ ___ _ __   ___| |_ _   _  ___ _  ___");
        System.out.println(" |  < /   \\| '__/ _ \\ '_ \\ / _ \\ __| | | |/ __| |/ _ \\");
        System.out.println(" | . \\ (_) | | |  __/ |_) |  __/ |_| |_| | (__| |  __/");
        System.out.println(" |_|\\_\\___/|_|  \\___| .__/ \\___|\\__|\\__, |\\___| |\\___|");
        System.out.println("                    | |              __/ |   _/ |     ");
        System.out.println("   _____            |_|  _          |___/ __|__/      _");
        System.out.println("  / ____|               | |         | |  / ____|     | |");
        System.out.println(" | (___  _   _ _ __ ___ | |__   ___ | | | (___  _   _| | _____ ___  ___ _   _");
        System.out.println("  \\___ \\| | | | '_ ` _ \\| '_ \\ / _ \\| |  \\___ \\| | | | |/ / __/ _ \\/ __| | | |");
        System.out.println("  ____) | |_| | | | | | | |_) | (_) | |  ____) | |_| |   < (_|  __/\\__ \\ |_| |");
        System.out.println(" |_____/ \\__, |_| |_| |_|_.__/ \\___/|_| |_____/ \\__,_|_|\\_\\___\\___||___/\\__,_|");
        System.out.println("          __/ | ");
        System.out.println("         |___/ \n");

    }

    public static void menu(String user, boolean a) {

        if (a) {
            System.out.println("\n  __  __       _");
            System.out.println(" |  \\/  |     (_)");
            System.out.println(" | \\  / | __ _ _ _ __    _ __ ___   ___ _ __  _   _");
            System.out.println(" | |\\/| |/ _` | | '_ \\  | '_ ` _ \\ / _ \\ '_ \\| | | |");
            System.out.println(" | |  | | (_| | | | | | | | | | | |  __/ | | | |_| |");
            System.out.println(" |_|  |_|\\__,_|_|_| |_| |_| |_| |_|\\___|_| |_|\\__,_|\n");
        }

        Scanner input = new Scanner(System.in);


        while (true) {


            if (Objects.equals(user, "unlogged")) {

                System.out.println("Menu Glowne:");
                System.out.println("1. Zaloguj sie \n2. Stworz konto \n3. Zamknij program");

                int choice = input.nextInt();

                switch (choice) {

                    case 1 -> login();

                    case 2 -> create_acc();

                    case 3 -> {
                        System.out.println("Dziekuje za skorzytsanie z mojego programu, niech wiedza bedzie z toba");
                        System.exit(0);
                    }

                    default -> System.out.println("Niepoprawny wybor \n");
                }
            } else {

                System.out.println("Menu glowne: Witaj " + user);
                System.out.println("1. Panel Zajec \n2. Wyloguj sie \n3. Zamknij program");


                int choice = input.nextInt();

                switch (choice) {

                    case 1 -> menu_panelu(user);

                    case 2 -> {
                        System.out.println("Wylogowano uzytkownika " + user + "\n");
                        menu("unlogged", false);
                    }
                    case 3 -> {
                        System.out.println("Dziekuje za skorzytsanie z mojego programu, niech wiedza bedzie z toba");
                        System.exit(0);
                    }

                    default -> System.out.println("Niepoprawny wybor \n");
                }
            }
        }
    }

    public static void create_acc() {

        System.out.println("\nStworz nowe konto\n");


        Scanner input = new Scanner(System.in);

        String good_user;
        String good_password;

        System.out.println("Podaj nazwe uzytkownika");

        while (true) {

            String user = input.nextLine();

            if (!database.containsKey(user)) {
                good_user = user;
                break;
            } else {
                System.out.println("Baza zawiera juz tego uzytkownika, sprobuj ponownie");
            }
        }

        System.out.println("Podaj haslo, haslo musi miec conajmniej 6 znakow, zawierac male i duze litery oraz cyfre");

        while (true) {

            String pass = input.nextLine();

            if (pass_sec(pass)) {
                good_password = pass;
                break;
            } else {
                System.out.println("Haslo nie jest wystarczajaco bezpieczne");
            }

        }

        System.out.println("Potwierdz haslo");

        while (true) {

            String confirm = input.nextLine();

            if (Objects.equals(good_password, confirm)) {
                System.out.println("hasla sie zgadzaja\n");
                break;
            } else {
                System.out.println("Haslo nie sa identyczne, sprobuj ponownie");
            }

        }

        database.put(good_user, good_password);

        System.out.println("dodano nowego uzytkownika [" + good_user + "] haslo [" + good_password + "]\n");
        System.out.println("Mozesz teraz sie zalogowac\n");

        menu("unlogged", true);
    }

    private static boolean pass_sec(String pass) {

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int i;


        if (pass.length() > 6) {
            a = 1;
        }

        for (i = 0; i < pass.length(); i++) {
            char z = pass.charAt(i);

            if (Character.isLowerCase(z)) {
                b = 1;
            }

            if (Character.isUpperCase(z)) {
                c = 1;
            }

            if (Character.isDigit(z)) {
                d = 1;
            }
        }

        return a + b + c + d == 4;
    }

    public static void login() {

        Scanner input = new Scanner(System.in);

        String user_login;

        while (true) {

            System.out.println("Podaj nazwe uzytkownika");
            user_login = input.nextLine();

            if (database.containsKey(user_login) && !Objects.equals(user_login, "unlogged")) {

                System.out.println("Podaj haslo do logowania");
                String password_login = input.nextLine();

                String check = database.get(user_login);

                if (Objects.equals(password_login, check)) {

                    System.out.println("Logowanie udane \n");
                    break;
                } else {
                    System.out.println("Logowanie nieudane, sprobuj ponownie\n");
                }
            } else {
                System.out.println("Nie ma takiego uzytkownika w bazie\n");
            }
        }

        menu(user_login, true);

    }

    public static void menu_panelu(String user) {

        System.out.println("\n  _                                     _____                 _");
        System.out.println(" | |                                   |  __ \\               | |");
        System.out.println(" | |     ___  ___ ___  ___  _ __  ___  | |__) |_ _ _ __   ___| |");
        System.out.println(" | |    / _ \\/ __/ __|/ _ \\| '_ \\/ __| |  ___/ _` | '_ \\ / _ \\ |");
        System.out.println(" | |___|  __/\\__ \\__ \\ (_) | | | \\__ \\ | |  | (_| | | | |  __/ |");
        System.out.println(" |______\\___||___/___/\\___/|_| |_|___/ |_|   \\__,_|_| |_|\\___|_|\n");


        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Panel Zajec:");
            System.out.println("1. Harmonogram twoich zajec \n2. Oblicz koszt zajec \n3. Narzedzia matetyczne\n4. Edytuj dane uzytkownika\n5. Powrot do menu");


            int choice = input.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.println("Tutaj bedzie ta funkcja 1\n");
                    error_404(user);
                }

                case 2 -> {
                    System.out.println("Tutaj bedzie ta funkcja 2\n");
                    error_404(user);
                }

                case 3 -> math_func(user);

                case 4 -> {
                    System.out.println("Tutaj bedzie ta funkcja 4\n");
                    error_404(user);
                }

                case 5 -> {
                    System.out.println("Powrot do menu glownego \n");
                    menu(user, true);
                }

                default -> System.out.println("Niepoprawny wybor \n");
            }


        }

    }


    private static void math_func(String user) {

        Scanner input = new Scanner(System.in);

        System.out.println("\n                 _   _");
        System.out.println("                | | | |");
        System.out.println(" _ __ ___   __ _| |_| |__");
        System.out.println("| '_ ` _ \\ / _` | __| '_ \\");
        System.out.println("| | | | | | (_| | |_| | | |");
        System.out.println("|_| |_| |_|\\__,_|\\__|_| |_|\n");

        while (true) {

            System.out.println("Dostepne narzedzia matematyczne:");
            System.out.println("1. Wlasnosci trojkata \n2. Wlasnoci liczby calkowitej \n3. Rownanie kwadratowe");
            System.out.println("4. Ciagi liczbowe\n5. Wartosci funkcji trygonometrycznych\n6. Powrot do panelu zajec");

            int choice = input.nextInt();

            switch (choice) {

                case 1 -> triangle(user);

                case 2 -> numbers(user);

                case 3 -> quadratic(user);

                case 4 -> ciongi(user);

                case 5 -> trygo_brygo(user);

                case 6 -> menu_panelu(user);

                default -> System.out.println("Niepoprawny wybor \n");
            }
        }
    }

    public static void error_404(String user) {

        System.out.println("Implementacja tych metod na ten moment mnie przerosla, zrobie je kiedy lepiej poznam klasy");
        System.out.println("1. Powrot do panelu zajec\n2. Przejdz do narzedzi matematycznych");

        Scanner input = new Scanner(System.in);

        while(true) {

            int choice = input.nextInt();

            switch (choice) {

                case 1 -> menu_panelu(user);

                case 2 -> math_func(user);

                default -> System.out.println("Niepoprawny wybor \n");

            }
        }
    }

    public static void triangle(String user) {

        System.out.println("           _____");
        System.out.println("          / \\   \\");
        System.out.println("         /   \\   \\");
        System.out.println("        /     \\   \\");
        System.out.println("       /   '   \\   \\");
        System.out.println("      /   / \\   \\   \\");
        System.out.println("     /   /   \\   \\   \\");
        System.out.println("    /   /    '\\   \\   \\");
        System.out.println("   /   /    /  \\   \\   \\");
        System.out.println("  /   /    /    \\   \\   \\");
        System.out.println(" /   /    /----------'   \\");
        System.out.println("/   /    /________________\\");
        System.out.println("\\  /                      /");
        System.out.println(" \\/______________________/\n");

        System.out.println("Witaj, wprowadz dlugosci bokow swojego trojkata, a opowiem ci kilka rzeczy o nim\n");

        Scanner input = new Scanner(System.in);

        while (true) {


            double a = 0;
            double b = 0;
            double c = 0;

            try {
                System.out.println("Pierwszy bok (a)");
                a = input.nextDouble();
                System.out.println("Pierwszy bok (b)");
                b = input.nextDouble();
                System.out.println("Pierwszy bok (c)");
                c = input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                triangle(user);
            }

            double[] boki = {a, b, c};
            Arrays.sort(boki);

            if (a + b > c && a + c > b && b + c > a) {

                double p = (a + b + c) / 2;
                double Area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                double r = Area / p;
                double R = (a * b * c) / (4 * Area);

                double sin_alfa = boki[0] / (2 * R);
                double alfa = Math.asin(sin_alfa);
                double alfa_d = Math.toDegrees(alfa);
                double sin_beta = boki[1] / (2 * R);
                double beta = Math.asin(sin_beta);
                double beta_d = Math.toDegrees(beta);
                double gamma = 180 - (alfa_d + beta_d);

                System.out.printf("Obwod trojkata to %.2f %n", 2 * p);
                System.out.printf("Pole trojkata to %.2f %n", Area);
                System.out.printf("Promien okrego wpisanego %.2f %n", r);
                System.out.printf("Promien okrego opisanego %.2f %n %n", R);

                if ((a * a + b * b) == c * c) {

                    System.out.println("Ten trojkat jest prostokatny");
                } else if (alfa_d < 90 && beta_d < 90 && gamma < 90) {

                    if (a == b && b == c) {
                        System.out.println("Ten trojkat jest rownoboczny");
                    } else if (a == b || b == c || c == a) {
                        System.out.println("Ten trojkat jest rownoramienny i ostrokatny");
                    } else {
                        System.out.println("Ten trojkat jest ostrokatny");
                    }
                } else {

                    if (a == b || b == c || c == a) {
                        System.out.println("ten trojkat jest rownoramienny i rozwartokatny");
                    } else {
                        System.out.println("ten trojkat jest rozwartokatny");
                    }
                }

                System.out.printf("Miary katow tego trojkata to %.2f , %.2f , %.2f %n %n", alfa_d, beta_d, gamma);

                System.out.println("Obliczanie zakonczone co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych funkcji");

                int choice = 0;

                while (choice != 1) {

                    choice = input.nextInt();

                    switch (choice) {

                        case 1 -> System.out.println("Okej\n");

                        case 2 -> math_func(user);

                        default -> System.out.println("Niepoprawny wybor \n");

                    }
                }
            } else {
                System.out.println("taki trojkat nie moze istniec ,sprobuj ponownie\n");
            }
        }
    }

    public static void quadratic(String user) {

        System.out.println("                       _             _    _");
        System.out.println("  __ _  _  _  __ _  __| | _ _  __ _ | |_ (_) __ ");
        System.out.println(" / _` || || |/ _` |/ _` || '_|/ _` ||  _|| |/ _|");
        System.out.println(" \\__, | \\_,_|\\__,_|\\__,_||_|  \\__,_| \\__||_|\\__|");
        System.out.println("    |_|");
        System.out.println("\nWitaj w kalkulatorze rownan kwadratowych");

        System.out.println("ax^2 + bx + c = 0\n");

        Scanner input = new Scanner(System.in);

        while (true) {

            double a = 0;
            double b = 0;
            double c = 0;
            double x1;
            double x2;

            try {
                System.out.println("Wspolczynnik przy wyrazie kwadratowym (a)");
                a = input.nextDouble();
                System.out.println("Wspolczynnik przy wyrazie linowym (b)");
                b = input.nextDouble();
                System.out.println("Wyraz wolny (c)");
                c = input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                quadratic(user);
            }

            if (a == 0 && b == 0) {

                if (c == 0) {
                    System.out.println("To rownanie liniowe, które ma nieskonczenie wiele rozwiazań");
                } else {
                    System.out.println("To rownanie liniowe, ktore nie ma rozwiązań");
                }

            } else if (a == 0) {

                x1 = -c / b;
                System.out.println("To rownanie liniowe, ktore ma jedno rozwiazanie " + x1);
            } else {

                double delta = (b * b) - (4 * a * c);

                if (delta < 0) {
                    System.out.println("Rownanie nie ma rozwiazań");
                } else {
                    x1 = (-b - Math.sqrt(delta)) / (2 * a);
                    x2 = (-b + Math.sqrt(delta)) / (2 * a);

                    if (x1 == x2) {
                        System.out.println("To rownanie kwadratowe ma jedno rozwiazanie " + x1);
                    } else {
                        System.out.printf("To rownanie kwadratowe ma dwa rozwiazania %.2f , oraz %.2f ", x1, x2);
                    }
                }
            }

            System.out.println("\nObliczanie zakonczone co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych funkcji");

            int choice = 0;

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> math_func(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    public static void ciongi(String user) {


        System.out.println("  ___ ___  __ _  _  _  ___  _ _   __  ___  ___");
        System.out.println(" (_-</ -_)/ _` || || |/ -_)| ' \\ / _|/ -_)(_-<");
        System.out.println(" /__/\\___|\\__, | \\_,_|\\___||_||_|\\__|\\___|/__/");
        System.out.println("             |_|\n");
        System.out.println("Witaj w kalkulatorze ciagow\n");

        Scanner input = new Scanner(System.in);

        while (true) {

            int choice = 0;

            while (choice == 0) {

                System.out.println("Jaki ciag chcialbys policzyc?\n1. Ciag arytmetyczny\n2. Ciag geometryczny\n3. Ciag fibbonaciego\n4. Wroc do pozostalych funkcji");

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> arytmethic(user);

                    case 2 -> geometric(user);

                    case 3 -> fibbonaci(user);

                    case 4 -> math_func(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    private static void fibbonaci(String user) {

        System.out.println("   __  _  _     _                              _");
        System.out.println("  / _|(_)| |__ | |__  ___  _ _   __ _  __  __ (_)");
        System.out.println(" |  _|| || '_ \\| '_ \\/ _ \\| ' \\ / _` |/ _|/ _|| |");
        System.out.println(" |_|  |_||_.__/|_.__/\\___/|_||_|\\__,_|\\__|\\__||_|");

        System.out.println("\nKalkulator ciagow fibbonaciego\n");

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Ile wyrazow potrzebujesz?");

            int a = input.nextInt();

            int i = 0;
            int old = 0;
            int last = 1;
            int suma = 0;
            int fib_suma = 0;

            ArrayList<Integer> fib_wyr = new ArrayList<>();

            while (i != a) {

                fib_wyr.add(suma);

                suma = last + old;
                old = last;
                last = suma;

                fib_suma += suma;

                i++;
            }


            System.out.println("Pierwsze " + a + " wyrazow ciagu to:");
            System.out.println(fib_wyr);
            System.out.println("Suma tych wyrazow to " + fib_suma);

            System.out.println("\nObliczanie zakonczone co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych ciagow");

            int choice = 0;

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> ciongi(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    public static void arytmethic(String user) {

        System.out.println("             _  _    _                 _    _");
        System.out.println("  __ _  _ _ (_)| |_ | |_   _ __   ___ | |_ (_) __");
        System.out.println(" / _` || '_|| ||  _|| ' \\ | '  \\ / -_)|  _|| |/ _|");
        System.out.println(" \\__,_||_|  |_| \\__||_||_||_|_|_|\\___| \\__||_|\\__|");

        System.out.println("\nKalkulator ciagow arytmetycznych\n");

        Scanner input = new Scanner(System.in);

        ArrayList<Double> Aryt_wyr = new ArrayList<>();
        double Aryt_suma = 0;
        int n = 0;
        double a = 0;
        double r = 0;
        int i = 0;

        while (true) {

            try {
                System.out.println("Podaj pierwszy wyraz ciagu");
                a = input.nextDouble();
                System.out.println("Podaj roznice ciagu");
                r = input.nextDouble();
                System.out.println("Ile wyrazow potrzebujesz?");
                n = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                arytmethic(user);
            }


            while (i != n) {

                double b = a + i * r;

                Aryt_wyr.add(b);

                Aryt_suma += b;

                i++;

            }


            System.out.println("Pierwsze " + n + " wyrazow ciagu to:");
            System.out.println(Aryt_wyr);
            System.out.printf("Suma tych wyrazow to %.2f %n", Aryt_suma);

            System.out.println("\nObliczanie zakonczone, co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych ciagow");

            int choice = 0;

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> ciongi(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    public static void geometric(String user) {

        System.out.println("                              _         _");
        System.out.println("  __ _  ___  ___  _ __   ___ | |_  _ _ (_) __");
        System.out.println(" / _` |/ -_)/ _ \\| '  \\ / -_)|  _|| '_|| |/ _|");
        System.out.println(" \\__, |\\___|\\___/|_|_|_|\\___| \\__||_|  |_|\\__|");
        System.out.println(" |___/");

        System.out.println("\nKalkulator ciagow geometrycznych\n");

        Scanner input = new Scanner(System.in);

        while (true) {

            ArrayList<Double> Geo_wyr = new ArrayList<>();
            double Geo_sum = 0;
            int n = 0;
            double a = 0;
            double q = 0;
            int i = 2;

            try {
                System.out.println("Podaj pierwszy wyraz ciagu");
                a = input.nextDouble();
                System.out.println("Podaj iloraz ciagu");
                q = input.nextDouble();
                System.out.println("Ile wyrazow potrzebujesz?");
                n = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                geometric(user);
            }

            Geo_wyr.add(a);

            double b = a * q;

            Geo_wyr.add(b);

            Geo_sum += a;

            Geo_sum += b;

            while (i != n) {

                b *= q;

                Geo_wyr.add(b);

                Geo_sum += b;

                i++;

            }


            System.out.println("Pierwsze " + n + " wyrazow ciagu to:");
            System.out.println(Geo_wyr);
            System.out.printf("Suma tych wyrazow to %.2f %n", Geo_sum);

            System.out.println("\nObliczanie zakonczone, co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych ciagow");

            int choice = 0;

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> ciongi(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    public static void trygo_brygo(String user) {


        System.out.println("  _                                                 _");
        System.out.println(" | |_  _ _  _  _  __ _  ___  _ _   ___  _ __   ___ | |_  _ _  _  _");
        System.out.println(" |  _|| '_|| || |/ _` |/ _ \\| ' \\ / _ \\| '  \\ / -_)|  _|| '_|| || |");
        System.out.println("  \\__||_|   \\_, |\\__, |\\___/|_||_|\\___/|_|_|_|\\___| \\__||_|   \\_, |");
        System.out.println("            |__/ |___/                                        |__/\n");
        System.out.println("Witaj w kalkulatorze wartosci funkcji trygonometrycznych\n");

        Scanner input = new Scanner(System.in);

        while (true) {

            int choice = 0;

            while (choice == 0) {

                System.out.println("Jaki funkcje trygonometryczna chcialbys policzyc?\n1. Sinus\n2. Cosinus\n3. Tangens\n4. Cotangens \n5. Wroc do pozostalych funkcji");

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> sin_calc(user);

                    case 2 -> cos_calc(user);

                    case 3 -> tg_calc(user);

                    case 4 -> ctg_calc(user);

                    case 5 -> math_func(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    private static void ctg_calc(String user) {
        Scanner input = new Scanner(System.in);

        System.out.println("           _");
        System.out.println("  __  ___ | |_  __ _  _ _   __ _  ___  _ _   ___");
        System.out.println(" / _|/ _ \\|  _|/ _` || ' \\ / _` |/ -_)| ' \\ (_-<");
        System.out.println(" \\__|\\___/ \\__|\\__,_||_||_|\\__, |\\___||_||_|/__/");
        System.out.println("                           |___/");
        System.out.println("Witaj w kalkulatorze wartosci funkcji cotangens\n");

        while (true) {

            int a = 0;
            double degree = 0;

            try {

                System.out.println("W jakim formacie podajesz kat?\n1. Stopnie\n2. Radiany");

                int method = input.nextInt();

                switch (method) {

                    case 1 -> a = 1;

                    case 2 -> a = 2;

                    default -> System.out.println("Niepoprawny wybor \n");

                }

                if (a != 0) {
                    System.out.println("Podaj wartosc swojego kata");
                    degree = input.nextDouble();
                }

            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                ctg_calc(user);
            }

            double exist_degree = 1;
            double exist_rad = 1;


            if (a == 1) {
                exist_degree = degree % 180;
                degree *= 0.0174532925;
            }

            if (a == 2) {
                exist_rad = degree % 3.14;
            }

            if (exist_rad != 0 && exist_degree != 0) {

                double sin_alfa = 1 / Math.tan(degree);

                System.out.printf("Cotangens kata %.2f rad to %.2f %n", degree, sin_alfa);

            } else {
                System.out.printf("funkcja cotangens nie istnieje dla kata %.2f %n", degree);
            }

            int choice = 0;

            System.out.println("\nObliczanie zakonczone, co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych funkcji trygometrycznych");

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> trygo_brygo(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }

    }

    private static void tg_calc(String user) {

        Scanner input = new Scanner(System.in);

        System.out.println("  _");
        System.out.println(" | |_  __ _  _ _   __ _  ___  _ _   ___");
        System.out.println(" |  _|/ _` || ' \\ / _` |/ -_)| ' \\ (_-<");
        System.out.println("  \\__|\\__,_||_||_|\\__, |\\___||_||_|/__/");
        System.out.println("                  |___/");
        System.out.println("Witaj w kalkulatorze wartosci funkcji tangens\n");

        while (true) {

            int a = 0;
            double degree = 0;

            try {

                System.out.println("W jakim formacie podajesz kat?\n1. Stopnie\n2. Radiany");

                int method = input.nextInt();

                switch (method) {

                    case 1 -> a = 1;

                    case 2 -> a = 2;

                    default -> System.out.println("Niepoprawny wybor \n");

                }

                if (a != 0) {
                    System.out.println("Podaj wartosc swojego kata");
                    degree = input.nextDouble();
                }

            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                tg_calc(user);
            }

            double exist_degree = 1;
            double exist_rad = 1;


            if (a == 1) {
                exist_degree = (degree + 90) % 180;
                degree *= 0.0174532925;
            }
            if (a == 2) {
                exist_rad = degree + 1.57 % 3.14;
            }

            if (exist_rad != 0 && exist_degree != 0) {

                double sin_alfa = Math.tan(degree);

                System.out.printf("Tangens kata %.2f rad to %.2f %n", degree, sin_alfa);

            } else {
                System.out.printf("funkcja tangens nie istnieje dla kata %.2f %n", degree);
            }

            int choice = 0;

            System.out.println("\nObliczanie zakonczone, co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych funkcji trygometrycznych");

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> trygo_brygo(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    private static void cos_calc(String user) {

        Scanner input = new Scanner(System.in);

        System.out.println("               _");
        System.out.println("  __  ___  ___(_) _ _  _  _  ___");
        System.out.println(" / _|/ _ \\(_-<| || ' \\| || |(_-<");
        System.out.println(" \\__|\\___//__/|_||_||_|\\_,_|/__/");
        System.out.println("Witaj w kalkulatorze wartosci funkcji cosiunus\n");

        while (true) {

            int a = 0;
            double degree = 0;

            try {

                System.out.println("W jakim formacie podajesz kat?\n1. Stopnie\n2. Radiany");

                int method = input.nextInt();

                switch (method) {

                    case 1 -> a = 1;

                    case 2 -> a = 2;

                    default -> System.out.println("Niepoprawny wybor \n");

                }

                if (a != 0) {
                    System.out.println("Podaj wartosc swojego kata");
                    degree = input.nextDouble();
                }

            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                cos_calc(user);
            }


            if (a == 1) {

                degree *= 0.0174532925;
            }

            double sin_alfa = Math.cos(degree);

            System.out.printf("Cosinus kata %.2f rad to %.2f %n", degree, sin_alfa);

            int choice = 0;

            System.out.println("\nObliczanie zakonczone, co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych funkcji trygometrycznych");

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> trygo_brygo(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    private static void sin_calc(String user) {

        Scanner input = new Scanner(System.in);

        System.out.println("      _");
        System.out.println("  ___(_) _ _  _  _  ___");
        System.out.println(" (_-<| || ' \\| || |(_-<");
        System.out.println(" /__/|_||_||_|\\_,_|/__/");
        System.out.println("Witaj w kalkulatorze wartosci funkcji sinus\n");

        while (true) {

            int a = 0;
            double degree = 0;

            try {

                System.out.println("W jakim formacie podajesz kat?\n1. Stopnie\n2. Radiany");

                int method = input.nextInt();

                switch (method) {

                    case 1 -> a = 1;

                    case 2 -> a = 2;

                    default -> System.out.println("Niepoprawny wybor \n");

                }

                if (a != 0) {
                    System.out.println("Podaj wartosc swojego kata");
                    degree = input.nextDouble();
                }

            } catch (InputMismatchException e) {
                System.out.println("Nieprawidlowy typ danych");
                sin_calc(user);
            }


            if (a == 1) {

                degree *= 0.0174532925;
            }

            double sin_alfa = Math.sin(degree);

            System.out.printf("Sinus kata %.2f rad to %.2f %n", degree, sin_alfa);

            int choice = 0;

            System.out.println("\nObliczanie zakonczone, co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych  funkcji trygometrycznych");

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> trygo_brygo(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }

    public static void numbers(String user) {

        System.out.println("         ___");
        System.out.println("        / / \\");
        System.out.println("       / /   \\");
        System.out.println("      / /     \\___________");
        System.out.println("     / /       \\        / \\");
        System.out.println("    /_/         \\      /  /");
        System.out.println(" ___\\ \\       ___\\____/_ /_");
        System.out.println("/____\\ \\     /___________/ \\");
        System.out.println("\\     \\ \\    \\           \\  \\");
        System.out.println(" \\     \\ \\    \\____       \\  \\");
        System.out.println("  \\     \\ \\   /   / \\      \\  \\");
        System.out.println("   \\   / \\_\\ /   /  /       \\  \\");
        System.out.println("    \\ /         /  /_________\\ /");
        System.out.println("     /         /  /      /");
        System.out.println("    /         /  /      /");
        System.out.println("   /_________/  / \\    /");
        System.out.println("   \\_________\\_/ \\ \\  /");
        System.out.println("                  \\_\\/");

        System.out.println("\nWitaj, podaj mi dowolna liczbe calkowita a ja zbadam kilka jej wlasnosci\n");

        Scanner input = new Scanner(System.in);

        while (true) {

            int c = 0;

            try {
                System.out.println("Podaj liczbe calkowita ");
                c = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wymagana liczba calkowita");
                numbers(user);
            }

            int a = Math.abs(c);

            int i = 1;

            ArrayList<Integer> a_div = new ArrayList<>();

            while (i - 1 != a) {

                if (a % i == 0) {
                    a_div.add(i);
                }
                i++;
            }

            int o = a_div.size();
            int b = a;

            ArrayList<Integer> a_roz = new ArrayList<>();
            int j = 1;

            while (Math.abs(b) != 1) {

                j++;

                while (true) {

                    if (b % j == 0) {

                        b /= j;
                        a_roz.add(j);

                    } else {
                        break;
                    }
                }
            }

            int k = a_roz.size();

            if (a == 0) {
                System.out.println("Liczba 0 nie wplywa na wynik sumy i roznicy, zeruje kazdy iloczyn, i nie mozna dzielic przez 0");
            }
            if(a==1){
                System.out.println("Liczba 1 nie wplywa na wynik iloczynu i ilorazu");
            }
            else if (o == 2) {
                System.out.printf("%nLiczba %d, jest liczba pierwsza, dzieli sie tylko przez 1 i przez siebie%n", c);
            }
            else {
                System.out.printf("%nLiczba %d jest zlozona, ma %d dzielnikow, dzielniki tej liczby to%n", c, o);
                System.out.println(a_div);
                System.out.printf("%nLiczbe %d, mozemy rozlozyc na %d czynnikow, rozklad tej liczby to%n", c, k);
                System.out.println(a_roz);

                int n = 0;

                if (c > 0) {
                    n = (int) Math.sqrt(a);
                }

                int m = (int) Math.cbrt(c);

                if (n * n == a) {
                    System.out.printf("%nLiczba %d jest kwadratem liczby %d%n", c, n);
                }
                if (m * m * m == c) {
                    System.out.printf("%nLiczba %d jest szescianem liczby %d%n", c, m);
                }
            }

            int choice = 0;

            System.out.println("\nObliczanie zakonczone, co teraz?\n1. Wykonaj jeszcze raz\n2. Wroc do pozostalych funkcji");

            while (choice != 1) {

                choice = input.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Okej\n");

                    case 2 -> math_func(user);

                    default -> System.out.println("Niepoprawny wybor \n");

                }
            }
        }
    }
}