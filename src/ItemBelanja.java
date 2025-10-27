public class ItemBelanja {
    private String namaItem;
    private int jumlah;

    public ItemBelanja(String namaItem, int jumlah) {
        setNamaItem(namaItem);
        setJumlah(jumlah);
    }

    public String getNamaItem() {
        return namaItem;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setNamaItem(String namaItem) {
        if (namaItem == null || namaItem.isBlank()) {
            throw new IllegalArgumentException("Nama item tidak boleh kosong.");
        }
        this.namaItem = namaItem.trim();
    }

    public void setJumlah(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0.");
        }
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return String.format("Item: %s, Jumlah: %d", namaItem, jumlah);
    }
}
