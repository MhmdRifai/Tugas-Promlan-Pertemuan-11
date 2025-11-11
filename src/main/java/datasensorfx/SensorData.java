package datasensorfx;

import java.time.LocalDateTime;

public class SensorData {
    private LocalDateTime waktu;
    private double suhu;
    private double kelembapan;
    private double gas;

    public SensorData(LocalDateTime waktu, double suhu, double kelembapan, double gas) {
        this.waktu = waktu;
        this.suhu = suhu;
        this.kelembapan = kelembapan;
        this.gas = gas;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalDateTime waktu) {
        this.waktu = waktu;
    }

    public double getSuhu() {
        return suhu;
    }

    public void setSuhu(double suhu) {
        this.suhu = suhu;
    }

    public double getKelembapan() {
        return kelembapan;
    }

    public void setKelembapan(double kelembapan) {
        this.kelembapan = kelembapan;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }
}
