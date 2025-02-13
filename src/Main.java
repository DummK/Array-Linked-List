import java.util.*;

class Films {
    String title;
    int year;

    public Films(String title, int year) {
        this.title = title;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("-----Część 1 i 3-----");
        ArrayList<Integer> list = new ArrayList<>();
        Random generator = new Random();

        for (int i = 0; i < generator.nextInt(101); i++) {
            list.add(generator.nextInt(21) + 10);
        }

        int suma = 0, min = Collections.min(list), max = Collections.max(list);

        if(list.size() > 3) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == min) {
                    list.remove(i);
                }
                else if(list.get(i) == max) {
                    list.remove(i);
                }
            }

            for(int temperature : list) {
                suma += temperature;
            }

            double avg = (double) (suma / list.size());


            System.out.println("Średnia: " + avg);
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            System.out.println("Większe od średniej: ");
            int j = 1;
            for (Integer integer : list) {
                if (integer > avg) {
                    System.out.println((j) + ". " + integer);
                    j++;
                }
            }
            System.out.println("Mniejsze od średniej: ");
            j = 1;
            for (Integer integer : list) {
                if (integer < avg) {
                    System.out.println((j) + ". " + integer);
                    j++;
                }
            }

        }
        else {

            System.out.println("nie można usunąć skrajnych wartości z listy krótszej niż 3 elementy");

        }
        System.out.println("---------------------");

        System.out.println();

        System.out.println("-----Część 2 i 4-----");
        LinkedList<Films> list2 = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
            list2.add(new Films("Inception", 2010));
            list2.add(new Films("Matrix", 1999));
            list2.add(new Films("Avatar", 2009));
            list2.add(new Films("Interstellar", 2014));
            list2.add(new Films("Up", 2009));
            list2.add(new Films("Star Wars", 1977));
            list2.add(new Films("The Godfather", 1972));
            list2.add(new Films("The Dark Knight", 2008));
            list2.add(new Films("Pulp Fiction", 1994));
            list2.add(new Films("Forrest Gump", 1994));
            list2.add(new Films("The Shawshank Redemption", 1994));
            list2.add(new Films("Gladiator", 2000));

            int num = 1;
            for(Films film : list2) {
                System.out.println(num + ". " + film.title + " " + film.year);
                num++;
            }
        System.out.println("-----DODAWANIE-----");
            System.out.println("Ile filmów chcesz jeszcze dodać: ");
            int quantity = scan.nextInt();
            if(quantity > 0) {
                for(int i = 0; i < quantity; i++) {
                    System.out.println("Podaj tytuł i rok filmu: ");
                    list2.add(new Films(scan.next(), scan.nextInt()));
                    if(list2.getLast().year < 1900 || list2.getLast().year > 2025) {
                        list2.remove(list2.getLast());
                        System.out.println("Niepoprawny rok, film nie został dodany");
                    }
                    else {
                        System.out.println("Poprawnie dodano film");
                    }
                }
            }
            else {
                System.out.println("Niepoprawna liczba lub 0");
            }

            System.out.println("\nAktualna lista filmów: ");
            num = 1;
            for(Films film : list2) {
                System.out.println(num + ". " + film.title + " " + film.year);
                num++;
            }

        System.out.println("-------------------");

            System.out.println();

        System.out.println("-----FILTROWANIE-----");
            for(Films film : list2) {
                if(film.year >= 2000 && film.title.length() > 5) {
                    System.out.println(film.title);
                }
            }
        System.out.println("---------------------");

            System.out.println();

        System.out.println("-----WYSZUKIWANIE-----");
            System.out.println("Czy chcesz wyszukać film(tak/nie): ");
            String answer = scan.next().toLowerCase();

            if(answer.equals("tak")) {
                System.out.println("Wprowadź fraze: ");
                String phrase = scan.next();
                int count = 1;
                for(Films film : list2) {
                    if(film.title.toLowerCase().contains(phrase.toLowerCase())) {
                        System.out.println(count + ". " + film.title);
                        count++;
                    }
                }
            }
            else if(!answer.equals("nie")){
                System.out.println("Błąd");
            }
        System.out.println("----------------------");

            System.out.println();

        System.out.println("------SORTOWANIE------");

            list2.sort(Comparator.comparing(o -> o.year));
            list2.sort(Comparator.comparing(o -> o.title));
            for(int j = 0; j < list2.size(); j++) {
                System.out.println((j+1) + ". " + list2.get(j).title);
            }
        System.out.println("----------------------");

            System.out.println();

        System.out.println("------EDYTOWANIE------");
            while(true) {
                System.out.println("Podaj numer z listy wyżej: ");
                int num2 = scan.nextInt();
                    if (num2 > 0 && num2 <= list2.size()) {
                        System.out.println("Czy chcesz edytować tytul czy rok(t/r): ");
                        char ans2 = scan.next().toLowerCase().charAt(0);
                            if (ans2 == 't') {
                                System.out.println("Podaj tytuł: ");
                                list2.get(num2 - 1).title = scan.next();
                                break;
                            } else if (ans2 == 'r') {
                                System.out.println("Podaj rok: ");
                                list2.get(num2 - 1).year = scan.nextInt();
                                break;
                            }
                            else {
                                System.out.println("Błąd, wpisz t lub r");
                            }
                    }
                    else {
                        System.out.println("Błąd, wpisz liczbę z przedziału");
                    }
            }
                for(Films film : list2) {
                    System.out.println(film.title + " " + film.year);
                }

        System.out.println("----------------------");

        System.out.println("---------------------");
    }
}