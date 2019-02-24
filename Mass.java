import java.util.Random;

public class Mass {
    Random random = new Random();
    int []mass;

    public Mass(int size) {
        this.mass = new int[size];
    }

    public int[] elDel(int elForDel, int[]mass) {
        int[] massNew = new int[mass.length - 1];
        int j = 0;
        if (isFind(elForDel, mass)){
            for (int i = 0; i < mass.length; i++) {
                    if (mass[i] != elForDel) {

                        massNew[j] = mass[i];
                        j++;
                    }
             }
            return massNew;
        }
     else return mass;
    }

public boolean isFind(int el ,int[]mass){
    for (int i = 0; i <mass.length ; i++) {
        if (mass[i] == el)return true;

    }
    return false;
}

public int[] addEl(int[]mass , int el, int pos){
        int[] newmass = new int[mass.length+1];
        int j = 0;
    for (int i = 0; i <mass.length+1 ; i++) {
         if (i!=pos){
             newmass[i]= mass[j];
             j++;
         }
         else newmass[i]=el;
    }

return newmass;
}

public int[] fillMass(int[]mass){
    for (int i = 0; i <mass.length ; i++) {
        mass[i]=random.nextInt(10000);
    }
    return mass;
}

public static int[] bubleSort(int [] mass){
int temp;
            for (int i = mass.length-1; i >=0 ; i--) {
                for (int j = 1; j <=i ; j++) {
                    if (mass[j]<mass[j-1]){
                        temp = mass[j];
                        mass[j] = mass[j-1];
                        mass[j-1]= temp;
        }
        }
    }
return mass;
    }

    public static int[] markerSort(int[]mass){
        int temp;

        for (int j = 0; j <mass.length ; j++) {
            int mark=j;
            for (int k = j; k <mass.length ; k++) {
                if (mass[k]<mass[mark]) mark = k;

            }
            temp = mass[j];
            mass[j] = mass[mark];
            mass[mark]=temp;
        }

    return mass;
    }
    public static int [] sortInsert(int[]mass){
        int temp;
        for (int i = 1; i <mass.length ; i++) {
            for (int k = i; k >0; k--) {
                if (mass[k]<mass[k-1]){
                    temp = mass[k];
                    mass[k]=mass[k-1];
                    mass[k-1]=temp;
                }
            }
        }
return mass;
    }
public static boolean binarySearch(int[]mass , int value){
        int low = 0;
        int mid;
        int hight = mass.length -1;
        while (low<=hight){
            mid = (low + hight)/2;
            if (value == mass[mid]) return true;
            else if (value > mass[mid])low = mid+1;
            else hight = mid -1;
        }


return false;
}
    public static void main(String[] args) {
       Mass mass = new Mass(1000);
       long t1;
       long t2;
       t1=System.currentTimeMillis();
       bubleSort(mass.mass);
       t2 =System.currentTimeMillis();
        System.out.println("Пузырьковая сортировка заняла "+ (t2-t1)+"мс");
        long t3;
        long t4;
        t3 = System.currentTimeMillis();
        sortInsert(mass.mass);
        t4 = System.currentTimeMillis();
        System.out.println("Сортировка вставкой заняла "+ (t4-t3)+"мс");
        long t5;
        long t6;
        t5 = System.currentTimeMillis();
        markerSort(mass.mass);
        t6 = System.currentTimeMillis();
        System.out.println("Сортировка маркером заняла "+ (t6-t5)+"мс");

    }
}





