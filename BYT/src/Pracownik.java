import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pracownik {

    public String Name;
    public String Surname;
    public String phoneNumber;
    public String workplace;

    private Pracownik(String Imie, String Nazwisko, String daneTele, String stanowisko){
        this.Name = Imie;
        this.Surname = Nazwisko;
        this.phoneNumber = daneTele;
        this.workplace = stanowisko;
    }

    class FormularzCzasuPracy {
        Date data;
        int przepracowaneGodziny;
        Pracownik pracownik;

        private FormularzCzasuPracy(Pracownik pracownik, Date data, int godziny) {
            this.pracownik = pracownik;
            this.data = data;
            this.przepracowaneGodziny = godziny;
        }

        public void createFormularz(Date data, int liczbaGodzin) {
            ogolnyCzasPracy.add(new FormularzCzasuPracy(pracownik, data, liczbaGodzin));
        }

        List<FormularzCzasuPracy> ogolnyCzasPracy = new ArrayList<>();

        void wypelnijFormularzCzasuPracy(Date data, int liczbaGodzin) {
            createFormularz(data, liczbaGodzin);
        }
    }
}
