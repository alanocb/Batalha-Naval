import java.util.Random;
import java.util.Scanner;



public class jogo{

    Random r = new Random();
    int A[][];
    int submarinos;

    public jogo(){
       
        A = new int [10][10];
        submarinos = 5;
        escondeSubmarino();
        
    }
 
    public void menu(){

        Scanner scan = new Scanner(System.in);

        boolean termina = false;

        do{
            visualizaMatriz();
            System.out.println("Introduza o x?");
            scan = new Scanner(System.in);
            char x = scan.next().charAt(0); 
            System.out.println("Introduza o y?");
            scan = new Scanner(System.in);
            char y = scan.next().charAt(0);

            if(Character.getNumericValue(x)>=10 || Character.getNumericValue(y)>=10){
                System.out.println("Coordenadas invalidas");
                continue;
            }else{
                avaliartiro(Character.getNumericValue(x),Character.getNumericValue(y));
            }
            if (submarinos == 0){
                System.out.print("GANHASTE!!!!!!");
                termina = true;
            }



        }while(!termina);
    }
    public boolean avaliartiro(int x, int y){
        if (A[x][y] == 0){
            System.out.println("FALHOU");
            A[x][y] = 2;
            return false;
        }
        if (A[x][y] == 1){
            System.out.println("Acertaste");
            submarinos --;
            A[x][y] = 3;
            return true;
        }
        if (A[x][y] == 2){
            System.out.println("já tentaste");
            return false;
        }
        if (A[x][y] == 3){
            System.out.println("já tentaste");
            return false;
        }
        return false;
    }

    public void escondeSubmarino(){

        int ctd = 0;
        
        do{
            
            int l = r.nextInt(9);
            int c = r.nextInt(9);

            if( A[l][c]==0){

                ++ ctd;
                A[l][c]=1;
            }
        }while(ctd != submarinos);
    }

    public void visualizaMatriz(){

        System.out.print("\n \n");

        System.out.print("   ");
        for (int linha=0; linha<10; linha++){
            System.out.print(linha+" ");
        }
       

        for(int l=0; l<10 ; l++){
            
            System.out.print("\n "+ l +" ");
            

            for(int c=0; c<10; c++){
                

                if ( A[l][c]==0){
                    System.out.print("~ ");
                }
                if ( A[l][c]==1){
                    System.out.print("~ ");
                }
                if ( A[l][c]==2){
                    System.out.print("S ");
                }
                if ( A[l][c]==3){
                    System.out.print("X ");
                }
            }
        }
        System.out.print("\n \n");
    }  
}