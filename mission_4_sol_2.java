package mission4;

import java.util.Arrays;

public class RacingCarSol2 {
    private int id;
    private String model;
    private int year;
    private int engine;
    private int[] arr;
    private int insurance;

    // Constructor
    public RacingCarSol2(int id, String model, int year, int engine) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.engine = engine;
        int ins_ref=5000;
        int delt=0;
        if(engine!=2000) {
        	delt=(engine-2000)%100;
        	ins_ref+=delt*500;
        }
        if(year!=2020) {
        	delt=year-2020;
        	ins_ref-=delt*200;
        }
        if(ins_ref<0) {
        	ins_ref=1000;
        }
        this.insurance=ins_ref;
        this.arr = new int[6];
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getEngine() {
        return engine;
    }

    public int[] getArr() {
        return arr;
    }

    public int getInsurance() {
        return insurance;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }
    
    public void setInsurance(int insurance) {
    	this.insurance=insurance;
    }
    
    public void setScores(int score) {
    	for(int j=this.arr.length-1;j>0;j--) 
    	{
    		this.arr[j]=this.arr[j-1];
    	}
    	this.arr[0]=score;
    }
    
    public int delta() {
    	int min=this.arr[0];
    	int min_ind=0;
    	int max=this.arr[0];
    	int max_ind=0;
    	for (int i=0;i<this.arr.length;i++) 
    	{
    		if(this.arr[i]>max) {
    			max=this.arr[i];
    			max_ind=i;
    		}
    		if(this.arr[i]<min) {
    			min=this.arr[i];
    			min_ind=i;
    		}
    	}
    	if(max_ind<min_ind) {
    		return this.arr[max_ind]-this.arr[min_ind];
    	}
    	else {
    		return this.arr[min_ind]-this.arr[max_ind];
    	}
    }
    
    public static RacingCar[] worthwhile(RacingCar[] array) {
    	int count=0;
    	int j=0;
    	RacingCar[] build_arr=new RacingCar[6];
    	int count_build=0;
    	for(int i=0;i<array.length;i++)
    	{
    		if(array[i].getInsurance()<=5000 && array[i].delta()<0) {
    			build_arr[count_build]=array[i];
    			count_build++;
    			count++;
    		}
    	}
    	RacingCar[] arr=new RacingCar[count];
    	for(int i=0;i<count_build;i++)
    	{
    		arr[j]=build_arr[j];
    		j++;
    	}
    	return arr;
    }

    // Main method for testing
    public static void main(String[] args) {
        RacingCar car1 = new RacingCar(1, "Ferrari F1", 2022, 3000);
        RacingCar car2 = new RacingCar(2, "Ferrari F1", 2022, 2000);
        RacingCar car3 = new RacingCar(3, "Ferrari F1", 2022, 1600);
        System.out.println(car1.getInsurance());
        System.out.println(car2.getInsurance());
        System.out.println(car3.getInsurance());
        car1.setScores(60);
        car1.setScores(70);
        car1.setScores(80);
        car1.setScores(90);
        car1.setScores(100);
        car1.setScores(60);
        car1.setScores(40);
        car2.setScores(60);
        car2.setScores(70);
        car2.setScores(80);
        car2.setScores(90);
        car2.setScores(100);
        car2.setScores(60);
        car2.setScores(40);
        car3.setScores(60);
        car3.setScores(70);
        car3.setScores(80);
        car3.setScores(90);
        car3.setScores(100);
        car3.setScores(60);
        car3.setScores(40);
        RacingCar[] array= {car1,car2,car3};
        RacingCar[] arr=worthwhile(array);
        for(int i=0;i<arr.length;i++) {
        	System.out.println(arr[i].getId());
        }
        
    }
}
