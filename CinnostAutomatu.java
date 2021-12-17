import java.util.HashMap;
import java.util.Scanner;

public class CinnostAutomatu {

    private int aktualnyStav;
    HashMap<Integer, HashMap<String, Integer[]>> stavyAutomatu;
    private int aktualnaFarba;


    public CinnostAutomatu() {
        aktualnyStav = 0;
        aktualnaFarba = 1;
        stavyAutomatu = new HashMap<>();
        stavyAutomatu.put(0, this.vytvorStavyPreS0());
        stavyAutomatu.put(1, this.vytvorStavyPreS1());
        stavyAutomatu.put(2, this.vytvorStavyPreS2());
        stavyAutomatu.put(3, this.vytvorStavyPreS3());
    }

    public HashMap vytvorStavyPreS0() {
        HashMap <String, Integer[]> stavyS0 = new HashMap<>();
        Integer[] zmenaStavu;

        zmenaStavu = new Integer[]{0, 1};
        stavyS0.put("0,0",  zmenaStavu);
        stavyS0.put("1,0", zmenaStavu);
        stavyS0.put("1,1", zmenaStavu);

        zmenaStavu = new Integer[]{1,1};
        stavyS0.put("0,1", zmenaStavu);

        return stavyS0;
    }

    public HashMap vytvorStavyPreS1() {
        HashMap<String, Integer[]> stavyS1 = new HashMap<>();
        Integer[] zmenaStavu;

        zmenaStavu = new Integer[]{1,1};
        stavyS1.put("0,1", zmenaStavu);
        stavyS1.put("0,0", zmenaStavu);

        zmenaStavu = new Integer[]{0,1};
        stavyS1.put("1,1", zmenaStavu);

        zmenaStavu = new Integer[]{2,0};
        stavyS1.put("1,0", zmenaStavu);

        return stavyS1;
    }

    public HashMap vytvorStavyPreS2() {
        HashMap<String, Integer[]> stavyS2 = new HashMap<>();
        Integer[] zmenaStavu;

        zmenaStavu = new Integer[]{2,0};
        stavyS2.put("1,0", zmenaStavu);
        stavyS2.put("1,1", zmenaStavu);

        zmenaStavu = new Integer[]{1,1};
        stavyS2.put("0,0", zmenaStavu);

        zmenaStavu = new Integer[]{3,0};
        stavyS2.put("0,1", zmenaStavu);

        return stavyS2;
    }

    public HashMap vytvorStavyPreS3() {
        HashMap<String, Integer[]> stavyS3 = new HashMap<>();
        Integer[] zmenaStavu;

        zmenaStavu = new Integer[]{3,0};
        stavyS3.put("0,0", zmenaStavu);
        stavyS3.put("0,1", zmenaStavu);

        zmenaStavu = new Integer[]{2,0};
        stavyS3.put("1,1", zmenaStavu);

        return stavyS3;
    }

    public void spustiEmulaciuCinnostiAutomatu() {
        Scanner skener = new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Emulacia cinnosti automatu");
        System.out.println("******************************");
        System.out.println();

        System.out.println("Zadaj vstup v tvare 'x,y', kde x a y su hodnoty vstupov A a B.");
        System.out.println("Pre ukoncenie emulacie zadaj '0'");
        System.out.println();
        this.vypis();

        String vstup;

        while (!(vstup = skener.nextLine()).equals("0")) {
            HashMap<String, Integer[]> aktualneStavy = this.stavyAutomatu.get(this.aktualnyStav);

            Integer[] zmenaStavu = null;
            zmenaStavu = aktualneStavy.get(vstup);

            if (zmenaStavu == null) {
                System.out.println("Zadany nespravny vstup!");
            } else {
                this.aktualnyStav = zmenaStavu[0];
                this.aktualnaFarba = zmenaStavu[1];
                this.vypis();
            }
        }

    }

    public void vypis() {
        System.out.println("Aktualny stav automatu: S"+ this.aktualnyStav);
        System.out.print("Aktualna farba semaforu: ");

        if (this.aktualnaFarba == 0) {
            System.out.println("cervena");
        } else {
            System.out.println("zelena");
        }
        System.out.println();
        System.out.println("Vstup: ");

    }

}
