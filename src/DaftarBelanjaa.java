import java.util.ArrayList;
import java.util.List;

public class DaftarBelanjaa {

    private final List<ItemBelanja> daftarBelanja = new ArrayList<>();

    public void tambahItem(ItemBelanja item) {
        if (item == null) {
            System.out.println("Item tidak boleh null.");
            return;
        }
        daftarBelanja.add(item);
        System.out.println("✅ Item '" + item.getNamaItem() + "' berhasil ditambahkan.");
    }

    public void hapusItem(int index) {
        if (index < 0 || index >= daftarBelanja.size()) {
            System.out.println("⚠️ Index tidak valid. Gagal menghapus item.");
            return;
        }
        ItemBelanja removedItem = daftarBelanja.remove(index);
        System.out.println("❌ Item '" + removedItem.getNamaItem() + "' berhasil dihapus.");
    }

    public void tampilkanSemuaItem() {
        if (daftarBelanja.isEmpty()) {
            System.out.println("🛒 Daftar belanja kosong.");
            return;
        }

        System.out.println("📝 Daftar Belanja:");
        for (int i = 0; i < daftarBelanja.size(); i++) {
            System.out.println(i + ". " + daftarBelanja.get(i));
        }
    }

    // Getter jika dibutuhkan di luar kelas
    public List<ItemBelanja> getDaftarBelanja() {
        return new ArrayList<>(daftarBelanja); // Return copy agar list asli aman
    }
}
