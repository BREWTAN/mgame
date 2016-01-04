package mauthlogin;


public class TestA1 {

	public static void main(String[] args) {
		System.out.println(String.format("%x", (24352)));
		System.out.println(String.format("%x", (24198)));
		System.out.println(String.format("%x", (30887)));
		
		try {
			System.out.println(new String(new byte[]{(byte)0xD6,(byte)0xD0,(byte)0xB9},"UTF8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
