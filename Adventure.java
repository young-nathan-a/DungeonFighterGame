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
        int goldCoins = 10;
        int goldCoinDropRate = 50; //percentage

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
                System.out.println("\tYour gold coins: " + goldCoins);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run");
                System.out.println("\t4. Return to town");
                
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

                else if(input.equals("4")){
                    System.out.println("\n\tYou have successfully escaped the dungeon.");
                    System.out.println("\tWhat do you want to do?");
                    System.out.println("\t1. Go to the shop");
                    System.out.println("\t2. Go to the tavern");
                    System.out.println("\t3. Go back to the dungeon");
                    //set up separate input for town
                    String input2 = keyboard.nextLine();
                    
                    //Shop
                    if(input2.equals("1")){
                        System.out.println("\n\tThe shopkeeper eyes you suspiciousy");
                        
                        //toss a coin to your witcher?
                        if(goldCoins < 10){
                            System.out.println("\tYou look into your coinbag to see how much you have.");
                            System.out.println("\tA moth flies out...");
                            System.out.println("\tYou say \"Well...Guess I'll be seeing you\"\n");
                        }
                        //ur LOADED
                        if(goldCoins >= 10){
                            System.out.println("\t\"What do you want? Everything is 10 gold coins.\"");
                            System.out.println("\t1. A better sword");
                            System.out.println("\t2. A health potion");
                            System.out.println("\t3. Better Armor");

                            String shopInput = keyboard.nextLine();
                            //better sword
                            if(shopInput.equals("1")){
                                goldCoins -= 10;
                                attackDamage += 10;
                                System.out.println("\n\tYour new sword feels sharper");
                                System.out.println("\tYou return to the dungeon ready for what awaits\n");
                            }
                            //health potion
                            if(shopInput.equals("2")){
                                ++numHealthPots;
                                goldCoins -= 10;
                                System.out.println("\tDo you want to buy more health potions?");
                                System.out.println("\t1. Yes");
                                System.out.println("\t2. No");
                                if(goldCoins > 10){
                                    String potionInput = keyboard.nextLine();
                                    if(potionInput.equals("1")){
                                        ++numHealthPots;
                                        goldCoins -= 10;
                                    }

                                    else if(potionInput.equals("2")){
                                        System.out.println("\tYou return to the dungeon\n");
                                    }
                                }
                            }
                            //better armor
                            if(shopInput.equals("3")){
                                enemyAttackDamage -= 5;
                                goldCoins -= 10;
                                System.out.println("\tYou don the heavier armor, feeling more protected");
                                System.out.println("\tYou return to the dungeon");
                            }
                        }
                    }

                    //Tavern
                    if(input2.equals("2")){
                        System.out.println("\tYou walk into the tavern and order a drink");
                        if(goldCoins >= 5){
                            goldCoins-=5;
                            System.out.println("\tYou down your drink and pass out\n");                            
                        }

                        if(goldCoins < 5){
                            System.out.println("\tThe barkeep laughs at you and turns you away");
                            System.out.println("\tYou can't order a drink if you don't have any gold!");
                            System.out.println("\tYou return to the dungeon to make more coin\n");
                            
                        }
                    }
                    if(input2.equals("3")){
                        System.out.println("\tYou return to the dungeon");
                    }
                }
                else {
                    System.out.println("\tInvalid Command");
                }
            
            }
            
            if(health < 1) {
                System.out.println("----------------------------------------");
                System.out.println("Your body rots inside the dungeon, your name lost to the sands of time.");
                break;
            }

            System.out.println("----------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. # ");
            
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPots++;
                System.out.println(" # The " + enemy + " has dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPots + " health potion(s) left # ");
            }

            if(rand.nextInt(100) < goldCoinDropRate){
                goldCoins += 3;

                System.out.println(" # You now have " + goldCoins + " gold coins. # ");
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
                System.out.println("You earned " + goldCoins + " gold coins.");
                break;
            }
        }

        System.out.println("Thanks for playing my game!");
        System.out.println("----------------------------------------");

    }
}
