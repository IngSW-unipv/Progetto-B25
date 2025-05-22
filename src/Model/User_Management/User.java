package Model.User_Management;

import java.time.LocalDate;

public class User {
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String Fiscal_Code;
    private int user_id;
    private LocalDate birthday = estraiDataNascita(Fiscal_Code);
    private LocalDate Subscription_date;

    //creazione

    public User(String username, String password, String email, String name, String surname, String fiscal_Code) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.Fiscal_Code = fiscal_Code;
        Subscription_date = LocalDate.now();
    }



        public static LocalDate estraiDataNascita(String Fiscal_Code) {
            if (Fiscal_Code == null || Fiscal_Code.length() < 11) {
                throw new IllegalArgumentException("Codice fiscale non valido");
            }

            // Posizioni 6-7: anno (ultime due cifre)
            int anno = Integer.parseInt(Fiscal_Code.substring(6, 8));

            // Posizione 8: mese (lettera)
            char meseChar = Fiscal_Code.charAt(8);
            int mese = meseDaLettera(meseChar);

            // Posizioni 9-10: giorno (più 40 se femmina)
            int giorno = Integer.parseInt(Fiscal_Code.substring(9, 11));
            boolean isDonna = false;
            if (giorno > 40) {
                giorno -= 40;
                isDonna = true;
            }

            // Inferenza dell'anno completo (assumiamo persone nate dal 1900 al 1999 o 2000+)
            int annoCompleto = (anno >= 0 && anno <= LocalDate.now().getYear() % 100)
                    ? 2000 + anno
                    : 1900 + anno;

            return LocalDate.of(annoCompleto, mese, giorno);
        }

        private static int meseDaLettera(char mese) {
            switch (mese) {
                case 'A': return 1;
                case 'B': return 2;
                case 'C': return 3;
                case 'D': return 4;
                case 'E': return 5;
                case 'H': return 6;
                case 'L': return 7;
                case 'M': return 8;
                case 'P': return 9;
                case 'R': return 10;
                case 'S': return 11;
                case 'T': return 12;
                default: throw new IllegalArgumentException("Lettera mese non valida: " + mese);
            }
        }
}
