

package gameproject;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Chantz
 */
public class GameProject {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        // TODO code application logic here
        
   //Main objects
      Scanner s = new Scanner(System.in);
      Random rand = new Random();
   
   //String for enemies
      String[] enemies = {"Zombie", "Skeleton", "Pig", "Dragon", "Warlock", "Warrior", "Deer" };      //add different 'types' of enemies and give crit roll
      int maxEnemyHealth = 75;
      int enemyAttackDamage = 25; 
   
   //player variables
      int playerHealth = 100;    //add validation t      //add different 'types' of enemies and give crit roll
   //int maxEnemyHealth = 75;
   //int enemyAttackDamage = 25; 
   
   //player variableso the health cap
      int playerAttackDamage = 50; //add leveling system
      int numHealthPot = 5;     //add different size potions
      int healthPotHeal = 100;  
      int healthPotDrop = 25;
   
   //run conditions
   
      boolean running = true;
   
   
      System.out.println("Welcome to the game");
   
      Game: //add this frame to mark the loop so it can later be referenced
      while(running){
         int enemyHealth = rand.nextInt(maxEnemyHealth);  //add diffent hp's
         String enemy = enemies[rand.nextInt(enemies.length)];
         System.out.println("--------------------------------------------------------");
         System.out.println("  Enemy: " + enemy + "\n Health:   " + enemyHealth);
      
         while(enemyHealth > 0) {
            System.out.println("\tPlayer Health: " + playerHealth);
            System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
            System.out.println("\nWhat would you like to do?");
            System.out.println("\t Melee Attack: 1"); //1
            System.out.println("\t Use Spell: 2"); //2
            System.out.println("\t Use Potion: 3"); //3
            System.out.println("\t Run: 4"); //4
         
            String input = s.nextLine();
         
         //Start of Game Loop
            if(input.equals("1")) { //basic melee attack
               int damDealt = rand.nextInt(playerAttackDamage);
               int damTaken = rand.nextInt(enemyAttackDamage);
               
               enemyHealth -= damDealt; //uses -= to subtract damage from enemy health
               playerHealth -= damTaken;  //uses -= subtract damage taken from player health
               
               System.out.println("\t> You strike the " + enemy + " for " + damDealt + "damage");
               System.out.println("\t> You receive " + damTaken + " damage from " + enemy);
                  
               if(playerHealth < 1) {
                  System.out.println("You have taken to much damage");
                     
                  break;
                     
               }  
            }
            
            else if(input.equals("2")) {  //basic magic system
               int maxMagicDamage = 100;
               int magicDamDealt = rand.nextInt(maxMagicDamage);
               
               int damTaken = rand.nextInt(enemyAttackDamage);
               
               //int damDealt = rand.nextInt(attackDamage);
            
               enemyHealth -= magicDamDealt; 
               playerHealth -= damTaken;  
               
               //use logical or || to validate health
               
               System.out.println("\t> You cast a spell on " + enemy + " for " + magicDamDealt + " magic damage");
               System.out.println("\t> You receive " + damTaken + " damage from " + enemy);
                  
               if(playerHealth < 1) {
                  System.out.println("The gods were not with you.");
                     
                  break;
                     
                     
               }
            
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
            else if(input.equals("3")) {  //health potion implementation..............USE LOGICAL OR TO IMPLEMENT VALIDATION
            
               if(numHealthPot > 0) {
               
                  playerHealth += healthPotHeal;
                  numHealthPot--;
                  System.out.println("\t> You have been healed for " + healthPotHeal + "Health" + 
                                       "\n\t> You now have " + playerHealth + "Health" + 
                                       "\n\t> You have " + numHealthPot + "Health Potions Remaining" );
               
               }
                        
               else {
                        
                  System.out.println("You have no health potions remaining");
               }
                        
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////       
               
            
            }
            
            else if (input.equals("4")) {
            
            
            //generate a rand for run chance
            
               System.out.println("\tYou run away from the " + enemy );
            
               continue Game;   //the GAME: label allows us to continue from the top loop.
            }
            
            
            else {
            
               System.out.println("\tEnter a valid command");
            
            }
         
         
            if(playerHealth < 1) {
            
               System.out.println("\tYou weakly limb away from the monster, feeling defeated.");
               break;
            }
         
         //Enemy defeat line
         
            System.out.println("--------------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated # ");
            System.out.println(" # You have " + playerHealth + " HP left  #");
            if(rand.nextInt(100) < healthPotDrop) {
            
               numHealthPot++;
               System.out.println(" # The " + enemy + " dropped a health potion ");
               System.out.println(" # You now have " + numHealthPot + " Health Potions");
            }    
            System.out.println("-----------------------------------------------------");
            System.out.println("What are you going to do now?");
            System.out.println("Next Enemy"); //1
            System.out.println("Exit Area"); //2
            
            String in = s.nextLine();
            
            while (!in.equals("1") && !in.equals("2")) { //handles exception for loop
               System.out.println("Please enter a valid command");
                     
               
               in = s.nextLine();
               
            }
            
            if(in.equals("1")) {
               System.out.println("You continue through the area");
            
            }
            
            else if(in.equals("2")){
               System.out.println("You exit the area");
               
            
               break Game;
            }
            
         
         
         }  
      }
      System.out.println("######################");
      System.out.println("###Version 00.0001b###");
      System.out.println("######################");
      System.out.println("Thanks for Playing"); 
   }
    
        
        
}
    

//Write GUI for commands elements
//implement random text generator
//add more monsters
//add magic system
    
