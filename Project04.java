import java.util.*;
import java.io.*;
/*
 *@author Seisembayev Zhandos 
 */
public class Project04 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(new FileReader("a.txt"));
		String[] a = new String[15];
		int win = 0;
		int lose = 0;
		for(int i = 0; sc.hasNext(); i++){
			a[i] = sc.nextLine();
		}
		while(true){
			System.out.println("Do you want to play?");
			System.out.println("You win :" + " " + win + " " + "times");
			System.out.println("You lose :" + " " + lose + " " + "times");
			String s = in.next();
			if(!s.equals("Y") && !s.equals("y")){
				System.out.println("Goodbye");
				return;
			}
			int q = (int) (Math.random() * a.length);
			String word = a[q];
			word = word.toUpperCase();
			System.out.println("Let`s start");
			char[] question = new char[word.length()];
			for(int i = 0; i < word.length(); i++){
				question[i] = '?';
			}
			boolean check = false;
			int attempt = 0;
			String was = "";
			while(check == false && attempt < 10){
				boolean proverka = false;
				s = in.next();
				s = s.toUpperCase();
				for(int i = 0; i < was.length(); i++){
					if(was.charAt(i) == s.charAt(0))
					proverka = true;
				}
				if(proverka == true){
					System.out.println("You should choose another letter");
				}
				else{
					was += s.charAt(0);
				for(int i = 0; i < word.length(); i++){
					if(word.charAt(i) == s.charAt(0))
						question[i] = s.charAt(0);
				}
				attempt++;
				q = 0;
				System.out.print("Your current status : ");
				for(int i = 0; i < word.length(); i++){
					if(question[i] == '?')
						q++;
					System.out.print(question[i]);
				}
				if(q == 0)
					check = true;
			}
			}
			System.out.println();
			if(q == 0){
				win++;
			System.out.println("You win!!!");
			}
			else{
				lose++;
			System.out.println("You lose!!!");
			}
			System.out.println("Hidden word was:" + word);
		}
	}

}
