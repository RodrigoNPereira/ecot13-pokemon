package br.edu.unifei.ecot13;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
    	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemonPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
    	
        Type electric = new Type("electric");
        Type fairy = new Type("fairy");

        Spark spark = new Spark();
        Thunder thunder = new Thunder();
        ThunderWave thunderWave = new ThunderWave();
        FleurCannon fleurCannon = new FleurCannon();
        IronTail ironTail = new IronTail();
        FirePunch firePunch = new FirePunch();

        HeldItem thunderstone = new HeldItem("Thunderstone", 1000, "Evolves Pichu");
        HeldItem alolanThunderstone = new HeldItem("Alolan Thunderstone", 15000, "Evolves Pikachu");

        Fainted fainted = new Fainted();
        Burn burn = new Burn();
        Paralyzed paralyzed = new Paralyzed();

        EggPichu pokemon1 = new EggPichu("Jazz");
        pokemon1.setType1(null);
        pokemon1.setType2(null);

        Pichu pokemon1evolved = pokemon1.callEvolution();
        pokemon1evolved.setType1(electric);
        pokemon1evolved.setType2(null);
        pokemon1evolved.setItem(thunderstone);

        Pikachu pokemon1evolved2 = pokemon1evolved.callEvolution();
        pokemon1evolved2.setType1(electric);
        pokemon1evolved2.setType2(null);
        pokemon1evolved2.setItem(alolanThunderstone);

//        AlolanRaichu pokemon1evolved3 = pokemon1evolved2.callEvolution();
//        pokemon1evolved3.setType1(electric);
//        pokemon1evolved3.setType2(fairy);
//        pokemon1evolved3.setHealth(324);
//        pokemon1evolved3.setDefense(218);

        AlolanRaichu pokemon2 = new AlolanRaichu("Ivy");
        pokemon2.setHealth(324);
        pokemon2.setDefense(218);
        
//        pokemon1evolved3.setAttacks(new Attack[]{firePunch, spark, fleurCannon, null});
        pokemon2.setAttacks(new Attack[]{thunder, ironTail, thunderWave, fleurCannon});

//        System.out.println("Let the battle begin!");
//         Combat
//        while (true){
//            int attackP1 = firePunch.attack(pokemon2.getHealth(), pokemon2.getDefense());
//            pokemon2.setHealth(attackP1);
//            pokemon2.setStatus(burn);
//            int attackP2 = spark.attack(pokemon1evolved3.getHealth(), pokemon1evolved2.getDefense());
//            pokemon1evolved3.setHealth(attackP2);
//            pokemon1evolved3.setStatus(paralyzed);
//            // System.out.println(attackP1 + " " + attackP2);
//            System.out.println("Pokemon 1 health: "+pokemon1evolved3.getHealth()+" // Pokemon 2 health: "+pokemon2.getHealth());
//            if(pokemon2.getHealth() <= 0 || pokemon1evolved3.getHealth() <= 0){
//                if(pokemon1evolved3.getHealth() > pokemon2.getHealth()){
//                    System.out.println("The Pokemon 1 is fainted!");
//                    pokemon2.setStatus(fainted);
//                    break;
//                } else if(pokemon1evolved3.getHealth() < pokemon2.getHealth()){
//                    System.out.println("The Pokemon 2 is fainted!");
//                    pokemon1evolved2.setStatus(fainted);
//                    break;
//                }
//                } 
//        }
//        System.out.println("The battle is over!");
        
        Pokeball greatBall = new Pokeball("greatBall", 40, null);
        greatBall.capturePokemon(pokemon2); 
        
        
        em.persist(electric);
        em.persist(fairy);
        em.persist(spark);
        em.persist(thunder);
        em.persist(thunderWave);
        em.persist(fleurCannon);
        em.persist(ironTail);
        em.persist(firePunch);
        em.persist(thunderstone);
        em.persist(alolanThunderstone);
        em.persist(fainted);
        em.persist(burn);
        em.persist(paralyzed);
        em.persist(pokemon1);
        em.persist(pokemon1evolved);
        em.persist(pokemon1evolved2);
//        em.persist(pokemon1evolved3);
        em.persist(pokemon2);
        em.persist(greatBall);
        
        
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
