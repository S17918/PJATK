package MP01;

/*
    Piotr Wasilewski
    S17918
*/

public abstract class Pracownik_Skoczni extends Osoba{

    public String hireDate;
    public int salary;
    public int minSalary = 2200;
    public int premia;
    public int returnSalary;

    public Pracownik_Skoczni(String Imie, String Nazwisko, String Plec, String Pesel, String dataZatrudnienia, int pensja, int premia){
        super(Imie, Nazwisko, Plec, Pesel);

        this.hireDate = dataZatrudnienia;
        this.salary = pensja;
        this.premia = premia;
    }

    public int getSalary() {
        if(salary <= minSalary){
            System.out.println("Error Salary is too low");
        }else{
            returnSalary = salary;
        }
        return returnSalary;
    }

    public int getSalary(int premia){
        if((salary + premia) <= minSalary){
            System.out.println("Error Salary is too low");
        }else{
            returnSalary = salary + premia;
        }
        return returnSalary;
    }
}