package be.kdg.judokas.model;

import java.util.*;

/**
 * MULTIKLASSE
 * STUDENT: Joris Gulinck
 * klasgroep: INFB001B
 */

public class JudokasSet implements Judokas {
    private Set<Judoka> set;

    public JudokasSet() {
        this.set = new TreeSet<>();
    }

    @Override
    public boolean voegToe(Judoka judoka){
        return this.set.add(judoka);
    }

    @Override
    public boolean verwijder(Judoka judoka){
        return  this.set.remove(judoka);
    }

    @Override
    public List<Judoka> gesorteerdOpNaam(){
        return new ArrayList<>(this.set);
    }

    @Override
    public List<Judoka> gesorteerdOpGeboorte(){
        List<Judoka> nieuweLijst = new ArrayList<>(this.set);
        Collections.sort(nieuweLijst, new Comparator<Judoka>() {
            @Override
            public int compare(Judoka o1, Judoka o2) {
                if (o1.getGeboorte().getYear() - o2.getGeboorte().getYear() == 0){
                    return o1.getGeboorte().getMonthValue() - o2.getGeboorte().getMonthValue();
                } else {
                    return o1.getGeboorte().getYear() - o2.getGeboorte().getYear();
                }
            }
        });
        return nieuweLijst;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Judoka judoka: set){
            stringBuilder.append(judoka.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
