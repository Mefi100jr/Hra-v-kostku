package it.network.hracikostkadalsi;

import java.util.Scanner;

class Hra {
    private Kostka kostka;
    private Scanner in;

    public Hra() {
        this.kostka = new Kostka();
        this.in = new Scanner(System.in);
    }

    public void spustitHru() {
        System.out.println("Vítej ve hře v kostku. Chceš-li si se mnou zahrát, ");
        String pokracovat = "ano";
        while(pokracovat.equals("ano")){
            System.out.println("zadej počet opakování hry:");
            int pocetOpakovani = Integer.parseInt(in.nextLine());
            int vysledek = 0;

            for(int i = 0; i < pocetOpakovani; i++) {
                // dramatická pauza
                dramatickaPauza();

                // vypsání hodu
                int hodPC = kostka.hod();
                int tvujHod = kostka.hod();

                System.out.printf("Hodil jsi číslo %d\n", tvujHod);
                System.out.printf("Já jsem hodil číslo %d\n", hodPC);

                // dramatická pauza
                dramatickaPauza();

                // vyhodnocení jednotlivého hodu
                vysledek = vyhodnotHod(hodPC, tvujHod, vysledek);
            }

            // dramatická pauza
            dramatickaPauza();

            // celkové vyhodnocení hry
            vyhodnotHru(vysledek);

            // volba opakovaní hry
            System.out.println("Chcete pokračovat ve hře? [Ano/Ne]");
            pokracovat = in.nextLine().trim().toLowerCase();
        }
        System.out.println("-----------Konec----------");
        System.out.println("Děkuji za hru");
    }

    private void dramatickaPauza() {
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Chyba, nepodařilo se uspat vlákno!");
        }
    }

    private int vyhodnotHod(int hodPC, int tvujHod, int vysledek) {
        if(hodPC == tvujHod) {
            System.out.println("Remíza.");
        } else if(hodPC > tvujHod) {
            System.out.println("Prohra :( ");
            vysledek--;
        } else if (hodPC < tvujHod) {
            System.out.println("Výhra!");
            vysledek++;
        }
        return vysledek;
    }

    private void vyhodnotHru(int vysledek) {
        if(vysledek == 0) {
            System.out.println("Boj skončil nerozhodně");
        } else if(vysledek < 0) {
            System.out.println("Bohužel, tentokrát jsi prohrál hru   :( ");
        } else if(vysledek > 0) {
            System.out.println("!!!Celkově jsi vyhrál hru! Gratuluji ti!!!");
        }
    }
}