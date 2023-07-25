
package it.network.hracikostkadalsi;

import java.util.Random;

/**
 *
 * @author Mefi100
 */
public class Kostka {

    private Random random;

    private int pocetSten;
    
    public Kostka() {
        this.pocetSten = 6;
        random = new Random();
    }

    /**
     * Vytvoří novou instanci hrací kostky
     *
     * @param pocetSten Počet stěn hrací kostky
     */
    public Kostka(int pocetSten) {
        this.pocetSten = pocetSten;
        random = new Random();
    }
  
    public int vratPocetSten() {
        return pocetSten;
    }
    
    public int hod() {
        return random.nextInt(pocetSten) + 1;
    }}