package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto;

import java.util.List;

public class FlorDTO {
    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor = "Fora UE";

    //llista de paisos
    private final List<String> paisosUE = List.of(
            "Albania", "Alemania", "Andorra", "Armenia", "Austria", "Azerbaiyán", "Bélgica",
            "Bielorrusia", "Bosnia y Herzegovina", "Bulgaria", "Chipre", "Croacia", "Dinamarca",
            "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Georgia", "Grecia",
            "Hungría", "Irlanda", "Islandia", "Italia", "Letonia", "Liechtenstein", "Lituania",
            "Luxemburgo", "Macedonia del Norte", "Malta", "Moldavia", "Mónaco", "Montenegro", "Noruega",
            "Países Bajos", "Polonia", "Portugal", "Reino Unido", "República Checa", "Rumania", "Rusia",
            "San Marino", "Serbia", "Suecia", "Suiza", "Turquía", "Ucrania", "Vaticano");

    public FlorDTO() {
    }

    public FlorDTO(int pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        setTipusFlor(paisFlor);
    }


    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    public String getTipusFlor() {
        return tipusFlor;
    }

    public void setTipusFlor(String tipusFlor) {
        this.tipusFlor = tipusFlor;
    }

    @Override
    public String toString() {
        return "FlorDTO{" +
                "pk_FlorID=" + pk_FlorID +
                ", nomFlor='" + nomFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                ", tipusFlor='" + tipusFlor + '\'' +
                ", paisosUE=" + paisosUE +
                '}';
    }
}
