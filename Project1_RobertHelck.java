import java.util.Scanner;

public class Project1_RobertHelck{
    public static void main(String[] args){
 //these are integer values for the for-loops
        int i;
        int x;
        int y;
        int z;

//these are variables that are used in the for loops
        String consonantsTwo = "pkhlmn' ";
        String outputWord = "";
        String vowels = "aeiou";
        String[] transVowels = {"ah","eh","ee","oh","oo"};
        String[] diphthongs = {"ai","ae","ao","au","ei","eu","iu","oi","ou","ui"};
        String[] transDiphthongs = {"eye","eye","ow","ow","ay","eh-oo","ew","oy","ow","ooey"};
        Scanner scnr = new Scanner(System.in);
        Scanner scnr2 = new Scanner(System.in);
        char lastVowel = 'a';
        String command = "y";
        Boolean notHawaiian = false;

//Here is the main part of the code, where the diphthongs (double vowels), vowels, and consontants are evaluated.
        while(command.equals("y") || command.equals("Y")){
            String userInput = "";
            outputWord = "";
            System.out.println("Enter a Hawaiian word to pronounce");
            userInput = scnr.nextLine().toLowerCase();
            first:
            for(i = 0;i<userInput.length();++i){
                Boolean hasDip = false;
                Boolean hasCon = false;
                Boolean hasVow = false;
                notHawaiian = false;
//The diphthong evaluation for loop
                for(z=0; z<diphthongs.length; ++z){
                    if(((i != userInput.length()-1) && (userInput.charAt(i)+""+userInput.charAt(i+1)).equals(diphthongs[z]))){
                        outputWord = outputWord + transDiphthongs[z]+"-";
                        hasDip = true;
                            if(userInput.length()-(i+1)>1){
                                i = i + 2;
                            }
                            else if(userInput.length()-(i+1)<=1){
                                break first;
                            }
                            }
                        }
//The consonant evaluation for loop
                for(x = 0; x<consonantsTwo.length(); ++x){
                    if(userInput.charAt(i) == consonantsTwo.charAt(x)){
                        outputWord = outputWord + consonantsTwo.charAt(x);
                        hasCon = true;
                    }
                }
//The vowel evaluation for loop
                for(y=0; y<vowels.length(); ++y){
                    if((userInput.charAt(i)==vowels.charAt(y)) && (i == userInput.length()-1)){
                            outputWord = outputWord + transVowels[y]+"";
                            hasVow = true;
                        }
                    else if((userInput.charAt(i)==vowels.charAt(y))){
                        outputWord = outputWord + transVowels[y]+"-";
                        hasVow = true;
                        lastVowel = userInput.charAt(i);
                    }
                }
//The w evaluation for loop, which decides to print w or v depending on the vowels
                if ((""+userInput.charAt(i)).equals("w")){
                    if (lastVowel == 'e' || lastVowel == 'i'){
                        outputWord = outputWord + "v";
                    }
                    else{
                        outputWord = outputWord + "w";
                    }
                }
//This checks to make sure that the word entered is Hawaiian
                if(hasCon==false && hasDip==false && hasVow==false){
                    System.out.println(userInput.charAt(i) + " is not a valid Hawaiian character");
                    notHawaiian = true;
                    break first;
                }
            }
            if(notHawaiian == false){
                System.out.println(userInput + " is pronounced " + outputWord);
            }
            System.out.println("Do you want to enter another word? y/Y/n/N");
            command = scnr2.next();
        }
    }
}