package firstprogram;

public class fungsi {
    public static int tambah(int a,int b){
        return a+b;
    }
    public static int kuadrat(int x){
        return  x*x;
    }
    public static void main(String[] args){
        int hasiltambah =  tambah(5,3);
        int hasilkuadrat = kuadrat(3);

        System.out.println("Hasil pertambahan = "+hasiltambah);
        System.out.println("Hasil kuadrat = "+hasilkuadrat);
    }
}
