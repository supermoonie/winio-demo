package xyz.supermoonie.winio;

public class VirtualKeyBoard {
	
	public static void main(String[] args) throws Exception {
		Thread.sleep(3000);
		String s="helloworld";
		for (int i = 0; i < s.length(); i++) {
			KeyPress(VKMapping.toScanCode(""+s.charAt(i)));
			Thread.sleep(1000L);
		}
		
	}
	public static void KeyDown(int key) throws Exception{
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.CONTROL_PORT,0xd2,1);
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.DATA_PORT,key,1);
	}
	public static void KeyDownEx(int key) throws Exception{
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.CONTROL_PORT,0xd2,1);
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.DATA_PORT,0xe0,1);
		
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.CONTROL_PORT,0xd2,1);
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.DATA_PORT,key,1);
		
	}
	public static void KeyUpEx(int key) throws Exception{
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.CONTROL_PORT,0xd2,1);
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.DATA_PORT,0xe0,1);
		
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.CONTROL_PORT,0xd2,1);
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.DATA_PORT,(key|0x80),1);
		
	}
	public static void KeyUp(int key) throws Exception{
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.CONTROL_PORT,0xd2,1);
		WinIOAPI.KBCWait4IBE();
		WinIOAPI.SetPortVal(WinIOAPI.DATA_PORT,(key|0x80),1);
		
	}
	
	public static void KeyPress(int key) throws Exception{
		KeyDown(key);
		KeyUp(key);
	}

}