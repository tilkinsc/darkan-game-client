public class Preference_Sub21 extends Preference {

	public Preference_Sub21(int i_1, Node_Sub54 class282_sub54_2) {
		super(i_1, class282_sub54_2);
	}

	public void method12861() {
		if (this.anInt5578 < 0 || this.anInt5578 > 4) {
			this.anInt5578 = this.method7781(1833294862);
		}

	}

	int method7785(int i_1, int i_2) {
		return 1;
	}

	public Preference_Sub21(Node_Sub54 class282_sub54_1) {
		super(class282_sub54_1);
	}

	int method7784(int i_1) {
		return 1;
	}

	void method7780(int i_1) {
		this.anInt5578 = -754033619 * i_1 * -859024475;
	}

	public int method12865() {
		return this.anInt5578;
	}

	int method7781(int i_1) {
		return 3;
	}

	void method7783(int i_1) {
		this.anInt5578 = i_1;
	}

	int method7786() {
		return 3;
	}

	int method7787() {
		return 3;
	}

	public static void method12869(boolean bool_0, int i_1) {
		if (client.anInt7341 != 2 && client.anInt7341 != 1) {
			if (!bool_0) {
				CutsceneAction[] arr_2 = Class86.aCutsceneActionArray822;

				for (int i_3 = 0; i_3 < arr_2.length; i_3++) {
					CutsceneAction class96_4 = arr_2[i_3];
					class96_4.method1593();
				}
			}

			client.anInt7341 = 2;
			NativeLibraryLoader.anIntArrayArray3239 = null;
			Class276.aNode_Sub35_3346 = null;
			client.aBool7321 = false;
			Class79.method1390(2119033925);
			TCPPacket tcpmessage_5 = Class271.createPacket(OutgoingPacket.aClass379_4572, client.outputContext.isaac);
			tcpmessage_5.buffer.writeByte(bool_0 ? 1 : 0);
			client.outputContext.queuePacket(tcpmessage_5);
		}

	}

}