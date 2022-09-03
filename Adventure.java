import java.util.Scanner;
import java.util.Random;

public class Adventure {
    public static void main(String[] args) {
        
        //System objects
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        //Game Variables
        String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assasin" };
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player Variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPots = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        //contains game
        GAME:
        while(running) {
            System.out.println("----------------------------------------");
            
            //enables RNGsus
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("");
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while(enemyHealth > 0){
                System.out.println("\tYour HP:" + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run");
                
                String input = keyboard.nextLine();

                //Attack
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation.");
                    
                    //DED XD
                    if(health<1) {
                        System.out.println("\t> YOU DIED");
                        break;
                    }

                    //KILLEMDED
                    if(enemyHealth<1) {
                        System.out.println("\t> You have defeated " + enemy + ".");
                        
                    }

                }

                //Health Potions
                else if(input.equals("2")) {
                    
                    if(numHealthPots >= 1) {

                        if(health < 100) {
                        health += healthPotionHealAmount;
                        numHealthPots --;

                        //Health doesn't go above 100
                        if(health > 100) {
                            health = 100;
                        }
                        else {
                            //do nothing
                        }
                        System.out.println("\t> You take a health potion, healing " + healthPotionHealAmount + " points." 
                                        + "\n\t> You now have " + health + " HP."
                                        + "\n\t> You have " + numHealthPots + " potions left. \n");
                        }

                        //Too much HP
                        else {
                            System.out.println("You are already at 100 HP. You don't need a potion.");
                        }
                    }
                    else{
                        System.out.println("\t> You have no health potions! Defeat enemies to get more");
                    }
                    
                }
                
                //Run away
                else if(input.equals("3")){
                    System.out.println("You run away from the " + enemy + ".");
                    continue GAME;
                }
                else {
                    System.out.println("\tInvalid Command");
                }
            
            }
            
            if(health < 1) {
                System.out.println("----------------------------------------");
                System.out.println("\tYour body rots inside the dungeon, your name lost to the sands of time.");
                break;
            }

            System.out.println("----------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. # ");
            
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPots++;
                System.out.println(" # The " + enemy + "has dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPots + " health potion(s) left # ");
            }

            System.out.println("----------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("\t1. Fight again!");
            System.out.println("\t2. Exit Dungeon");

            String input = keyboard.nextLine();

            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command!");
                input = keyboard.nextLine();
            }

            if(input.equals("1")) {
                System.out.println("You fight again!");

            }

            else if(input.equals("2")) {
                System.out.println("----------------------------------------");
                System.out.println("You take a step back out into the sun again. Leaving the dungeon for another day.");
                break;
            }
        }

        System.out.println("Thanks for playing my game!");
        System.out.println("----------------------------------------");

    }
}
