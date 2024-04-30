public class XmasTreeKadai {

    public static void main(String[] args) {
        for(int i=0; i<19; i++){
            for(int j=i; j<18; j++){
                if(j % 2 == 0){
                    System.out.print("+");
                }else{
                    System.out.print(" ");
                }
            }
            for(int k=0; k<2*i; k++){
                System.out.print("*");
            }
            System.out.print(" ");
            for(int j=38; j>i+18; j--){
                if(j % 2 == 0){
                    System.out.print("+");
                        }else{
                    System.out.print(" ");
                        }
                }
            System.out.println();
        }
       for(int i=0; i<7; i++){
        for(int l=0; l<38; l++){
            if(l < 19 && l > 19-3){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    }
}
//https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Integer.html