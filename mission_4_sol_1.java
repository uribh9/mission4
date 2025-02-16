package mission4;

import java.util.Arrays;

public class RacingCar {
    private int id;
    private String model;
    private int year;
    private int engine;
    private int[] arr;
    private int insurance;

    // Constructor
    public RacingCar(int id, String model, int year, int engine) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.engine = engine;
        int count_eng=0;
        int count_year=0;
        while(engine!=2000) 
        {
        	if(engine>2000) {
        		engine=engine-100;
        		count_eng++;
        	}
        	else {
        		engine+=100;
        		count_eng--;
        	}
        }
        while(year!=2020) 
        {
        	if(year>2020) {
        		year--;
        		count_year--;
        	}
        	else {
        		year++;
        		count_year++;
        	}
        }
        this.insurance=5000+count_eng*500+count_year*200;
        if(this.insurance<0) {
        	this.insurance=1000;
        }
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

    public void setFeatures(int[] arr) {
        this.arr = arr;
    }
    
    public void setScores(int score) {
    	int tmp=0;
    	int tmp1=0;
    	for(int i=0;i<this.arr.length;i++)
    	{
    		tmp1=this.arr[i];
    		this.arr[i]=tmp;
    		tmp=tmp1;
    	}
    	this.arr[0]=score;
    }
    
    public int delta() {
    	int min=1000000;
    	int min_ind=0;
    	int max=0;
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
    	for(int i=0;i<array.length;i++)
    	{
    		if(array[i].getInsurance()<=5000 && array[i].delta()<0) {
    			count++;
    		}
    	}
    	RacingCar[] arr=new RacingCar[count];
    	for(int i=0;i<array.length;i++)
    	{
    		if(array[i].getInsurance()<=5000 && array[i].delta()<0) {
    			arr[j]=array[i];
    			j++;
    		}
    	}
    	return arr;
    }

    // Main method for testing
    public static void main(String[] args) {
        RacingCar car = new RacingCar(1, "Ferrari F1", 2022, 3000);
        System.out.println(car.getInsurance());
        car.setScores(60);
        System.out.println(car.delta());
        car.setScores(70);
        System.out.println(car.delta());
        car.setScores(80);
        System.out.println(car.delta());
        car.setScores(90);
        System.out.println(car.delta());
        car.setScores(100);
        System.out.println(car.delta());
        car.setScores(60);
        System.out.println(car.delta());
        car.setScores(40);
        System.out.println(car.delta());
        car.setScores(110);
        System.out.println(car.delta());
        
    }
}


