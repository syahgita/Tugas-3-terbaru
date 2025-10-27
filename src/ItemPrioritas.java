public class ItemPrioritas extends ItemBelanja {
    private String prioritas;

    public ItemPrioritas(String namaItem, int jumlah, String prioritas) {
        super(namaItem, jumlah);
        setPrioritas(prioritas);
    }

    public String getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(String prioritas) {
        if (prioritas == null || prioritas.isBlank()) {
            throw new IllegalArgumentException("Prioritas tidak boleh kosong.");
        }
        this.prioritas = prioritas.trim();
    }

    @Override
    public String toString() {
        return String.format("%s, Prioritas: %s", super.toString(), prioritas);
    }
}
