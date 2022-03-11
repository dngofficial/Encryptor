import java.util.Arrays;

public class MoreTesting {
    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor(4, 3);
        String decryptedMsg = encryptor.decryptMessage("Kyi,r i,r bTr bKyhbKyi!atamohd' euo sn  uk ayslnoi,r bwr bKy bKyi!Kyi,r H  r  ets ts'htohhseafeowem nu!'ot   srhytH eaohi stxmnh  i kegmmp,'oauini,r bkr bKy bKyi'Kyi,rs  !'o'to sm hnH ireeecnigb yH haaaectct!'o k  smirtct!ni k  'gb yG haaaivtlaoee  tu  at 'gilhyvotay ys,kov t eueb t rreshHlntgoe d ht's rt leii b you aaarryct  eek fs,ahAAAAA!AAAAAAAAAAAAAAAAA");
        System.out.println(decryptedMsg);
    }
}