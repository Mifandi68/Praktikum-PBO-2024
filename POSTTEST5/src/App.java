import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public final class App{
    private final static ArrayList<Member> memberList = new ArrayList<>();
    private final static ArrayList<Membership> membershipList = new ArrayList<>();
    private static int memberId = 1;
    private static Garis garis1;
    private static Garis garis2;

    public static void main(String[] args) {
        ScreenClearer.clearScreen();
        garis1 = new Garis(170, true);
        garis2 = new Garis(170, false);
        Scanner pilihan = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== AI FITNESS GYM MANAGEMENT ===");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Display Anggota");
            System.out.println("3. Update Anggota");
            System.out.println("4. Delete Anggota");
            System.out.println("5. Keluar");
            System.out.print("input Pilihan: ");
            int choice = pilihan.nextInt();

            if (choice == 1) {
                addMember(pilihan);
            } else if (choice == 2) {
                displayMembers();
            } else if (choice == 3) {
                updateMember(pilihan);
            } else if (choice == 4) {
                deleteMember(pilihan);
            } else if (choice == 5) {
                exit = true;
                ScreenClearer.clearScreen();
                System.out.println("Selamat Tinggal!");
            } else {
                System.out.println("Pilihan Tidak Ditemukan");
            }
        }
        pilihan.close();
    }

    private static void addMember(Scanner tambah) {
        ScreenClearer.clearScreen();
        tambah.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = tambah.nextLine();
        System.out.print("Masukkan Umur: ");
        int umur = tambah.nextInt();
        tambah.nextLine(); 
        System.out.print("Masukkan Alamat: ");
        String alamat = tambah.nextLine();
        System.out.print("Masukkan Jenis Kelamin(L/P): ");
        String jenisKelamin = tambah.nextLine();
        System.out.print("Masukkan Nomor HP: ");
        String noHp = tambah.nextLine();
        System.out.print("Masukkan Tanggal Mulai (YYYY-MM-DD): ");
        String tanggalMulai = tambah.nextLine();
        int pilihanMembership;
        do {
            ScreenClearer.clearScreen();
            System.out.println("\nPilih Jenis Membership:");
            System.out.println("1. Bronze (1 Bulan)");
            System.out.println("2. Silver (3 Bulan)");
            System.out.println("3. Gold (6 Bulan)");
            System.out.print("Masukkan Pilihan: ");
            pilihanMembership = tambah.nextInt();
        } while (pilihanMembership < 1 || pilihanMembership > 3);
        
        Membership membership;
        double membershipFee;
        switch (pilihanMembership) {
            case 1:
                membership = new BronzeMembership(memberId, tanggalMulai);
                membershipFee = MembershipDiscount.calculateMembershipFee("Bronze", 10);
                break;
            case 2:
                membership = new SilverMembership(memberId, tanggalMulai);
                membershipFee = MembershipDiscount.calculateMembershipFee("Silver", 10);
                break;
            case 3:
                membership = new GoldMembership(memberId, tanggalMulai);
                membershipFee = MembershipDiscount.calculateMembershipFee("Gold", 10);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan masukkan pilihan yang benar.");
                return;
        }
        
        memberList.add(new Member(memberId, nama, umur, alamat, jenisKelamin, noHp));
        membershipList.add(membership);

        System.out.println("Member Berhasil Ditambah.");
        System.out.println("Membership Fee: $" + membershipFee);
        memberId++;
    }

    private static void displayMembers() {
        if (memberList.isEmpty()) {
            ScreenClearer.clearScreen();
            System.out.println("Data Masih Kosong");
        } else {
            ScreenClearer.clearScreen();
            garis1.draw();
            System.out.printf("%-10s | %-20s | %-10s | %-20s | %-15s | %-20s | %-15s | %-15s | %-15s\n",
                            "ID MEMBER", "Nama", "Umur", "Alamat", "Jenis Kelamin", 
                            "Nomor Telepon", "Jenis Membership", "Tanggal Mulai", "Tanggal Berakhir");
            garis1.draw();
            for (int i = 0; i < memberList.size(); i++) {
                Member member = memberList.get(i);
                Membership membership = membershipList.get(i);
                System.out.printf("%-10s | %-20s | %-10s | %-20s | %-15s | %-20s | %-15s  | %-16s| %-16s\n",
                                member.getMemberID(), member.getNama(), member.getUmur(), member.getAlamat(), member.getJenisKelamin(), 
                                member.getNomorTelepon(), membership.getJenisPaket(), membership.getTanggalMulai(), membership.getTanggalBerakhir());
                garis2.draw();
            }
        }
    }

    private static void updateMember(Scanner scanner) {
        ScreenClearer.clearScreen();
        if (memberList.isEmpty()) {
            System.out.println("Data Masih Kosong");
        } else {
            displayMembers();
            System.out.print("Pilih ID Member Yang Ingin di Ubah: ");
            int memberId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            int index = -1;
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getMemberID() == memberId) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                Member member = memberList.get(index);
                System.out.println("1. Ubah Data Anggota");
                System.out.println("2. Ubah Jenis Keanggotaan");
                System.out.print("Masukkan Pilihan: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        updateMemberData(member, scanner);
                        break;
                    case 2:
                        updateMembershipType(member, scanner);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } else {
                System.out.println("Tidak Ada Member Dengan ID :" + memberId);
            }
        }
    }

    private static void updateMemberData(Member member, Scanner scanner) {
        System.out.print("Masukkan Nama Baru: ");
        String nama = scanner.nextLine();
        member.setNama(nama);
        System.out.print("Masukkan Umur Baru: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // consume newline
        member.setUmur(umur);
        System.out.print("Masukkan Alamat Baru: ");
        String alamat = scanner.nextLine();
        member.setAlamat(alamat);
        System.out.print("Masukkan Jenis Kelamin Baru (L/P): ");
        String jenisKelamin = scanner.nextLine();
        member.setJenisKelamin(jenisKelamin);
        System.out.print("Masukkan Nomor Telepon Baru: ");
        String noHp = scanner.nextLine();
        member.setNomorTelepon(noHp);

        System.out.println("Data Berhasil di Perbarui.");
    }

    private static void updateMembershipType(Member member, Scanner scanner) {
        System.out.println("1. Bronze (1 Bulan)");
        System.out.println("2. Silver (3 Bulan)");
        System.out.println("3. Gold (6 Bulan)");
        System.out.print("Masukkan Pilihan Jenis Keanggotaan Baru: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Membership newMembership = null;
        double membershipFee;
        switch (choice) {
            case 1:
                membershipFee = MembershipDiscount.calculateMembershipFee("Bronze");
                newMembership = new BronzeMembership(member.getMemberID(), LocalDate.now().toString());
                break;
            case 2:
                membershipFee = MembershipDiscount.calculateMembershipFee("Silver");
                newMembership = new SilverMembership(member.getMemberID(), LocalDate.now().toString());
                break;
            case 3:
                membershipFee = MembershipDiscount.calculateMembershipFee("Gold");
                newMembership = new GoldMembership(member.getMemberID(), LocalDate.now().toString());
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        int index = memberList.indexOf(member);
        membershipList.set(index, newMembership);

        System.out.println("Jenis Keanggotaan Berhasil di Perbarui.");
        System.out.println("Total Harga Membership: $" + membershipFee);
    }

    private static void deleteMember(Scanner hapus) {
        ScreenClearer.clearScreen();
        if (memberList.isEmpty()) {
            System.out.println("Data Masih Kosong");
        } else {
            displayMembers();
            System.out.print("Pilih ID Member Yang Ingin di Hapus: ");
            int memberId = hapus.nextInt();
            hapus.nextLine(); // consume newline

            int index = -1;
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getMemberID() == memberId) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                memberList.remove(index);
                membershipList.remove(index);
                System.out.println("Member Berhasil di Hapus");
            } else {
                System.out.println("Tidak Ada Member Dengan ID :" + memberId);
            }
        }
    }

}