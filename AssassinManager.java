import java.util.*;

public class AssassinManager {

   private AssassinNode killring;
   private AssassinNode graveyard;
    
    /**
    * Constructs an AssassinManager with a give list of player names.
    * Initializes the kill ring with the names provided.
    *
    * @param names List of names to initialize the kill ring.
    * @throws IllegalArgumentException if the list is empty.
    */
    
   public AssassinManager (List<String> names) {
      if (names.isEmpty()) throw new IllegalArgumentException();
      // Initialize the kill ring with the first player
      killring = new AssassinNode (names.get(0));
      for (int i = 1; i < names.size(); i++) {
         AssassinNode current = killring;
         // Traverse to the end of the list to add the next player
         while (current.next != null) {
            current = current.next;
         }
         current.next = new AssassinNode (names.get(i));
      }
    
    
   }

    /**
    * Prints the current state of the kill ring.
    * Each player and their target (the person they are stalking) is displayed.
    */
   public void printKillRing() {
      AssassinNode current = killring;
      String front = killring.name;// first person in the killring so the last person can target them
      while (current != null){
         if (current.next ==null){
         // Print the player and who they are stalking (person infront of them in the kill ring)
            System.out.println( current.name + " is stalking " + front );
         }
         else {
            System.out.println( current.name + " is stalking " + current.next.name );
         }
         current = current.next;
      }
   }
 
    /**
    * Prints the current graveyard, displaying the name of each killed player
    * and the killer's name.
    */  
   public void printGraveyard() {
      AssassinNode current = graveyard;
      while (current != null){
         System.out.println("    " + current.name + " was killed by " +current.killer);
         current=current.next;
      }
   }
   /**
    * Checks if a given name exists in the kill ring.
    *
    * @param name Name to search for in the kill ring.
    * @return true if the name exists in the kill ring, false otherwise.
    */  
   public boolean killRingContains (String name) {
      AssassinNode current = killring;      
      while (current != null){      
         if (current.name.equalsIgnoreCase(name)) return true;
         current = current.next;
      }
      return false;     
   }
   
    /**
    * Checks if a given name exists in the graveyard.
    *
    * @param name Name to search for in the graveyard.
    * @return true if the name exists in the graveyard, false otherwise.
    */ 
   public boolean graveyardContains (String name) {
      AssassinNode current = graveyard;      
      while (current != null){      
         if (current.name.equalsIgnoreCase(name)) return true;
         current= current.next;
      }
      return false;
   }
    /**
    * Determines if the game is over, meaning there is only one player left in the kill ring.
    *
    * @return true if the game is over (only one player left), false otherwise.
    */
   
   public boolean gameOver() {
      return killring.next == null && killring != null;
   }

    /**
    * Returns the name of the winner if the game is over (only one player left in the kill ring).
    * 
    * @return the name of the winner, or null if the game is not over.
    */
    
   public String winner () { 
      if (killring.next == null) return killring.name; // Return the name of the last remaining player 
      else return null;// returns null since game is not over
   }
   
    /**
    * Records the killing of a player with the given name.
    * Removes the player from the kill ring and moves them to the graveyard.
    *
    * @param name is the Name of the player to be killed.
    * @throws IllegalArgumentException if the name is not in the kill ring.
    * @throws IllegalStateException if the game is already over (no players left).
    */
   public void kill(String name) {
      if (killring.next == null) throw new IllegalStateException("The game is over.");
      if (!killRingContains(name)) throw new IllegalArgumentException("This name is not in the kill ring.");
   
      AssassinNode current = killring;
      AssassinNode prev = null;
   
      // Locates the player thats going to get killed
      while (current != null && !current.name.equalsIgnoreCase(name)) {
         prev = current;
         current = current.next;
      }
   
      // Remove the player from the kill ring and update the killring
      if (prev == null) killring = killring.next;
       else prev.next = current.next;

   
      // Puts the killed player into the graveyard
      if (prev == null) {
         AssassinNode end = killring;
         if (end != null) current.killer = end.name; 
         else current.killer = null;
      }
      else current.killer = prev.name;
      current.next = graveyard;
      graveyard = current;
   }
}
/* debugging process
* i would run my code in the debugging mode i would use the structure view
* to check if all of the names fromthe files would tranfer to the kill ring
* then when i would elimintae a playeri would check the structure to make 
sure the player moved from the kill ring to the grave yard as well as
*making sure the killer would get appointed a new target. i kept doing this until
* the end of the game where i would check if there was one player lef in hte kill ring
* then the code would read out the winner aswell as who killed who in the gave yard.
*/